package com.bitwait.bitrade.entity.transform;

import lombok.Data;

import java.util.List;

/**
 *
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年01月15日
 */
@Data
public class SpecialPage<E> {

    private List<E> context;
    private int currentPage;
    private int totalPage;
    private int pageNumber;
    private int totalElement;
}
