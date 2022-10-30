package com.cz.huawei_demo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.cz.huawei_demo.dao.*;
import com.cz.huawei_demo.entity.*;
import com.cz.huawei_demo.redis.cache.CommodityCache;
import com.cz.huawei_demo.redis.utils.JsonUtils;
import com.cz.huawei_demo.service.ImgService;
import com.cz.huawei_demo.until.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@SpringBootTest
class ApplicationTests {

    @Autowired
    SortMapper sortMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    CommDetailImgMapper commDetailImgMapper;
    

    @Test
    void contextLoads() {
//        Commodity commodity = commodityMapper.getCommodityById("3");
//        String options = commodity.getOptions();
//        //颜色：冰霜-/imgeas/、密语-/imgeas/$套餐：单品、听书vip（季卡）、超级音乐vip（季卡）
//        String[] first = options.split("&");
//        TreeMap<String, List<String>> optionTreeMap = new TreeMap<String, List<String>>();
//        ArrayList<CommodityOption> jsonOptions = new ArrayList<>();
//        for (int i=0 ; i<first.length ; i++){
//            //处理中文字符的冒号
//            String[] second = first[i].split("：");
//            //也有可能是英文字符的，这样数据库中对冒号的中英文就不做要求
//            if (second.length == 0){
//                second = first[i].split(":");
//            }
//            /* 返回到前端的数据因该是这样的格式的 List<CommodityOption> jsonOptions;
//            *  这里就是在new这个list,例如将颜色的配置执行完毕之后将颜色这个CommodityOption放进list集合中
//            */
//            CommodityOption commodityOption = new CommodityOption();
//            /* 在颜色这个CommodityOption种存放的是多条配置 List<Option> options;
//            *  这个temp就是用来存放颜色这样的一系列配置的
//            * */
//            ArrayList<Option> temp = new ArrayList<>();
//            for (int j = 0; j < second.length; j++) {
//                if (j ==0){
//                    commodityOption.setOptionName(second[j]);
//                } else {
//                    String[] option = second[j].split("、");
//                    /*  处理每一条配置的单独信息，因为有的配置是需要加钱的，所以我自己添加了一个实体类。
//                    * */
//
//                    for(int index = 0;index < option.length;index++){
//                        String[] split = option[index].split("-");
//                        Option optionTemp = new Option();
//                        if (split.length == 1){
//                            optionTemp.setOption(split[0]);
//                            System.out.println(optionTemp);
//                        } else {
//                            optionTemp.setOption(split[0]);
//                            optionTemp.setOptionPrice(split[1]);
//                            System.out.println(optionTemp);
//                        }
//                        temp.add(optionTemp);
//                    }
//
//                    commodityOption.setOptions(temp);
//                }
//            }
//            jsonOptions.add(commodityOption);
//            System.out.println(commodityOption);
//        }
//        commodity.setJsonOptions(jsonOptions);
    }

    @Autowired
    ShopCarMapper shopCarMapper;

    @Test
    public void qqq(){
        String commodityId = "1";
        String userId = "1";


        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();

        //redis中 商品库存 键的拼接
        String commodityKey = "COMMODITY:KC" + commodityId;
        //redis中 秒杀成功用户的set集合的键
        String successUserKey = commodityId + ":SUCCESS:USER";
        //从redis中获取商品库存
        String result = jedis.get(commodityKey);
        int intResult = Integer.parseInt(result);
//        秒杀是否开始（数据库中有没有相关信息）
        if(result == null){
            System.out.println("秒杀还没开始");
            jedis.close();
            return;
        }
//        秒杀是否结束（库存是否为0）
        if(intResult == 0){
            System.out.println("秒杀已结束");
            jedis.close();
            return;
        }

//        用户是否重复秒杀-->将秒杀成功的用户的信息存放在redis中的
        if(jedis.sismember(successUserKey, userId)){
            System.out.println("您已秒杀成功");
            jedis.close();
            return;
        }


//        秒杀成功->库存-1->成功用户信息写入->订单信息持久化
        //使用redis中的watch
        jedis.watch(commodityKey);
        Transaction multi = jedis.multi();
        //成功用户信息写入
        multi.sadd(successUserKey,userId);
        //库存-1
        multi.decr(commodityKey);
        List<Object> exec = multi.exec();
        if (exec == null || exec.size() == 0){
            System.out.println("秒杀失败");
        }
        System.out.println("秒杀成功");

    }


    @Test
    public void sadfas(){
        List<Commodity> seckillCommodity = commodityMapper.getSeckillCommodity();
        System.out.println(seckillCommodity);
    }

    @Autowired
    ImgMapper imgMapper;
    @Autowired
    ImgService imgService;
    @Test
    public void sdas(){
//        Result banners = imgService.getBanners();
        List<Banner> banners = imgMapper.getBanners();
        System.out.println(banners);
        List<Banner> banners1 = imgMapper.getBanners();
        System.out.println(banners1);

        List<Banner> banners2 = imgMapper.getBanners();
        System.out.println(banners2);

    }




}
