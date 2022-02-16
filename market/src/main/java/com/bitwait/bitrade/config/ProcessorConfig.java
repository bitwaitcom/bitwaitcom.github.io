package com.bitwait.bitrade.config;

import com.bitwait.bitrade.component.CoinExchangeRate;
import com.bitwait.bitrade.entity.ExchangeCoin;
import com.bitwait.bitrade.handler.MongoMarketHandler;
import com.bitwait.bitrade.handler.NettyHandler;
import com.bitwait.bitrade.handler.WebsocketMarketHandler;
import com.bitwait.bitrade.processor.CoinProcessor;
import com.bitwait.bitrade.processor.CoinProcessorFactory;
import com.bitwait.bitrade.processor.DefaultCoinProcessor;
import com.bitwait.bitrade.service.ExchangeCoinService;
import com.bitwait.bitrade.service.MarketService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@Slf4j
public class ProcessorConfig {

    @Bean
    public CoinProcessorFactory processorFactory(MongoMarketHandler mongoMarketHandler,
                                                 WebsocketMarketHandler wsHandler,
                                                 NettyHandler nettyHandler,
                                                 MarketService marketService,
                                                 CoinExchangeRate exchangeRate,
                                                 ExchangeCoinService coinService,
                                                 RestTemplate restTemplate) {

        log.info("====initialized CoinProcessorFactory start==================================");

        CoinProcessorFactory factory = new CoinProcessorFactory();
        List<ExchangeCoin> coins = coinService.findAllEnabled();
        log.info("exchange-coin result:{}",coins);
        
        for (ExchangeCoin coin : coins) {
            CoinProcessor processor = new DefaultCoinProcessor(coin.getSymbol(), coin.getBaseSymbol());
            processor.addHandler(mongoMarketHandler);
            processor.addHandler(wsHandler);
            processor.addHandler(nettyHandler);
            processor.setMarketService(marketService);
            processor.setExchangeRate(exchangeRate);
            processor.setIsStopKLine(true);
            
            factory.addProcessor(coin.getSymbol(), processor);
            log.info("new processor = ", processor);
        }

        log.info("====initialized CoinProcessorFactory completed====");
        log.info("CoinProcessorFactory = ", factory);
        exchangeRate.setCoinProcessorFactory(factory);
        return factory;
    }
}
