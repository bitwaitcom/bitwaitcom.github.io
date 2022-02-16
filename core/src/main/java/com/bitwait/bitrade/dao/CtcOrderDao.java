package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.Coin;
import com.bitwait.bitrade.entity.CtcOrder;
import com.bitwait.bitrade.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface CtcOrderDao  extends BaseDao<CtcOrder> {
	Coin findByUnit(String unit);
	
	List<CtcOrder> findAllByMember(Member member);
    
    List<CtcOrder> findAllByAcceptor(Member acceptor);
    
    List<CtcOrder> findAllByStatus(int status);
    
    List<CtcOrder> findAllByMemberAndStatus(Member member, int status);
    
    List<CtcOrder> findAllByAcceptorAndStatus(Member acceptor, int status);

	List<CtcOrder> findAllByIdAndMember(Long id, Member member);
}
