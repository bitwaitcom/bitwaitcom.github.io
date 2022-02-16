package com.bitwait.bitrade.handler;

import com.bitwait.bitrade.entity.CoinThumb;
import com.bitwait.bitrade.entity.KLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoMarketHandler implements MarketHandler {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void handleTrade(String symbol, CoinThumb thumb) {

    }

    @Override
    public void handleKLine(String symbol, KLine kLine) {
        // mongoTemplate.insert(kLine,"contract_kline_"+symbol+"_"+kLine.getPeriod());
    }
}
