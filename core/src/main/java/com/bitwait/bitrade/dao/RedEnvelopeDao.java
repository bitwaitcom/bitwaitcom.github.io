package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.RedEnvelope;

public interface RedEnvelopeDao extends BaseDao<RedEnvelope> {
	
	RedEnvelope findByEnvelopeNo(String envelopeNo);
	
	List<RedEnvelope> findAllByMemberId(Long memberId);
	
	List<RedEnvelope> findAllByState(int state);
}
