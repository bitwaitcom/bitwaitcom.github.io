package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.PromotionCard;

public interface PromotionCardDao extends BaseDao<PromotionCard> {
	
	PromotionCard findByCardNo(String cardNo);
	
	List<PromotionCard> findAllByMemberId(Long memberId);

	List<PromotionCard> findAllByMemberIdAndIsFree(long memberId, int isFree);
}
