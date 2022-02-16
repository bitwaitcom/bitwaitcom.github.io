package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.MiningOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface MiningOrderDao extends BaseDao<MiningOrder> {

	List<MiningOrder> findAllByMemberId(Long memberId);
	
	List<MiningOrder> findAllByMemberIdAndActivityId(Long memberId, Long activityId);
	
	List<MiningOrder> findAllByActivityId(Long activityId);
	
	List<MiningOrder> findAllByMiningStatus(int miningStatus);
}
