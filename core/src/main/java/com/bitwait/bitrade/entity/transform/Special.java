package com.bitwait.bitrade.entity.transform;

import lombok.Data;

import java.util.List;

/**
 *
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2019-5-14 12:30:47
 */
@Data
public class Special<E> {
    private List<E> context;
}
