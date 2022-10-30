package com.cz.huawei_demo.service;


import com.cz.huawei_demo.dao.OrderCommodityMapper;
import com.cz.huawei_demo.dao.OrderMapper;
import com.cz.huawei_demo.entity.Order;
import com.cz.huawei_demo.entity.OrderCommodity;
import com.cz.huawei_demo.until.MyUtils;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderCommodityMapper orderCommodityMapper;
    @Autowired
    MyUtils utils;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    MyUtils myUtils;


    @Transactional
    public Result addOrder(Order order, OrderCommodity orderCommodity){

        //设置订单生成时间
        String formatTime = utils.getFormatTime();
        order.setOrderTime(formatTime);

        //设置订单是否待收货，付款之后才会待收货。
        order.setDsh(!order.isDfk());

        //向订单表中添加当前订单信息，并将生成的主键id返回给传递进来的order中的id
        int orderResult = orderMapper.addOrder(order);

        //如果未付款就将使用向jedis中添加数据并设置有效时间
        if (order.isDfk()){
            //字符串拼接
            String key = "ORDER:" + order.getOrderId();
            String value = order.getOrderId().toString();
            try {
                redisTemplate.opsForValue().set(key, value, 20, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(201,"redis连接失败",null);
            }
        }

        //将order生成的主键id赋值给orderCommodity表中的参数orderCommodity中的belongOrderId
        orderCommodity.setBelongOrderId(order.getOrderId());
        int i = orderCommodityMapper.addOrderCommodity(orderCommodity);

        //获取当前订单中关联商品的颜色配置（字符串）
        String s = myUtils.HandleString(orderCommodity.getCommodityOptions());

        //数据库操作将查询出来的对应颜色图片地址赋值非订单关联商品
        int i1 = orderCommodityMapper.setLogoImg(orderCommodity.getCommodityId().toString(), s,
                orderCommodity.getOrderCommodityId().toString());

        //return
        if(i != 0 && orderResult != 0){
            return new Result(200,"请求成功",null);
        }else {
            return new Result(200,"请求失败",null);
        }

    }

//    @Transactional
//    public Result addOrder(Order order){
//        //这里的order里面的List<commodity>中预期接受到的是List<OrderCommodity>
//
//        //设置订单生成时间
//        String formatTime = utils.getFormatTime();
//        order.setOrderTime(formatTime);
//
//        //设置订单是否待收货，付款之后才会待收货。
//        order.setDsh(!order.isDfk());
//
//        //向订单表中添加当前订单信息，并将生成的主键id返回给传递进来的order中的id
//        int orderResult = orderMapper.addOrder(order);
//
//        //如果未付款就将使用向jedis中添加数据并设置有效时间
//        if (order.isDfk()){
//            //字符串拼接
//            String key = "ORDER:" + order.getOrderId();
//            String value = order.getOrderId().toString();
//            redisTemplate.opsForValue().set(key, value, 30, TimeUnit.SECONDS);
//        }
//
//
//        //依次将购物车中的商品添加到订单关联商品表中
//
//        for (int i = 0; i < order.getCommodityList().size(); i++) {
//
//        }
//
//
//        return new Result(200,"待完成","待完成");
//    }

    public Result getOrderByUserId(String userId){
        List<Order> orders = orderMapper.getOrderByUserId(userId);
        if (orders.size() != 0){
            return new Result(200,"获取到"+orders.size()+"条数据",orders);
        }
        return new Result(201,"请求失败",null);
    }
}
