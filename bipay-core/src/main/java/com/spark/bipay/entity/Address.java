package com.spark.bipay.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Address {
    private String address;
    private int coinType;

    public static Address parse(String json){
        return JSON.parseObject(json,Address.class);
    }
}
