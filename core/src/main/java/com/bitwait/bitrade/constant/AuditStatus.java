package com.bitwait.bitrade.constant;

import com.bitwait.bitrade.core.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description 审核信息状态
 * @date 2019/12/26 14:42
 */
@AllArgsConstructor
@Getter
public enum AuditStatus implements BaseEnum{

    AUDIT_ING("待审核"),
    AUDIT_DEFEATED("审核失败"),
    AUDIT_SUCCESS("审核成功");

    @Setter
    private String cnName;
    @Override
    @JsonValue
    public int getOrdinal() {
        return this.ordinal();
    }
}
