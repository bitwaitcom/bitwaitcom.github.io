package com.bitwait.bitrade.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description 会员等级实体
 * @date 2019/12/26 17:12
 */
@Data
@Entity
@Table(name = "member_level")
public class MemberLevel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @NotBlank(message = "会员等级名称不得为空")
    private String name;
    @NotNull(message = "默认不得为null")
    private Boolean isDefault;
    private String remark;

}
