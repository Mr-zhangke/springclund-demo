package com.zxk.springclund.serviceribbon.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 负载均衡配置
 * @author zxk
 * 2019-07-26
 */
@Configuration
public class RestTemplateConfig {

    /**
     * @LoadBalanced 注册表明，这个restRemplate是需要做负载均衡的。
     * @Bean 注册了一个叫restTemplate的bean。
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
