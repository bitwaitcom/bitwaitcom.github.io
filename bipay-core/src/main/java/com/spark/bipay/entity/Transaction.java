package com.spark.bipay.entity;

import lombok.Data;

@Data
public class Transaction {
    private String txid;
    private String tradeId;
    private String mchid;
    private int coinType;
    private String tradeAddress;
    private String tradeAmount;
    private String fee;
    private int tradeType;
    private int tradeStatus;
    private Long createTime;
    private Long updateTime;
    private String callUrl;
    private String memo;
}
