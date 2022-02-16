package com.bitwait.bitrade.entity;

import com.bitwait.bitrade.constant.CertifiedBusinessStatus;
import com.bitwait.bitrade.constant.MemberLevelEnum;

import lombok.Data;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年02月26日
 */
@Data
public class CertifiedBusinessInfo {
    private MemberLevelEnum memberLevel;
    private CertifiedBusinessStatus certifiedBusinessStatus;
    private String email;
    /**
     * * 审核失败原因
     */
    private String detail;
    /**
     *
     * 退保原因
     */
    private String reason ;
}
