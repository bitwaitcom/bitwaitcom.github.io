package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.entity.MemberLog;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MemberLogDao extends MongoRepository<MemberLog,Long> {
}
