package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.constant.AdvertiseControlStatus;
import com.bitwait.bitrade.constant.AdvertiseType;

import lombok.Data;

@Data
public class AdvertiseScreen extends AccountScreen{

    AdvertiseType advertiseType;

    String payModel ;

    /**
     * 广告状态 (012  上架/下架/关闭)
     */
    AdvertiseControlStatus status ;

}
