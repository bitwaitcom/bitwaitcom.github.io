package com.bitwait.bitrade.controller.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwait.bitrade.constant.PageModel;
import com.bitwait.bitrade.model.RewardRecordScreen;
import com.bitwait.bitrade.service.RewardRecordService;
import com.bitwait.bitrade.util.MessageResult;

/**
 * 奖励记录
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 *
 */
@RestController
@RequestMapping("promotion/reward-record")
public class RewardRecordController {

    @Autowired
    private RewardRecordService rewardRecordService ;

    @PostMapping("page-query")
    public MessageResult page(PageModel pageModel, RewardRecordScreen screen){
        return null;
    }
}
