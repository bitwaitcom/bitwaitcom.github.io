package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.PromotionCardOrder;

public interface PromotionCardOrderDao extends BaseDao<PromotionCardOrder> {
	List<PromotionCardOrder> findAllByCardIdAndMemberId(Long cardId, Long memberId);
	
	List<PromotionCardOrder> findAllByCardId(Long cardId);


	List<PromotionCardOrder> findAllByMemberIdAndIsFree(long memberId, int isFree);
}
