package com.jarluo.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @from: https://www.cnblogs.com/java333/
 * @desc: TODO
 * @author: jar luo
 * @date: 2019/10/2 22:44
 */
@RestController
public class EchoEnvController {
    private final Environment environment;

    @Autowired
    public EchoEnvController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/echo/env/{name}")
    public String environment(@PathVariable String name) {
        return environment.getProperty(name);
    }

    @GetMapping("echo1/env/{name}")
    public Map<String, String> environment1(@PathVariable String name) {
        Map<String, String> data = new HashMap<>();
        data.put(name, environment.getProperty(name));
        return data;
    }
}
