package com.bitwait.bitrade.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年01月26日
 */
@Builder
@Data
public class ScanMemberAddress {
    private long id;
    private String unit;
    private String remark;
    private String address;

    public static ScanMemberAddress toScanMemberAddress(MemberAddress memberAddress) {
        return ScanMemberAddress.builder().id(memberAddress.getId())
                .address(memberAddress.getAddress())
                .remark(memberAddress.getRemark())
                .unit(memberAddress.getCoin().getUnit())
                .build();
    }
}
