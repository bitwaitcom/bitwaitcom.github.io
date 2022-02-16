package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.entity.ExchangeTrade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TradeRepository extends MongoRepository<ExchangeTrade,Long>{
}
