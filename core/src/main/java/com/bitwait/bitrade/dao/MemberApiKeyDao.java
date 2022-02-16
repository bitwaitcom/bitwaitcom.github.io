package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.MemberApiKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: MemberApiKeyDao
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @create: 2019/05/07 10:41
 */
@Repository
public interface MemberApiKeyDao extends BaseDao<MemberApiKey> {

    MemberApiKey findMemberApiKeyByApiKey(String apiKey);


    @Query("select new com.bitwait.bitrade.entity.MemberApiKey(a.memberId,a.apiKey,a.bindIp,a.apiName,a.remark,a" +
            ".expireTime,a.id,a.createTime) from MemberApiKey a where a.memberId=:memberId")
    List<MemberApiKey> findAllByMemberId(@Param("memberId") Long memberId);

    MemberApiKey findMemberApiKeyByMemberIdAndId(@Param("memberId") Long memberId, @Param("id") Long id);

    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query("delete from MemberApiKey where id=:id")
    Integer del(@Param("id") Long id);
}
