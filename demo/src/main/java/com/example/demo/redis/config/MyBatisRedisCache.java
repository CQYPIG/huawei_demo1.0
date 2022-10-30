package com.example.demo.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;



@Slf4j
public class MyBatisRedisCache implements Cache {
    //将缓存的数据存在redis中
    //注入redisTemplate操作redis
    //使用redis去操作缓存
    @Autowired
    private RedisTemplate redisTemplate;
    private String id;

    public MyBatisRedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }



    @Override
    public String getId() {
        System.out.println("尝试在获取id");
        return null;
    }



    @Override
    public void putObject(Object key, Object value) {
        System.out.println("___________________________");
        System.out.println("尝试将缓存信息放进redis中");
        System.out.println("接收到的参数key：" + key + "value:" + value);
        System.out.println("___________________________");

    }

    @Override
    public Object getObject(Object key) {
        System.out.println("___________________________");

        System.out.println("尝试从redis中获取缓存");
        System.out.println("接受道德参数key：" + key);
        System.out.println("___________________________");

        return null;
    }

    @Override
    public Object removeObject(Object key) {
        System.out.println("删除"+ key.toString());
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        System.out.println("尝试在获取长度");
        return 0;
    }
}
