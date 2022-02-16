package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description
 * @date 2019/1/8 14:51
 */
@AllArgsConstructor
@Getter
public enum AdvertiseStatus implements BaseEnum {

    /**
     * 已挂单
     */
    HANG("已挂单"),
    /**
     * 待付款
     */
    PAYMENT("待付款"),
    /**
     * 已关闭
     */
    TURNOFF("已关闭");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
