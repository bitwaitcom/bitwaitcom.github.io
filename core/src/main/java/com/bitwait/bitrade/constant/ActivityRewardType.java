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
public enum ActivityRewardType implements BaseEnum {
    /**
     * 注册奖励
     */
    REGISTER("注册奖励"),
    /**
     * 交易奖励
     */
    TRANSACTION("交易奖励"),
    /**
    /**
     * 充值奖励
     */
    RECHARGE("充值奖励");
    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal() {
        return ordinal();
    }
}
