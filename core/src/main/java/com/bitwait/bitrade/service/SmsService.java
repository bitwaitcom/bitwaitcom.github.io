package com.bitwait.bitrade.service;

import com.bitwait.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.SmsDao;
import com.bitwait.bitrade.dto.SmsDTO;

/**
 * @Description:
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date: create in 9:44 2019/6/28
 * @Modified:
 */
@Service
public class SmsService extends BaseService {
    
    @Autowired
    private SmsDao smsDao;

    /**
     * 获取有效的短信配置
     * @return
     */
    public SmsDTO getByStatus(){
        return smsDao.findBySmsStatus();
    }
    
    
}
