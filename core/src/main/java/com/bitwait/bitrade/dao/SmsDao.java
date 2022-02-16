package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.dto.SmsDTO;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description:
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date: create in 9:47 2019/6/28
 * @Modified:
 */
public interface SmsDao extends BaseDao<SmsDTO> {
    
    @Query(value = "select * from tb_sms where sms_status = '0' ",nativeQuery = true)
    SmsDTO findBySmsStatus();
}
