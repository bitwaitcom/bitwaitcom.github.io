package com.bitwait.bitrade.controller;

import com.bitwait.bitrade.service.ExchangeCoinService;
import com.bitwait.bitrade.util.MessageResult;
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
    @RequestMapping("exchange-coin")
    public class ExchangeCoinController extends BaseController {
        @Autowired
        private ExchangeCoinService service;

        //获取基币
        @RequestMapping("base-symbol")
    public MessageResult baseSymbol() {
        List<String> baseSymbol = service.getBaseSymbol();
        if (baseSymbol != null && baseSymbol.size() > 0) {
            return success(baseSymbol);
        }
        return error("baseSymbol null");

    }

}
