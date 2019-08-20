package com.zxk.springclund.servicefeign.service;

import com.zxk.springclund.servicefeign.service.impl.HelloWordServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用远程服务接口
 * @author zxk
 * 2019-07-26
 */
@FeignClient(value = "service-helloword", fallback = HelloWordServiceImpl.class)
public interface HelloWordService {

    @RequestMapping(value = "/helloword", method = RequestMethod.GET)
    String sayHello();
}
