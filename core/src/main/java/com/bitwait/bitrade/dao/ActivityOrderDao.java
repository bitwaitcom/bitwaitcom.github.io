package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.ActivityOrder;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityOrderDao extends BaseDao<ActivityOrder> {
	
	List<ActivityOrder> getAllByActivityIdEquals(Long activityId);
	List<ActivityOrder> getAllByMemberIdAndActivityIdEquals(Long memberId, Long activityId);
	
}
