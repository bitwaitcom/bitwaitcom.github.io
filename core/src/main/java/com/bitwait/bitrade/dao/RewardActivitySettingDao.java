package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.constant.ActivityRewardType;
import com.bitwait.bitrade.constant.BooleanEnum;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.RewardActivitySetting;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年03月08日
 */
public interface RewardActivitySettingDao extends BaseDao<RewardActivitySetting> {
    RewardActivitySetting findByStatusAndType(BooleanEnum booleanEnum, ActivityRewardType type);
}
