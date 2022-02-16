package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.DataDictionary;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/4/1214:15
 */
public interface DataDictionaryDao extends BaseDao<DataDictionary> {
    DataDictionary findByBond(String bond);
}
