package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.QuickExchange;

import java.util.List;

public interface QuickExchangeDao extends BaseDao<QuickExchange> {
    List<QuickExchange> findAllByMemberId(Long memberId);
}
