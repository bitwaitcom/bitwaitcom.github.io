package com.bitwait.bitrade.service;

import com.bitwait.bitrade.service.Base.BaseService;
import com.bitwait.bitrade.dao.QuickExchangeDao;
import com.bitwait.bitrade.entity.QuickExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuickExchangeService extends BaseService {
    @Autowired
    private QuickExchangeDao quickExchangeDao;

    public List<QuickExchange> findAllByMemberId(Long memberId) {
        return quickExchangeDao.findAllByMemberId(memberId);
    }

    public QuickExchange save(QuickExchange qe) {
        return quickExchangeDao.save(qe);
    }
}
