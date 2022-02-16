package com.bitwait.bitrade.service;

import com.bitwait.bitrade.pagination.Criteria;
import com.bitwait.bitrade.pagination.Restrictions;
import com.bitwait.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.MiningOrderDetailDao;
import com.bitwait.bitrade.entity.MiningOrderDetail;
import com.querydsl.core.types.Predicate;
@Service
public class MiningOrderDetailService extends BaseService {
	@Autowired
	private MiningOrderDetailDao miningOrderDetailDao;
	
	public MiningOrderDetail findOne(Long id) {
		return miningOrderDetailDao.findOne(id);
	}
	
    public MiningOrderDetail save(MiningOrderDetail miningOrderDetail) {
        return miningOrderDetailDao.save(miningOrderDetail);
    }

    public MiningOrderDetail saveAndFlush(MiningOrderDetail miningOrderDetail) {
        return miningOrderDetailDao.saveAndFlush(miningOrderDetail);
    }
    
    public Page<MiningOrderDetail> findAll(Predicate predicate, Pageable pageable){
    	return miningOrderDetailDao.findAll(predicate, pageable);
    }
    
    public Page<MiningOrderDetail> findAllByMemberId(Long memberId, int pageNo, int pageSize) {
    	Sort orders = Criteria.sortStatic("createTime.desc");
        //分页参数
        PageRequest pageRequest = new PageRequest(pageNo - 1, pageSize, orders);
        //查询条件
        Criteria<MiningOrderDetail> specification = new Criteria<MiningOrderDetail>();
        specification.add(Restrictions.eq("memberId", memberId, false));
        
        return miningOrderDetailDao.findAll(specification, pageRequest);
    }
    
    public Page<MiningOrderDetail> findAllByMiningOrderId(Long miningOrderId, int pageNo, int pageSize) {
    	Sort orders = Criteria.sortStatic("createTime.desc");
        //分页参数
        PageRequest pageRequest = new PageRequest(pageNo - 1, pageSize, orders);
        //查询条件
        Criteria<MiningOrderDetail> specification = new Criteria<MiningOrderDetail>();
        specification.add(Restrictions.eq("miningOrderId", miningOrderId, false));
        
        return miningOrderDetailDao.findAll(specification, pageRequest);
    }
}
