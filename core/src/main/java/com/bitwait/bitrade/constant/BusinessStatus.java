package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description 交易状态
 * @date 2019/1/8 15:04
 */
@AllArgsConstructor
@Getter
public enum BusinessStatus implements BaseEnum {

    ZERO("为成交"),
    /**
     * 部分成交
     */
    PORTION("部分成交"),
    /**
     * 全部成交
     */
    ALL("全部成交");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
