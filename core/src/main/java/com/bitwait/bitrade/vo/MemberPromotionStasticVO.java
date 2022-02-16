package com.bitwait.bitrade.vo;

import java.util.Date;

import com.bitwait.bitrade.constant.PromotionLevel;

import lombok.Data;

@Data
public class MemberPromotionStasticVO {
    private Long id;

    //邀请者Id
    private Long inviterId;
    
    //受邀者Id
    private Long inviteesId;

    private PromotionLevel level;
    
    private Date createTime;
    
    private int count;
}
