package com.cz.huawei_demo.dao;


import com.cz.huawei_demo.entity.ShopCarCommodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopCarMapper {

    //添加购物车
    @Insert("insert into shop_car value (null,#{userId},#{scCommodityId},#{scCommodityPrice},#{scCommodityNumber},#{scCommodityOptions},#{scCommodityImg})")
    int addShopCar(ShopCarCommodity shopCarCommodity);


    //给购物车里的商品添加对应图片
//    int setImg(@Param("commodityId")String commodityId,@Param("color")String color);

    /*根据用户id获取自己的购物车商品*/
//    @Select("select * from shop_car where user_id = #{userId}")
    List<ShopCarCommodity> getAllSCCommodity(@Param("userId")String UserId);

    /*根据商品id获取logo图*/
    @Select("select commodity_color_img.url  from commodity_color_img where commodity_id = #{commodityId} and color = #{color} and logo = 'isLogo'")
    String getColorUrl(@Param("commodityId")String commodityId,@Param("color")String color);

    /*用户修改商品数量*/

    @Update("update shop_car set sc_commodity_number = #{commodityNumber} where shop_car_id = #{shopCarId}")
    int changeCommodityNumber(@Param("commodityNumber")String commodityNumber,@Param("shopCarId")String shopCarId);

    /*根据id删除指定商品*/
    @Delete("delete from shop_car where shop_car_id = #{shopCarId}")
    int deleteShopCar(@Param("shopCarId")String shopCarId);

}
