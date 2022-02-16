package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.constant.AuditStatus;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.Member;
import com.bitwait.bitrade.entity.MemberApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description
 * @date 2019/12/26 15:12
 */
public interface MemberApplicationDao extends BaseDao<MemberApplication> {
    List<MemberApplication> findMemberApplicationByMemberAndAuditStatusOrderByIdDesc(Member var1, AuditStatus var2);

    long countAllByAuditStatus(AuditStatus auditStatus);
    @Query(value = "select count(1) from member_application where  id_card = :idCard and audit_status=0",nativeQuery = true)
    int queryByIdCard(@Param("idCard") String idCard);
}
