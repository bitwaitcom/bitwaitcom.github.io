package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.constant.SignStatus;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.Sign;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Description:
 * @date 2019/5/311:10
 */
public interface SignDao extends BaseDao<Sign> {
    Sign findByStatus(SignStatus status);
}
