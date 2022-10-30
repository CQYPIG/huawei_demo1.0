package com.cz.huawei_demo.dao;


import com.cz.huawei_demo.entity.OrderCommodity;
import com.cz.huawei_demo.entity.ShopCarCommodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopCarMapper {

    //添加购物车
    @Insert("insert into shop_car value (null,#{userId},#{scCommodityId},#{scCommodityPrice},#{scCommodityNumber},#{scCommodityOptions},#{scCommodityImg})")
    int addShopCar(ShopCarCommodity shopCarCommodity);



    /*根据用户id查询用户的所有商品*/
    List<ShopCarCommodity> getAllSCCommodity(@Param("userId")String UserId);

    /*根据商品id获取logo图*/
    @Select("select commodity_color_img.url  from commodity_color_img where commodity_id = #{commodityId} and color = #{color} and logo = 'isLogo'")
    String getColorUrl(@Param("commodityId")String commodityId,@Param("color")String color);

    /*用户修改商品数量*/
    /*修改商品数量的时候会伴随着商品价格的变化*/
    @Update("update shop_car set sc_commodity_number = #{commodityNumber} where shop_car_id = #{shopCarId}")
    int changeCommodityNumber(@Param("commodityNumber")String commodityNumber,@Param("shopCarId")String shopCarId);

    /*根据购物车商品id查询价格*/
    @Select("select sc_commodity_price from shop_car where shop_car_id = #{shopCarId}")
    int getPriceByShopCarId(@Param("shopCarId")String shopCarId);

    /*根据id删除指定商品*/
    @Delete("delete from shop_car where shop_car_id = #{shopCarId}")
    int deleteShopCar(@Param("shopCarId")String shopCarId);

    /*购物车商品提交时  将购物车商品信息转存到订单关联商品中*/
    int addOrderCommodityFromShopCar(@Param("orderId")String orderId,@Param("shopCarId")String shopCarId);
}
