package com.zxk.springclund.servicefeign.controller;

import com.zxk.springclund.servicefeign.service.HelloWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者
 * @author zxk
 * 2019-07-26
 */
@RestController
public class HelloWordController {

    @Autowired
    private HelloWordService helloWordService;

    @RequestMapping("/helloword")
    public String helloword(){
        System.out.println("======================================调用远程服务开始");
        String s = helloWordService.sayHello();
        System.out.println("======================================调用远程服务结束"+s);
        return s;
    }

}
