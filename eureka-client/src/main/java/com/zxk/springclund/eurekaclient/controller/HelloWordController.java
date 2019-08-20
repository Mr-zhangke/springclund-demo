package com.zxk.springclund.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/helloword")
    public String helloword(){
        System.out.println("aaaaaaaaaaaa");
//        if(true){
//            throw new RuntimeException("测试服务调用熔断器");
//        }
        return "hello word from port "+port;
    }
}
