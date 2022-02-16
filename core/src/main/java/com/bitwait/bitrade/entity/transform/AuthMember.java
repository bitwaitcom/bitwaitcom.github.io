package com.bitwait.bitrade.entity.transform;

import com.bitwait.bitrade.constant.CommonStatus;
import com.bitwait.bitrade.constant.MemberLevelEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

import com.bitwait.bitrade.entity.Location;
import com.bitwait.bitrade.entity.Member;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年01月11日
 */
@Builder
@Data
public class AuthMember implements Serializable {
    private static final long serialVersionUID = -4199550203850153635L;
    private long id;
    private String name;
    private String realName;
    private Location location;
    private String mobilePhone;
    private String email;
    private MemberLevelEnum memberLevel;
    private CommonStatus status;

    /**
     * 如需添加信息在{@link #toAuthMember(Member)}方法中添加
     *
     * @param member
     * @return
     */
    public static AuthMember toAuthMember(Member member) {
        return AuthMember.builder()
                .id(member.getId())
                .name(member.getUsername())
                .realName(member.getRealName())
                .location(member.getLocation())
                .mobilePhone(member.getMobilePhone())
                .email(member.getEmail())
                .memberLevel(member.getMemberLevel())
                .status(member.getStatus())
                .build();
    }

}
