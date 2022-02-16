package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年12月23日
 */
@AllArgsConstructor
@Getter
public enum PriceType implements BaseEnum {
    /**
     * 固定的
     */
    REGULAR("固定的"),
    /**
     * 变化的
     */
    MUTATIVE("变化的");
    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }
}
