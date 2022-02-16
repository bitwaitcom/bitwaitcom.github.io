package com.bitwait.bitrade.controller;

import com.bitwait.bitrade.constant.SysConstant;
import com.bitwait.bitrade.entity.FavorSymbol;
import com.bitwait.bitrade.entity.transform.AuthMember;
import com.bitwait.bitrade.service.FavorSymbolService;
import com.bitwait.bitrade.service.LocaleMessageSourceService;
import com.bitwait.bitrade.util.MessageResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/favor")
public class FavorController {
    @Autowired
    private FavorSymbolService favorSymbolService;

    @Autowired
    private LocaleMessageSourceService msService;

    /**
     * 添加自选
     *
     * @param member
     * @param symbol
     * @return
     */
    @RequestMapping("add")
    public MessageResult addFavor(@SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember member, String symbol) {
        if (StringUtils.isEmpty(symbol)) {
            return MessageResult.error(500, msService.getMessage("SYMBOL_CANNOT_BE_EMPTY"));
        }
        FavorSymbol favorSymbol = favorSymbolService.findByMemberIdAndSymbol(member.getId(), symbol);
        if (favorSymbol != null) {
            return MessageResult.error(500, msService.getMessage("SYMBOL_ALREADY_FAVORED"));
        }
        FavorSymbol favor = favorSymbolService.add(member.getId(), symbol);
        if (favor != null) {
            return MessageResult.success(msService.getMessage("EXAPI_SUCCESS"));
        }
        return MessageResult.error(msService.getMessage("EXAPI_ERROR"));
    }

    /**
     * 查询当前用户自选
     *
     * @param member
     * @return 404
     */
    @RequestMapping("find")
    public List<FavorSymbol> findFavor(@SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember member) {
        return favorSymbolService.findByMemberId(member.getId());
    }

   @GetMapping("test")
    public String test() {
        return "exchange-api模块测试";

    }


    /**
     * 删除自选
     *
     * @param member
     * @param symbol
     * @return
     */
    @RequestMapping("delete")
    public MessageResult deleteFavor(@SessionAttribute(SysConstant.SESSION_MEMBER) AuthMember member, String symbol) {
        if (StringUtils.isEmpty(symbol)) {
            return MessageResult.error(msService.getMessage("SYMBOL_CANNOT_BE_EMPTY"));
        }
        FavorSymbol favorSymbol = favorSymbolService.findByMemberIdAndSymbol(member.getId(), symbol);
        if (favorSymbol == null) {
            return MessageResult.error(msService.getMessage("FAVOR_NOT_EXISTS"));
        }
        favorSymbolService.delete(member.getId(), symbol);
        return MessageResult.success(msService.getMessage("EXAPI_SUCCESS"));
    }
}
