package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年01月10日
 */
@AllArgsConstructor
@Getter
public enum BooleanEnum implements BaseEnum {
    IS_FALSE(false, "否"),
    IS_TRUE(true, "是");

    @Setter
    private boolean is;

    @Setter
    private String nameCn;

    @Override
    @JsonValue
    public int getOrdinal() {
        return this.ordinal();
    }
}
