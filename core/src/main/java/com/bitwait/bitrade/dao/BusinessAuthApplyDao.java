package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.constant.CertifiedBusinessStatus;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.BusinessAuthApply;
import com.bitwait.bitrade.entity.Member;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2019/5/7
 */
public interface BusinessAuthApplyDao extends BaseDao<BusinessAuthApply> {

    List<BusinessAuthApply> findByMemberOrderByIdDesc(Member member);

    List<BusinessAuthApply> findByMemberAndCertifiedBusinessStatusOrderByIdDesc(Member member, CertifiedBusinessStatus certifiedBusinessStatus);

    long countAllByCertifiedBusinessStatus(CertifiedBusinessStatus status);

}
