package com.bitwait.bitrade.handler;

import com.bitwait.bitrade.entity.CoinThumb;
import com.bitwait.bitrade.entity.ExchangeTrade;
import com.bitwait.bitrade.entity.KLine;

public interface MarketHandler {

    /**
     * 存储交易信息
     * @param exchangeTrade
     */
    void handleTrade(String symbol, ExchangeTrade exchangeTrade, CoinThumb thumb);


    /**
     * 存储K线信息
     *
     * @param kLine
     */
    void handleKLine(String symbol, KLine kLine);
}
