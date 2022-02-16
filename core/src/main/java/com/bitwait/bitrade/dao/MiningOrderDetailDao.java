package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.MiningOrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface MiningOrderDetailDao  extends BaseDao<MiningOrderDetail> {
	
	List<MiningOrderDetail> findAllByMemberId(Long memberId);
	
}
