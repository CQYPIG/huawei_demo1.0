package com.cz.huawei_demo.redis.cache;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.cz.huawei_demo.entity.ShopCarCommodity;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommodityCache {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    /*初始化商品数量*/
    public void setCommodityNumber(Integer shopCarId,Integer scCommodityNumber){
        //拼接redis的key
        String cNumberKey = "COMMODITYNUMBER:"+shopCarId;
        int cNumberValue = scCommodityNumber;
        redisTemplate.opsForValue().set(cNumberKey,cNumberValue);
    }

    /*获取对应商品的id*/
    public int getCommodityNumber(Integer shopCarId){
        //拼接redis的key
        String cNumberKey = "COMMODITYNUMBER:"+shopCarId+shopCarId;
        Object result  = redisTemplate.opsForValue().get(cNumberKey);
        if (result!= null){
            return Integer.parseInt(result.toString());
        }
        return 0;
    }

    /*初始化商品数量*/
    public void setCommodityList(Integer userId, List<ShopCarCommodity> shopCarCommodityList){
        //拼接redis的key
        String cNumberKey = "COMMODITYLIST:"+userId;
        String s = JSON.toJSONString(shopCarCommodityList);
        redisTemplate.opsForValue().set(cNumberKey,s);
    }

    /*获取商品列表*/
    public List<ShopCarCommodity> getCommodityList(Integer userId){
        //拼接redis的key
        String cNumberKey = "COMMODITYLIST:"+userId;
        // 将redis中的json字符串转成对象
        long start = System.currentTimeMillis();
        JSONArray jsonArray = JSONArray.parseArray((String) redisTemplate.opsForValue().get(cNumberKey));
        System.out.println("JSONArray.parseArray:" + (System.currentTimeMillis() - start));
        long l = System.currentTimeMillis();
        List<ShopCarCommodity> shopCarCommodities = jsonArray.toJavaList(ShopCarCommodity.class);
        System.out.println("jsonArray.toJavaList:" + (System.currentTimeMillis() - l));
        return shopCarCommodities;
    }

    public boolean have(String userId){
        //拼接redis的key
        String cNumberKey = "COMMODITYLIST:"+userId;
        return redisTemplate.hasKey(cNumberKey);
    }

}
