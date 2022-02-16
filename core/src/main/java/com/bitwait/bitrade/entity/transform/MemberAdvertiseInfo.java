package com.bitwait.bitrade.entity.transform;

import com.bitwait.bitrade.constant.BooleanEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年01月16日
 */
@Builder
@Data
public class MemberAdvertiseInfo {
    private List<ScanAdvertise> buy;
    private List<ScanAdvertise> sell;
    private String username;
    private String avatar;
    private BooleanEnum realVerified;
    private BooleanEnum emailVerified;
    private BooleanEnum phoneVerified;
    private int transactions;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
