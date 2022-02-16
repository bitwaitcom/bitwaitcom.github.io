package com.bitwait.bitrade.service;

import com.bitwait.bitrade.service.Base.BaseService;
import com.bitwait.bitrade.engine.ContractOptionCoinMatchFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService  extends BaseService {

    @Autowired
    private ContractOptionCoinMatchFactory contractOptionCoinMatchFactory; // 合约引擎工厂

    @Autowired
    private ContractOptionCoinService contractOptionCoinService; // 合约币种交易对服务

    @Autowired
    private ContractOptionOrderService contractOptionOrderService; // 合约持仓订单服务

}
