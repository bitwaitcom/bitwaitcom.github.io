package com.bitwait.bitrade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.bitwait.bitrade.entity.ExchangeCoin;
import com.bitwait.bitrade.processor.CoinProcessor;
import com.bitwait.bitrade.processor.CoinProcessorFactory;
import com.bitwait.bitrade.service.ExchangeCoinService;

import java.util.List;

@Component
@Slf4j
public class ApplicationEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private CoinProcessorFactory coinProcessorFactory;
    @Autowired
    ExchangeCoinService coinService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("====应用初始化完成，开启CoinProcessor====");
        List<ExchangeCoin> coins = coinService.findAllEnabled();
        coins.forEach(coin->{
            CoinProcessor processor = coinProcessorFactory.getProcessor(coin.getSymbol());
            processor.initializeThumb();
            processor.initializeUsdRate();
            processor.setIsHalt(false);
        });
    }
}
