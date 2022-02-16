package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.constant.AdvertiseType;
import com.bitwait.bitrade.constant.BooleanEnum;
import com.bitwait.bitrade.constant.OrderStatus;
import com.bitwait.bitrade.constant.*;

import lombok.Data;

@Data
public class AppealScreen {
    private AdvertiseType advertiseType ;
    private String complainant ;//申诉者
    private String negotiant;//交易者
    private BooleanEnum success;
    private String unit ;
    private OrderStatus status ;
    private Boolean auditing = false ;
}
