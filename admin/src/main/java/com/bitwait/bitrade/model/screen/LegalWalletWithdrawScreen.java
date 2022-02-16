package com.bitwait.bitrade.model.screen;

import com.bitwait.bitrade.constant.WithdrawStatus;

import lombok.Data;

@Data
public class LegalWalletWithdrawScreen {
    WithdrawStatus status;
    String username;
    String coinName;

}
