package com.bitwait.bitrade.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 国家
 *
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年02月10日
 */
@Data
@Entity
public class Country {
    /**
     * 中文名称
     */
    @Id
    private String zhName;

    /**
     * 英文名称
     */
    private String enName;

    /**
     * 区号
     */
    private String areaCode;
    /**
     * 语言
     */
    private String language;

    /**
     * 当地货币缩写
     */
    private String localCurrency;

    private int sort;

}
