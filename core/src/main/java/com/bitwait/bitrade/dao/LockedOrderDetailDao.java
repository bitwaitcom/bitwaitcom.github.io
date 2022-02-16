package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.LockedOrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockedOrderDetailDao extends BaseDao<LockedOrderDetail> {
    List<LockedOrderDetail> findAllByMemberId(Long memberId);
}
