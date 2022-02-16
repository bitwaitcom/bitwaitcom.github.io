package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.constant.LegalWalletState;

import lombok.Data;

@Data
public class LegalWalletRechargeScreen {
    LegalWalletState status;
    String username;
    String coinName;

}
