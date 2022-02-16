package com.bitwait.bitrade.dao;

import com.bitwait.bitrade.constant.Platform;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.AppRevision;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/4/2416:18
 */
public interface AppRevisionDao extends BaseDao<AppRevision> {
    AppRevision findAppRevisionByPlatformOrderByIdDesc(Platform platform);
}
