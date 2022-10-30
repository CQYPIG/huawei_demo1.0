package com.cz.huawei_demo.service;

import com.cz.huawei_demo.dao.OrderCommodityMapper;
import com.cz.huawei_demo.dao.OrderMapper;
import com.cz.huawei_demo.dao.ShopCarMapper;
import com.cz.huawei_demo.entity.Order;
import com.cz.huawei_demo.entity.ShopCarCommodity;
import com.cz.huawei_demo.redis.cache.CommodityCache;
import com.cz.huawei_demo.until.MyUtils;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ShopCarService {
    @Autowired
    ShopCarMapper shopCarMapper;
    @Autowired
    MyUtils myUtils;
    @Autowired
    CommodityCache commodityCache;
    @Autowired
    MyUtils utils;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    OrderMapper orderMapper;

    public Result addShopCarCommodity(ShopCarCommodity shopCarCommodity){
        //设置对应商品的图片
        String s = myUtils.HandleString(shopCarCommodity.getScCommodityOptions());
        String colorUrl = shopCarMapper.getColorUrl(shopCarCommodity.getScCommodityId().toString(), s);
        System.out.println("获取到的图片路径" + colorUrl);
        shopCarCommodity.setScCommodityImg(colorUrl);
        int i = shopCarMapper.addShopCar(shopCarCommodity);
        if (i != 0){
            return new Result(200,"添加成功",null);
        }
        return new Result(201,"添加失败",null);
    }

    /*根据用户id查询所有购物车商品*/
    public Result getAllSCCommodity(String userId){
//        if (commodityCache.have(userId)){
//            System.out.println("这次查询走的缓存");
//            long start = System.currentTimeMillis();
//            List<ShopCarCommodity> commodityList = commodityCache.getCommodityList(Integer.parseInt(userId));
//            System.out.println("取出数据花了："+ (System.currentTimeMillis()-start));
//            return new Result(200,"请求到"+commodityList.size()+"条数据",commodityList);
//        }
        List<ShopCarCommodity> allSCCommodity = shopCarMapper.getAllSCCommodity(userId);
        //第一次出所有的数据的时候就将商品数量存入redis
        //后面修改的时候直接从redis中修改，当用户那里页面关闭的时候将redis中的数据持久化到mysql
//        for (ShopCarCommodity shopCarCommodity : allSCCommodity) {
//            commodityCache.setCommodityNumber(shopCarCommodity.getShopCarId(), shopCarCommodity.getScCommodityNumber());
//        }
        //第一次查询的时候将数据添加到缓存中
//        commodityCache.setCommodityList(Integer.parseInt(userId),allSCCommodity);
        return new Result(200,"请求到了" + allSCCommodity.size() + "数据",allSCCommodity);
    }

//    /*用户修改商品数量持久化*/
//    public Result changeCommodityNumber(String commodityNumber,String shopCarId){
//        int i = shopCarMapper.changeCommodityNumber(commodityNumber, shopCarId);
//        return new Result(200,i+"条数据成功修改","修改成功");
//    }

    /*将经常需要改动的部分 也就是修改的数量放进redis中*/
    public Result changeCommodityNumberOfRedis(String commodityNumber,String shopCarId,String userId){
        List<ShopCarCommodity> SCCommodityList = commodityCache.getCommodityList(Integer.parseInt(userId));
        for (int i = 0; i < SCCommodityList.size(); i++) {
            ShopCarCommodity shopCarCommodity = SCCommodityList.get(i);
            if (shopCarCommodity.getShopCarId() == Integer.parseInt(shopCarId)){
                //在redis中修改数据
                System.out.println("在redis中修改数据");
                shopCarCommodity.setScCommodityNumber(Integer.parseInt(commodityNumber));
            }
        }
        //将修改后的数据在redis中更新
        commodityCache.setCommodityList(Integer.parseInt(userId),SCCommodityList);
        return new Result(200,"成功修改",SCCommodityList);
    }

    /*根据id删除指定购物车商品*/
    public Result deleteShopCar(String shopCarId,String userId){
        int i = shopCarMapper.deleteShopCar(shopCarId);
        List<ShopCarCommodity> allSCCommodity = shopCarMapper.getAllSCCommodity(userId);
        return  new Result(200,i+"条数据被删除",allSCCommodity);
    }

    public Result changeCommodityNumber(String commodityNumber,String shopCarId,String userId){
        int priceByShopCarId = shopCarMapper.getPriceByShopCarId(shopCarId);
        int i = shopCarMapper.changeCommodityNumber(commodityNumber, shopCarId);
        List<ShopCarCommodity> allSCCommodity = shopCarMapper.getAllSCCommodity(userId);
        return new Result(200,i+"条数据被更新",allSCCommodity);
    }


}
