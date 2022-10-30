package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.redis.config.MyBatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
//@CacheNamespace(implementation = MyBatisRedisCache.class)
public interface UserMapper {
    User getUser(@Param("id")String id);
}
