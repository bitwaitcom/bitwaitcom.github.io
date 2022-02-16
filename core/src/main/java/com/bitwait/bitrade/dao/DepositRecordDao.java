package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.constant.DepositStatusEnum;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.DepositRecord;
import com.bitwait.bitrade.entity.Member;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2019/5/7
 */
public interface DepositRecordDao extends BaseDao<DepositRecord> {
    public DepositRecord findById(String id);

    public List<DepositRecord> findByMemberAndStatus(Member member, DepositStatusEnum status);
}
