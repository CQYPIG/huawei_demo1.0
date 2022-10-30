package com.cz.huawei_demo.service;

import com.cz.huawei_demo.dao.OrderCommodityMapper;
import com.cz.huawei_demo.dao.ShopCarMapper;
import com.cz.huawei_demo.entity.ShopCarCommodity;
import com.cz.huawei_demo.until.MyUtils;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarService {
    @Autowired
    ShopCarMapper shopCarMapper;
    @Autowired
    MyUtils myUtils;

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
        List<ShopCarCommodity> allSCCommodity = shopCarMapper.getAllSCCommodity(userId);
        return new Result(200,"请求到了" + allSCCommodity.size() + "数据",allSCCommodity);
    }

    /*用户修改商品数量持久化*/
    public Result changeCommodityNumber(String commodityNumber,String shopCarId){
        int i = shopCarMapper.changeCommodityNumber(commodityNumber, shopCarId);
        return new Result(200,i+"条数据成功修改","修改成功");
    }

    /*将经常需要改动的部分*/

    /*根据id删除指定购物车商品*/
    public Result deleteShopCar(String shopCarId){
        int i = shopCarMapper.deleteShopCar(shopCarId);
        return  new Result(200,i+"条数据被删除","删除成功");
    }
}
