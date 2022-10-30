package com.cz.huawei_demo.service;


import com.cz.huawei_demo.dao.UserMapper;
import com.cz.huawei_demo.entity.Commodity;
import com.cz.huawei_demo.entity.User;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Result login(User user){
        User userName = userMapper.findUserName(user);
        if (userName == null){
            return new Result(201,"用户名不存在！",null);
        } else {
            User loginUser = userMapper.login(user);
            if (loginUser != null){
                loginUser.setPassword(null);
                return new Result(200,"登录成功",loginUser);
            }
            return new Result(202,"密码错误",null);
        }
    }

}
