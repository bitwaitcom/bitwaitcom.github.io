package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.MemberWeightUpper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberWeightUpperDao extends BaseDao<MemberWeightUpper> {

    @Query(value = "select * from member_weight_upper where member_id in (:ids) order by member_id desc",nativeQuery = true)
    List<MemberWeightUpper> findAllByUpperIds(@Param("ids") List<Long> ids);
}
