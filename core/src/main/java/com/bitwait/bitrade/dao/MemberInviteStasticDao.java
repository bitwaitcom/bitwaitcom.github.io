package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.MemberInviteStastic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInviteStasticDao extends BaseDao<MemberInviteStastic> {

	MemberInviteStastic findByMemberId(Long memberId);
	
	MemberInviteStastic findById(Long id);
	
	@Query(value = "select * from member_invite_stastic order by estimated_reward desc limit :count", nativeQuery = true)
	List<MemberInviteStastic> getTopTotalAmount(@Param("count") int count);

	@Query(value = "select * from member_invite_stastic order by level_one desc limit :count", nativeQuery = true)
	List<MemberInviteStastic> getTopInviteCount(@Param("count") int count);
}
