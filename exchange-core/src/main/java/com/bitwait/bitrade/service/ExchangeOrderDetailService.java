package com.bitwait.bitrade.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.ExchangeOrderDetailRepository;
import com.bitwait.bitrade.dao.ExchangeOrderRepository;
import com.bitwait.bitrade.dao.OrderDetailAggregationRepository;
import com.bitwait.bitrade.entity.ExchangeOrderDetail;

import java.util.List;

@Slf4j
@Service
public class ExchangeOrderDetailService {
    @Autowired
    private ExchangeOrderDetailRepository orderDetailRepository;

    @Autowired
    private ExchangeOrderRepository exchangeOrderRepository ;

    @Autowired
    private MemberService memberService ;

    @Autowired
    private OrderDetailAggregationRepository orderDetailAggregationRepository;


    /**
     * 查询某订单的成交详情
     * @param orderId
     * @return
     */
    public List<ExchangeOrderDetail> findAllByOrderId(String orderId){
        return orderDetailRepository.findAllByOrderId(orderId);
    }

    public ExchangeOrderDetail save(ExchangeOrderDetail detail){
       return orderDetailRepository.save(detail);
    }
}
