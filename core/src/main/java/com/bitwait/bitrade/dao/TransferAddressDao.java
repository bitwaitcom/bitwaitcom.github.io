package com.bitwait.bitrade.dao;

import java.util.List;

import com.bitwait.bitrade.constant.CommonStatus;
import com.bitwait.bitrade.dao.base.BaseDao;
import com.bitwait.bitrade.entity.Coin;
import com.bitwait.bitrade.entity.TransferAddress;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年02月27日
 */
public interface TransferAddressDao extends BaseDao<TransferAddress> {
    List<TransferAddress> findAllByStatusAndCoin(CommonStatus status, Coin coin);

    TransferAddress findByAddressAndCoin(String address, Coin coin);
}
