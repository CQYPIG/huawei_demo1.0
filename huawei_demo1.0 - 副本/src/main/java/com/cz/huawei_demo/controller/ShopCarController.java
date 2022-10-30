package com.cz.huawei_demo.controller;


import com.cz.huawei_demo.entity.OrderCommodity;
import com.cz.huawei_demo.entity.ShopCarCommodity;
import com.cz.huawei_demo.service.ShopCarService;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopCarController {

    @Autowired
    ShopCarService shopCarService;
    @PostMapping("/addShopCar")
    public Result addShopCar(ShopCarCommodity shopCarCommodity){
        return shopCarService.addShopCarCommodity(shopCarCommodity);
    }

    @GetMapping("/getAllSCCommodity/{userId}")
    public Result getAllSCCommodity(@PathVariable("userId") String userId){
        return shopCarService.getAllSCCommodity(userId);
    }

    @GetMapping("/changeCommodityNumber/{commodityNumber}/{shopCarId}")
    public Result changeCommodityNumber(@PathVariable("commodityNumber") String commodityNumber,
                                        @PathVariable("shopCarId") String shopCarId){


//        return shopCarService.changeCommodityNumber(commodityNumber,shopCarId);
        return shopCarService.changeCommodityNumber(commodityNumber,shopCarId);
    }

    @GetMapping("/deleteShopCar/{shopCarId}")
    public Result deleteShopCar(@PathVariable("shopCarId")String shopCarId){
        return shopCarService.deleteShopCar(shopCarId);
    }
}
