package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年04月24日
 */
@AllArgsConstructor
@Getter
public enum Platform implements BaseEnum {
    ANDROID("安卓"), IOS("苹果");
    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }
}
