package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.constant.BooleanEnum;
import com.bitwait.bitrade.constant.PromotionRewardType;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.RewardPromotionSetting;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年03月08日
 */
public interface RewardPromotionSettingDao extends BaseDao<RewardPromotionSetting> {
    RewardPromotionSetting findByStatusAndType(BooleanEnum booleanEnum, PromotionRewardType type);
}
