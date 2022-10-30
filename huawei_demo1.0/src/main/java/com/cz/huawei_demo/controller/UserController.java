package com.cz.huawei_demo.controller;


import com.cz.huawei_demo.entity.Order;
import com.cz.huawei_demo.entity.User;
import com.cz.huawei_demo.service.CommodityService;
import com.cz.huawei_demo.service.UserService;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CommodityService commodityService;

    @GetMapping("/user/{userName}/{password}")
    public Result login(User user){
        return userService.login(user);
    }
    @GetMapping("/pay/{commodityId}")
    public Result pay(@PathVariable("commodityId") String commodityId){
        return commodityService.getCommodity(commodityId);
    }

}
