package com.bitwait.bitrade.service;

import com.bitwait.bitrade.pagination.Criteria;
import com.bitwait.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwait.bitrade.dao.InitPlateDao;
import com.bitwait.bitrade.entity.InitPlate;

@Service
public class InitPlateService extends BaseService {

    @Autowired
    private InitPlateDao initPlateDao ;
    public InitPlate findInitPlateBySymbol(String symbol) {
        return initPlateDao.findInitPlateBySymbol(symbol);
    }

    public InitPlate save(InitPlate initPlate){
        return initPlateDao.save(initPlate);
    }

    public InitPlate saveAndFlush(InitPlate initPlate) {
       return initPlateDao.saveAndFlush(initPlate);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(long id){
        initPlateDao.delete(id);
    }

    public Page<InitPlate> findAllByPage(Criteria<InitPlate> specification, PageRequest pageRequest) {
        return initPlateDao.findAll(specification,pageRequest);
    }
    public InitPlate findByInitPlateId(long id){
        return initPlateDao.findOne(id);
    }
}
