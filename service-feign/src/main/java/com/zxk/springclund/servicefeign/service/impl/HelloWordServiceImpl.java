package com.zxk.springclund.servicefeign.service.impl;

import com.zxk.springclund.servicefeign.service.HelloWordService;
import org.springframework.stereotype.Component;

@Component
public class HelloWordServiceImpl implements HelloWordService {

    @Override
    public String sayHello() {
        System.out.println("hello world service is not available22 !");
        return "hello world service is not available22 !";
    }
}
