package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 广告类型
 *
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年12月07日
 */
@AllArgsConstructor
@Getter
public enum AdvertiseType implements BaseEnum {

    /**
     * 购买
     */
    BUY("购买"),

    /**
     * 出售
     */
    SELL("出售");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }

}
