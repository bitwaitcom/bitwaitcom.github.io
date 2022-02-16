package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 广告级别
 *
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年12月13日
 */
@AllArgsConstructor
@Getter
public enum AdvertiseLevel implements BaseEnum {

    /**
     * 普通
     */
    ORDINARY("普通"),
    /**
     * 优质
     */
    EXCELLENT("优质");


    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }
}
