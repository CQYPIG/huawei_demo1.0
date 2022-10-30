package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        RedisTemplate redisTemplateCustomize = run.getBean("redisTemplateCustomize",RedisTemplate.class);
        System.out.println("@@@@@@@@@@");
        System.out.println(redisTemplateCustomize);
    }

}
