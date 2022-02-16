package com.bitwait.bitrade.service;

import java.util.List;

import com.bitwait.bitrade.pagination.Criteria;
import com.bitwait.bitrade.pagination.Restrictions;
import com.bitwait.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.RedEnvelopeDao;
import com.bitwait.bitrade.dao.RedEnvelopeDetailDao;
import com.bitwait.bitrade.entity.RedEnvelope;
import com.querydsl.core.types.Predicate;

@Service
public class RedEnvelopeService extends BaseService {
	
	@Autowired
	private RedEnvelopeDao redEnvelopeDao;
	
	@Autowired
	private RedEnvelopeDetailDao redEnvelopeDetailDao;
	
	public RedEnvelope findByEnvelopeNo(String envelopeNo) {
		return redEnvelopeDao.findByEnvelopeNo(envelopeNo);
	}

	public List<RedEnvelope> findAllByMemberId(Long memberId){
		return redEnvelopeDao.findAllByMemberId(memberId);
	}
	public List<RedEnvelope> findAllByState(int state){
		return redEnvelopeDao.findAllByState(state);
	}
	public RedEnvelope findOne(Long id) {
		return redEnvelopeDao.findOne(id);
	}
	
    public RedEnvelope save(RedEnvelope envelope) {
        return redEnvelopeDao.save(envelope);
    }

    public RedEnvelope saveAndFlush(RedEnvelope envelope) {
        return redEnvelopeDao.saveAndFlush(envelope);
    }
    
    public RedEnvelope findById(Long id) {
        return redEnvelopeDao.findOne(id);
    }
    
    public Page<RedEnvelope> findAll(Predicate predicate, Pageable pageable){
    	return redEnvelopeDao.findAll(predicate, pageable);
    }
    
    public Page<RedEnvelope> findByMember(Long memberId, int pageNo, int pageSize){
        Sort orders = Criteria.sortStatic("createTime.desc");
        //分页参数
        PageRequest pageRequest = new PageRequest(pageNo, pageSize, orders);
        //查询条件
        Criteria<RedEnvelope> specification = new Criteria<RedEnvelope>();
        specification.add(Restrictions.eq("memberId", memberId, false));
        return redEnvelopeDao.findAll(specification, pageRequest);
    }
}
