package com.bitwait.bitrade.service;

import com.bitwait.bitrade.constant.SignStatus;
import com.bitwait.bitrade.service.Base.TopBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwait.bitrade.dao.SignDao;
import com.bitwait.bitrade.entity.Sign;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Description:
 * @date 2019/5/311:11
 */
@Service
public class SignService extends TopBaseService<Sign, SignDao> {


    @Override
    @Autowired
    public void setDao(SignDao dao) {
        super.setDao(dao);
    }

    public Sign fetchUnderway() {
        return dao.findByStatus(SignStatus.UNDERWAY);
    }

    /**
     * 提前关闭
     *
     * @param sign 提前关闭
     */
    public void earlyClosing(Sign sign) {
        sign.setStatus(SignStatus.FINISH);
        dao.save(sign);
    }

}
