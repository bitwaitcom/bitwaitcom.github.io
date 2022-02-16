package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.Activity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDao extends BaseDao<Activity> {
	
    List<Activity> findAllByStep(int step);

    List<Activity> findAllByTypeAndStep(int type, int step);
}
