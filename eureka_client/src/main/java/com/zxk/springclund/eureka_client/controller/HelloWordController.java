package com.zxk.springclund.eureka_client.controller;

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
        return "hello word from port "+port;
    }
}
