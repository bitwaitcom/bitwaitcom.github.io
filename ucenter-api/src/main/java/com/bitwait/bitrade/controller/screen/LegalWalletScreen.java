package com.bitwait.bitrade.controller.screen;

import com.bitwait.bitrade.constant.LegalWalletState;

import lombok.Data;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Title: ${file_name}
 * @Description:
 * @date 2019/4/217:44
 */
@Data
public class LegalWalletScreen {
    private LegalWalletState state;
    private String coinName;
}
