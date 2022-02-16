package com.bitwait.bitrade.service;

import com.bitwait.bitrade.service.Base.TopBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.HotTransferRecordDao;
import com.bitwait.bitrade.entity.HotTransferRecord;

@Service
public class HotTransferRecordService extends TopBaseService<HotTransferRecord,HotTransferRecordDao> {

    @Override
    @Autowired
    public void setDao(HotTransferRecordDao dao) {
        super.setDao(dao);
    }
}
