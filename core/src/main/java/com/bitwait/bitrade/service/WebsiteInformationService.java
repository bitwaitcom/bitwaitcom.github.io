package com.bitwait.bitrade.service;

import com.bitwait.bitrade.service.Base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwait.bitrade.dao.WebsiteInformationDao;
import com.bitwait.bitrade.entity.QWebsiteInformation;
import com.bitwait.bitrade.entity.WebsiteInformation;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @description
 * @date 2019/1/26 10:18
 */
@Service
public class WebsiteInformationService extends BaseService {
    @Autowired
    private WebsiteInformationDao websiteInformationDao;

    @Transactional(readOnly = true)
    public WebsiteInformation fetchOne() {
        QWebsiteInformation qEntity = QWebsiteInformation.websiteInformation;
        return queryFactory.selectFrom(qEntity).fetchOne();
    }

    public WebsiteInformation save(WebsiteInformation websiteInformation) {
        return websiteInformationDao.save(websiteInformation);
    }

}
