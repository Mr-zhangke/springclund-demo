package com.zxk.springclund.serviceribbon.controller;

import com.zxk.springclund.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloword消费端
 * @author zxk
 * 2019-07-26
 */
@RestController
public class HelloCustomerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/getHelloWord")
    public String helloword(){
        System.out.println("消费helloword开始");
        String s = helloService.getHelloContent();
        return s;
    }
}
