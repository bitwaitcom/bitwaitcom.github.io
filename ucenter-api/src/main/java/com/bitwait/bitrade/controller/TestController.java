package com.bitwait.bitrade.controller;

import com.bitwait.bitrade.dto.SmsDTO;
import com.bitwait.bitrade.service.MemberWalletService;
import com.bitwait.bitrade.service.SmsService;
import com.bitwait.bitrade.util.MessageResult;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description:
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date: create in 10:47 2019/6/28
 * @Modified:
 */
@RestController
@RequestMapping("/smstest")
@ToString
public class TestController extends BaseController{
    
    @Autowired
    private SmsService smsService;
    
    @Autowired
    private MemberWalletService memberWalletService;
    @RequestMapping(value = "sms",method = RequestMethod.GET)
    public MessageResult testSms(){
        SmsDTO smsDTO = smsService.getByStatus();
        System.out.println(smsDTO);
        System.out.println(success("succss",smsDTO));
        
        return success(smsDTO);
    }

    @RequestMapping(value = "drop",method = RequestMethod.GET)
    public MessageResult testDrop(){

        int drop = memberWalletService.dropWeekTable(1);
        System.out.println(drop+"..................");
//        int create = memberWalletService.createWeekTable(1);
//        System.out.println(create+"............");
        
        return null;
    }

}
