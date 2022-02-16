package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有只有两种状态的都可使用,ordinal为0表示正常，启用；ordinal为1表示软删除，禁用，取消.<br>
 *
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年12月07日
 */
@AllArgsConstructor
@Getter
public enum CommonStatus implements BaseEnum {
    /**
     * 表示正常状态
     */
    NORMAL("正常"),
    /**
     * 表示非法状态
     */
    ILLEGAL("非法");

    @Setter
    private String cnName;

    @Override
    @JsonValue
    public int getOrdinal(){
        return this.ordinal();
    }
}
