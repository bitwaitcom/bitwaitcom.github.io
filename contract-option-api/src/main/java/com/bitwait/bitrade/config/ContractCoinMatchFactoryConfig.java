package com.bitwait.bitrade.config;

import com.bitwait.bitrade.engine.ContractOptionCoinMatchFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ContractCoinMatchFactoryConfig {
    @Bean
    public ContractOptionCoinMatchFactory getContractCoinMatchFactory() {

        ContractOptionCoinMatchFactory factory = new ContractOptionCoinMatchFactory();
        return factory;

    }
}
