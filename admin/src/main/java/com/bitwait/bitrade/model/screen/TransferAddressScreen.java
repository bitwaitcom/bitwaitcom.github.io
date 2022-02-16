package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.constant.CommonStatus;

import lombok.Data;

@Data
public class TransferAddressScreen {
    private CommonStatus start ;
    private String address;
    private String unit;
}
