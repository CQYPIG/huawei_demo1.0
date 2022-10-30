package com.cz.huawei_demo.controller;


import com.cz.huawei_demo.service.CommDetailImgService;
import com.cz.huawei_demo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommDetailImagesController {
    @Autowired
    CommDetailImgService commDetailImgService;


    @GetMapping("/getImages/{commodityId}")
    public Result getImages(@PathVariable("commodityId")String commodityId){
        return commDetailImgService.getImgByCommId(commodityId);
    }

    /*用户选择不同颜色展示的图片*/
    @GetMapping("/getColorOptionImg/{commodityId}/{color}")
    public Result getColorOptionImg(@PathVariable("commodityId") String commodityId,
                                    @PathVariable("color") String color){
        return commDetailImgService.getImages(commodityId,color);
    }

}
