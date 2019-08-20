package com.zxk.springclund.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${hello}")
    private String hello;

    @RequestMapping(value = "/getGitConfig")
    public String getGitconfig(){
        System.out.println("获取git配置");
        return hello;
    }
}
