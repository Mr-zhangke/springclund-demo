package com.zxk.springclund.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * helloword服务类
 * @author zxk
 * 2019-07-26
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 客户端负责平衡
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * restTemplate.getForObject方法会通过ribbon负载均衡机制， 自动选择一个Hello word服务，
     *
     * 这里的URL是“http://SERVICE-HELLOWORLD/"，其中的SERVICE-HELLOWORLD是Hello world服务的名字，而注册到服务中心的有两个SERVICE-HELLOWORLD。 所以，这个调用本质是ribbon-service作为客户端根据负载均衡算法自主选择了一个作为服务端的SERVICE-HELLOWORLD服务。然后再访问选中的SERVICE-HELLOWORLD来执行真正的Hello world调用。
     * @return
     */
    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getHelloContent(){

        //获取当前的服务提供者
//        ServiceInstance instance = loadBalancerClient.choose("service-helloword");
//        System.out.println("当前服务："+instance.getHost()+" : "+instance.getPort()+" : "+instance.getServiceId());
//        System.out.println(instance.getServiceId());
        /*******************************************以上没有也能进行负载均衡***********************************************************/

        //        客户端的负载均衡器
        String s = restTemplate.getForObject("http://service-helloword/helloword", String.class);
        System.out.println("跨服务调用helloword应用："+s);

        //Spring 提供两辆种服务调度方式：
        // Ribbon+restful和Feign。Ribbon就是一个基于客户端的负载均衡器， Ribbon提供了很多在HTTP和TCP客户端之上的控制.
        //Feign内部也已经使用了Ribbon, 所以只要使用了@FeignClient注解，那么这一章的内容也都是适用的。

        return s;
    }

    /**
     * 容错方法
     * @return
     */
    public String serviceFailure(){
        System.out.println("hello world service is not available");
        return "hello world service is not available";
    }
}
