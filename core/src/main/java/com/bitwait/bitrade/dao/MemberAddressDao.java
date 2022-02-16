package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.constant.CommonStatus;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.MemberAddress;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年01月26日
 */
public interface MemberAddressDao extends BaseDao<MemberAddress> {
    @Modifying
    @Query("update MemberAddress a set a.deleteTime=:date,a.status=1 where a.status=0 and a.id=:id and a.memberId=:memberId")
    int deleteMemberAddress(@Param("date") Date date, @Param("id") long id, @Param("memberId") long memberId);

    List<MemberAddress> findAllByMemberIdAndAddressAndStatus(Long memberId, String address, CommonStatus status);

}
