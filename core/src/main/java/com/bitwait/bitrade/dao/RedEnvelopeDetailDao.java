package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.RedEnvelopeDetail;

public interface RedEnvelopeDetailDao  extends BaseDao<RedEnvelopeDetail> {
	
	List<RedEnvelopeDetail> findAllByEnvelopeIdAndMemberId(Long envelopeId, Long memberId);
	
	List<RedEnvelopeDetail> findAllByEnvelopeId(Long envelopeId);
}
