package com.bitwait.bitrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.CountryDao;
import com.bitwait.bitrade.entity.Country;

import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年02月10日
 */
@Service
public class CountryService {
    @Autowired
    private CountryDao countryDao;

    public List<Country> getAllCountry(){
        return countryDao.findAllOrderBySort();
    }

    public Country findOne(String zhName){
        return countryDao.findByZhName(zhName);
    }

}
