package com.bitwait.bitrade.controller;

import com.bitwait.bitrade.entity.ContractOption;
import com.bitwait.bitrade.entity.ContractOptionStatus;
import com.bitwait.bitrade.service.ContractOptionCoinService;
import com.bitwait.bitrade.service.ContractOptionService;
import com.bitwait.bitrade.util.MessageResult;
import com.bitwait.bitrade.engine.ContractOptionCoinMatchFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/4/1816:54
            */
@RestController
@RequestMapping("option")
public class ContractOptionController extends BaseController {

    @Autowired
    private ContractOptionCoinService coinService;

    @Autowired
    private ContractOptionService optionService;

    @Autowired
    private ContractOptionCoinMatchFactory factory;

    // 获取历史期数
    @RequestMapping("history")
    public MessageResult history(String symbol, int count) {
        Page<ContractOption> optionList = optionService.findAll(symbol, count);
        return success(optionList);
    }

    // 获取正在投注中的合约
    @RequestMapping("starting")
    public MessageResult starting(String symbol) {
        List<ContractOption> optionList = optionService.findBySymbolAndStatus(symbol, ContractOptionStatus.STARTING);
        return success(optionList);
    }

    // 获取正在开奖中的合约
    @RequestMapping("opening")
    public MessageResult opening(String symbol) {
        List<ContractOption> optionList = optionService.findBySymbolAndStatus(symbol, ContractOptionStatus.OPENING);
        return success(optionList);
    }
}
