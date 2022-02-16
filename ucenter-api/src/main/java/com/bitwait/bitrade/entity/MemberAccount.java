package com.bitwait.bitrade.entity;

import com.bitwait.bitrade.constant.BooleanEnum;

import lombok.Builder;
import lombok.Data;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年01月16日
 */
@Builder
@Data
public class MemberAccount {
    private String realName;
    private BooleanEnum bankVerified;
    private BooleanEnum aliVerified;
    private BooleanEnum wechatVerified;
    private BankInfo bankInfo;
    private Alipay alipay;
    private WechatPay wechatPay;
}
