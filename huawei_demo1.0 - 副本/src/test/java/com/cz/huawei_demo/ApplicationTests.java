package com.cz.huawei_demo;

import com.cz.huawei_demo.dao.*;
import com.cz.huawei_demo.entity.CommodityDetailImg;
import com.cz.huawei_demo.entity.Order;
import com.cz.huawei_demo.entity.ShopCarCommodity;
import com.cz.huawei_demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

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

    @Test
    public void qqq(){
        TreeMap<String, Object> stringObjectTreeMap = new TreeMap<>();
        stringObjectTreeMap.put("qqq","qqq");
        stringObjectTreeMap.put("www","www");
        System.out.println(stringObjectTreeMap);
    }

    @Test
    public void TestCommodityMapper(){
        CommodityDetailImg images = commDetailImgMapper.getImgByCommId("3");
        System.out.println(images);

    }

    @Autowired
    OrderMapper orderMapper;
    @Test
    public void TestOrderMapper(){
//        List<Order> orders = orderMapper.getOrderByUserId("1");
//        System.out.println(orders);
        String str = "颜色:昆仑霞光,版本:512GB,套餐:官方标配,";

    }

//    @Autowired
//    Jedis jedis;
//    @Test
//    public void testJedis(){
//        System.out.println(jedis);
//        String set = jedis.set("k", "value1");
//        System.out.println(set);
//    }

    @Test
    public void testList(){
        User user1 = new User(1,"1","1");
        User user2 = new User(2,"2","2");
        User user3 = new User(3,"3","3");
        User user4 = new User(4,"4","4");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(user1);
        objects.add(user2);
        objects.add(user3);
        objects.add(user4);
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i));
        }

    }

    @Autowired
    ShopCarMapper shopCarMapper;
    @Test
    public void das(){
        List<ShopCarCommodity> allSCCommodity = shopCarMapper.getAllSCCommodity("1");
        System.out.println(allSCCommodity);
    }




}
