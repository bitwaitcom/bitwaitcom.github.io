package com.spark.bipay.entity;

import com.spark.bipay.constant.CoinType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Trade {
    //交易Id
    private String txId ;
    //交易流水号
    private String tradeId ;
    //交易地址
    private String address ;
    //币种类型
    private String mainCoinType;
    //代币类型，erc20为合约地址
    private String coinType;
    //交易金额
    private BigDecimal amount ;
    //交易类型  1-充值 2-提款(转账)
    private int tradeType ;
    //交易状态 0-待审核 1-成功 2-失败,充值无审核
    private int status ;
    //旷工费
    private BigDecimal fee ;
    private int decimals;
    //提币申请单号
    private String businessId ;
    //备注
    private String memo;

    public boolean isErcToken(){
        return !this.mainCoinType.equalsIgnoreCase(this.coinType) &&
                this.mainCoinType.equalsIgnoreCase(CoinType.Ethereum.getCode());
    }

    public boolean isUsdt(){
        return this.mainCoinType.equalsIgnoreCase(CoinType.Bitcoin.getCode())
                && this.coinType.equalsIgnoreCase("31");
    }
}
