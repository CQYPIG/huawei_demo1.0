package com.cz.huawei_demo.service;


import com.cz.huawei_demo.dao.OrderCommodityMapper;
import com.cz.huawei_demo.dao.OrderMapper;
import com.cz.huawei_demo.dao.ShopCarMapper;
import com.cz.huawei_demo.entity.Order;
import com.cz.huawei_demo.entity.OrderCommodity;
import com.cz.huawei_demo.entity.ShopCarCommodity;
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
    @Autowired
    ShopCarMapper shopCarMapper;


    @Transactional
    public Result addOrder(Order order, OrderCommodity orderCommodity){

        //设置订单生成时间
        String formatTime = utils.getFormatTime();
        order.setOrderTime(formatTime);

        //设置订单是否待收货，付款之后才会待收货。
        order.setDsh(!order.isDfk());
        order.setYx(true);

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

 /*将购物车中选中商品添加到订单中*/
    /*订单的添加和订单关联商品的添加要保证数据完整性，要么都成功，要么都失败，使用spring的事务管理*/
    @Transactional
    public Result addSCCommodityToOrder(Order order,String[] shopCarIds){
        //跟不同添加订单一样还是先生成订单的生成事件
        //设置订单生成时间
        String formatTime = utils.getFormatTime();
        order.setOrderTime(formatTime);

        //根据是否付款初始化订单状态
        order.setDsh(!order.isDfk());
        order.setYx(true);

        //添加订单  返回的订单自动生成的id再order中
        int addOrderResult = orderMapper.addOrder(order);
        //如果未付款,使用redis处理订单失效事件
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


        for (String shopCarId : shopCarIds) {
            //处理购物车中选中的多条商品
            //将购物车中的信息转存到订单关联商品表中
            int addResult = shopCarMapper.addOrderCommodityFromShopCar(order.getOrderId().toString(), shopCarId);
            //转存成功之后再购物车中删除这条商品
            int deleteResult = shopCarMapper.deleteShopCar(shopCarId);
        }

        return new Result(200,"成功添加"+shopCarIds.length+"条商品",null);

    }

    public Result getOrderByUserId(String userId){
        List<Order> orders = orderMapper.getOrderByUserId(userId);
        if (orders.size() != 0){
            return new Result(200,"获取到"+orders.size()+"条数据",orders);
        }
        return new Result(201,"请求失败",null);
    }
}
