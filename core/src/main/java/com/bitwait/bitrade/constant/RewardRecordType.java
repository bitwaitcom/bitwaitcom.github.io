package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年03月08日
 */
@AllArgsConstructor
@Getter
public enum RewardRecordType implements BaseEnum {
    /**
     * 推广
     */
    PROMOTION("推广"),
    /**
     * 活动
     */
    ACTIVITY("活动"),
    /**
     * 分红
     */
    DIVIDEND("分红");
    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }

}
