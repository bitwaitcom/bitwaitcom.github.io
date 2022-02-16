package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.CtcAcceptor;
import com.bitwait.bitrade.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface CtcAcceptorDao  extends BaseDao<CtcAcceptor> {
	List<CtcAcceptor> findAllByStatus(int status);
	List<CtcAcceptor> findAllByMember(Member member);
}
