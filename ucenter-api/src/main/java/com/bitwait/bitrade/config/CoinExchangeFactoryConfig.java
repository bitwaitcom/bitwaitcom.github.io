package com.bitwait.bitrade.config;

import com.bitwait.bitrade.system.CoinExchangeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bitwait.bitrade.entity.Coin;
import com.bitwait.bitrade.service.CoinService;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class CoinExchangeFactoryConfig {
    @Autowired
    private CoinService coinService;

    @Bean
    public CoinExchangeFactory createCoinExchangeFactory() {
        List<Coin> coinList = coinService.findAll();
        CoinExchangeFactory factory = new CoinExchangeFactory();
        coinList.forEach(coin ->
                factory.set(coin.getUnit(), new BigDecimal(coin.getUsdRate()), new BigDecimal(coin.getCnyRate()))
        );
        return factory;
    }
}
