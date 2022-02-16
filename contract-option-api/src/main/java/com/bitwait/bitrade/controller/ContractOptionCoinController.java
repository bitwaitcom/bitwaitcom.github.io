package com.bitwait.bitrade.controller;

import com.bitwait.bitrade.entity.ContractOptionCoin;
import com.bitwait.bitrade.service.ContractOptionCoinService;
import com.bitwait.bitrade.service.ContractOptionOrderService;
import com.bitwait.bitrade.util.MessageResult;
import com.bitwait.bitrade.engine.ContractOptionCoinMatchFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("coin")
public class ContractOptionCoinController extends BaseController {

    @Autowired
    private ContractOptionCoinService coinService;

    @Autowired
    private ContractOptionOrderService orderService;

    @Autowired
    private ContractOptionCoinMatchFactory factory;

    // 获取基币
    @RequestMapping("base-symbol")
    public MessageResult baseSymbol() {
        List<String> baseSymbol = coinService.getBaseSymbol();
        if (baseSymbol != null && baseSymbol.size() > 0) {
            return success(baseSymbol);
        }
        return error("baseSymbol null");
    }

    // 获取所有期权合约交易对列表
    @RequestMapping("coin-list")
    public MessageResult cointList() {
        List<ContractOptionCoin> coinList = coinService.findAllEnabled();
        return success(coinList);
    }

    // 获取期权合约交易对信息
    @RequestMapping("coin-info")
    public MessageResult coinInfo(String symbol) {
        ContractOptionCoin coinInfo = coinService.findBySymbol(symbol);
        return success(coinInfo);
    }
}
