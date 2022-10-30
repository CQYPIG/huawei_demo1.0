package com.cz.huawei_demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class Test {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/test")
    public String test(String s){
        redisTemplate.opsForValue().set("kkk", "vvv", 10, TimeUnit.SECONDS);
        return "";
    }
}
