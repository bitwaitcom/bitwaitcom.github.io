package com.bitwait.bitrade.service;

import com.bitwait.bitrade.constant.BooleanEnum;
import com.bitwait.bitrade.constant.PromotionRewardType;
import com.bitwait.bitrade.service.Base.TopBaseService;
import com.bitwait.bitrade.dao.RewardPromotionSettingDao;
import com.bitwait.bitrade.entity.RewardPromotionSetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年03月08日
 */
@Service
public class RewardPromotionSettingService  extends TopBaseService<RewardPromotionSetting,RewardPromotionSettingDao> {

    @Override
    @Autowired
    public void setDao(RewardPromotionSettingDao dao) {
        super.setDao(dao);
    }

    public RewardPromotionSetting findByType(PromotionRewardType type){
        return dao.findByStatusAndType(BooleanEnum.IS_TRUE, type);
    }

    @Override
    public RewardPromotionSetting save(RewardPromotionSetting setting){
        return dao.save(setting);
    }

    public void deletes(long[] ids){
        for(long id : ids){
            delete(id);
        }
    }

}
