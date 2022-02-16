package com.bitwait.bitrade.service;

import com.bitwait.bitrade.service.Base.TopBaseService;
import com.bitwait.bitrade.dao.DividendStartRecordDao;
import com.bitwait.bitrade.entity.DividendStartRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年03月22日
 */
@Service
public class DividendStartRecordService extends TopBaseService<DividendStartRecord, DividendStartRecordDao> {

    @Override
    @Autowired
    public void setDao(DividendStartRecordDao dao) {
        super.setDao(dao);
    }

    public List<DividendStartRecord> matchRecord(long start, long end, String unit) {
        return dao.findAllByTimeAndUnit(start, end, unit);
    }

    @Override
    public DividendStartRecord save(DividendStartRecord dividendStartRecord) {
        return dao.save(dividendStartRecord);
    }


}
