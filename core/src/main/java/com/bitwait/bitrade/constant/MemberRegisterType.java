package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description 用户来源枚举
 * @date 2019/12/26 10:18
 */
@AllArgsConstructor
@Getter
public enum MemberRegisterType implements BaseEnum {
    BACKSTAGE("后台"),
    AUTONOMOUSLY("自主"),
    AUTONOMOUSLY_RECOMMEND("自主(推荐)");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
