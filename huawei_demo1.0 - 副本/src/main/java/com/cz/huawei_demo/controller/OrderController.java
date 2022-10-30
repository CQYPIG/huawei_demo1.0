package com.cz.huawei_demo.controller;


import com.cz.huawei_demo.dao.OrderCommodityMapper;
import com.cz.huawei_demo.dao.OrderMapper;
import com.cz.huawei_demo.entity.Order;
import com.cz.huawei_demo.entity.OrderCommodity;
import com.cz.huawei_demo.service.OrderService;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping("/order/{userId}")
    public Result getOrderByUserId(@PathVariable("userId")String userId){
        return orderService.getOrderByUserId(userId);
    }

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderCommodityMapper orderCommodityMapper;
    @PostMapping("/order")
    public Result addOrder(Order order,OrderCommodity orderCommodity){
        Result result = null;
        //订单的添加和订单关联商品的添加应该同时完成，所以使用springboot的事务处理
        try {
            //对order和orderCommodity两张表的操作都在service中
            result = orderService.addOrder(order, orderCommodity);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(201,"数据异常",null);
        }
        return result;
    }
}
