package com.bitwait.bitrade.config;

import com.bitwait.bitrade.vendor.provider.SMSProvider;
import com.bitwait.bitrade.vendor.provider.support.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class SmsProviderConfig {

    @Value("${sms.gateway:}")
    private String gateway;
    @Value("${sms.apikey:}")
    private String apikey;
    @Value("${sms.username:}")
    private String username;
    @Value("${sms.password:}")
    private String password;
    @Value("${sms.sign:}")
    private String sign;
    @Value("${sms.internationalGateway:}")
    private String internationalGateway;
    @Value("${sms.internationalUsername:}")
    private String internationalUsername;
    @Value("${sms.internationalPassword:}")
    private String internationalPassword;
    @Value("${access.key.id:}")
    private String accessKey;
    @Value("${access.key.secret:}")
    private String accessSecret;

    //阿里云短信调用
    @Value("${aliyun.mail-sms.region}")
    private String ali_Region;
    @Value("${aliyun.mail-sms.access-key-id}")
    private String ali_accessKeyId;
    @Value("${aliyun.mail-sms.access-secret}")
    private String ali_accessSecret;
    @Value("${aliyun.mail-sms.sms-sign}")
    private String ali_smsSign;
    @Value("${aliyun.mail-sms.sms-template}")
    private String ali_smsTemplate;

    @Bean
    public SMSProvider getSMSProvider(@Value("${sms.driver:}") String driverName) {
        if (StringUtils.isEmpty(driverName)) {
            return new AliyunSMSprovider(ali_Region, ali_accessKeyId, ali_accessSecret, ali_smsSign, ali_smsTemplate);//默认阿里云
        }
        if (driverName.equalsIgnoreCase(AliyunSMSprovider.getName())) {
            return new AliyunSMSprovider(ali_Region, ali_accessKeyId, ali_accessSecret, ali_smsSign, ali_smsTemplate);//阿里云
        } else if (driverName.equalsIgnoreCase(SaiyouSMSProvider.getName())) {
            return new SaiyouSMSProvider(username, password, sign, gateway);                                          //赛邮
        }else if (driverName.equalsIgnoreCase(FeigeSMSProvider.getName())) {
            return new FeigeSMSProvider(sign,username,password);                                                      //飞鸽
        }else if (driverName.equalsIgnoreCase(DiyiSMSProvider.getName())) {
            return new DiyiSMSProvider(username, password, sign);                                                     //第一短信
        }else if (driverName.equalsIgnoreCase(BaoSMSProvider.getName())) {
                return new BaoSMSProvider(gateway, username, password);                   //短信宝
        }else if (driverName.equalsIgnoreCase(ChuangRuiSMSProvider.getName())) {
            return new ChuangRuiSMSProvider(gateway, username, password, sign,accessKey,accessSecret);                //创瑞
        } else if (driverName.equalsIgnoreCase(EmaySMSProvider.getName())) {
            return new EmaySMSProvider(gateway, username, password);                                                  //易短信
        } else if (driverName.equalsIgnoreCase(YunpianSMSProvider.getName())) {
            return new YunpianSMSProvider(gateway,apikey);                                                            //云片
        }else if (driverName.equalsIgnoreCase(HuaXinSMSProvider.getName())) {
            return new HuaXinSMSProvider(gateway, username, password,internationalGateway,internationalUsername,internationalPassword,sign);    //华信
        }  else {
            return null;
        }
    }
}
