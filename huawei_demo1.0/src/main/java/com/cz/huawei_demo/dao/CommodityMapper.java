package com.cz.huawei_demo.dao;


import com.cz.huawei_demo.entity.Commodity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
//@CacheNamespace
public interface CommodityMapper{
    //根据id从数据库中查询商品信息  -->  对options字段的封装放到service中执行
    Commodity getCommodityById(@Param("id")String id);

//    @Select("select * from commodity where is_seckill = true limit 3")
    List<Commodity> getSeckillCommodity();
}
