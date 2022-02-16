package com.bitwait.bitrade.controller.system;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitwait.bitrade.annotation.AccessLog;
import com.bitwait.bitrade.constant.AdminModule;
import com.bitwait.bitrade.entity.MemberApplicationConfig;
import com.bitwait.bitrade.service.MemberApplicationConfigService;
import com.bitwait.bitrade.util.BindingResultUtil;
import com.bitwait.bitrade.util.MessageResult;

import javax.validation.Valid;

@RestController
@RequestMapping("/system/member-application-config")
public class MemberApplicationConfigController {

    @Autowired
    private MemberApplicationConfigService memberApplicationConfigService ;

    @RequiresPermissions("system:member-application-config:merge")
    @PostMapping("merge")
    @AccessLog(module = AdminModule.SYSTEM, operation = "实名认证配置修改")
    public MessageResult merge(@Valid MemberApplicationConfig memberApplicationConfig, BindingResult bindingResult){
        MessageResult result = BindingResultUtil.validate(bindingResult);
        if(result!=null) {
            return result ;
        }
        memberApplicationConfigService.save(memberApplicationConfig);
        return MessageResult.getSuccessInstance("保存成功",memberApplicationConfig);
    }

    @RequiresPermissions("system:member-application-config:detail")
    @PostMapping("detail")
    @AccessLog(module = AdminModule.SYSTEM, operation = "实名认证配置详情")
    public MessageResult query(){
        return MessageResult.getSuccessInstance("获取成功",memberApplicationConfigService.get());
    }
}
