package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.MemberLevel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description 会员等级Dao
 * @date 2019/12/26 17:24
 */
public interface MemberLevelDao extends BaseDao<MemberLevel> {

    MemberLevel findOneByIsDefault(Boolean isDefault);

    @Query("update MemberLevel set isDefault = false  where isDefault = true ")
    @Modifying
    int updateDefault();
}
