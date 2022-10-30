package com.cz.huawei_demo.redis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class JedisConfig {
    @Bean
    public Jedis jedis(){
        Jedis jedis = new Jedis("124.222.215.244",6379);
        return jedis;
    }
}
