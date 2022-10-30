package com.example.demo;

import com.example.demo.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        userMapper.getUser("1");
        userMapper.getUser("1");
        userMapper.getUser("1");
        userMapper.getUser("1");
    }

}
