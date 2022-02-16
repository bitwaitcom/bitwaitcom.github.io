package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.constant.CertifiedBusinessStatus;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.BusinessCancelApply;
import com.bitwait.bitrade.entity.Member;

/**
 * @author jiangtao
 * @date 2019/5/17
 */
public interface BusinessCancelApplyDao extends BaseDao<BusinessCancelApply> {

    List<BusinessCancelApply> findByMemberAndStatusOrderByIdDesc(Member member , CertifiedBusinessStatus status);

    List<BusinessCancelApply> findByMemberOrderByIdDesc(Member member);

    long countAllByStatus(CertifiedBusinessStatus status);
}
