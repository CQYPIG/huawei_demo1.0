package com.cz.huawei_demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CateGory {
    private Integer categoryId;
    private String categoryName;
    private String imgUrl;
}
