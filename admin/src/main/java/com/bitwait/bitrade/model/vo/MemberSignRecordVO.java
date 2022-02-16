package com.bitwait.bitrade.model.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import com.bitwait.bitrade.entity.Member;
import com.bitwait.bitrade.entity.MemberSignRecord;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/5/714:22
 */
@Data
@Builder
public class MemberSignRecordVO {

    private Long id;

    private String username;

    private String mobilePhone;

    private String realName;

    private Long signId;

    private String coinName;

    private BigDecimal amount;

    private Date creationTime;

    public static MemberSignRecordVO getMemberSignRecordVO(MemberSignRecord x) {
        Member member = x.getMember();
        return MemberSignRecordVO.builder()
                .id(x.getId())
                .username(member.getUsername())
                .mobilePhone(member.getMobilePhone())
                .realName(member.getRealName())
                .signId(x.getSign().getId())
                .coinName(x.getCoin().getName())
                .amount(x.getAmount())
                .creationTime(x.getCreationTime())
                .build();
    }

}
