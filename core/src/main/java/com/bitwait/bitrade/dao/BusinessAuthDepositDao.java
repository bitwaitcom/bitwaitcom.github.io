package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.constant.CommonStatus;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.BusinessAuthDeposit;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2019/5/5
 */
public interface BusinessAuthDepositDao extends BaseDao<BusinessAuthDeposit> {
    public List<BusinessAuthDeposit> findAllByStatus(CommonStatus status);
}
