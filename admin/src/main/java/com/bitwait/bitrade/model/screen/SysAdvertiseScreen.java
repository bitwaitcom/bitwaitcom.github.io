package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.constant.CommonStatus;
import com.bitwait.bitrade.constant.SysAdvertiseLocation;

import lombok.Data;

@Data
public class SysAdvertiseScreen {
    private String serialNumber;
    private SysAdvertiseLocation sysAdvertiseLocation;
    private CommonStatus status;
}
