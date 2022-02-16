package com.bitwait.bitrade.vendor.provider.support;

import com.bitwait.bitrade.util.HttpSend;
import com.bitwait.bitrade.util.MessageResult;
import com.bitwait.bitrade.vendor.provider.SMSProvider;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @Date: 2021/12/12/12:19
 * @Description:
 */
@Slf4j
public class BaoSMSProvider implements SMSProvider {

    private String gateway;
    private String username;
    private String password;

    public BaoSMSProvider(String gateway, String username, String password) {
        this.gateway = gateway;
        this.username = username;
        this.password = password;
    }

    private static Pattern RESPONSE_PATTERN = Pattern.compile("<response><error>(-?\\d+)</error><message>(.*[\\\\u4e00-\\\\u9fa5]*)</message></response>");
    public static String getName() {
        return "Bao";
    }
    @Override
    public MessageResult sendSingleMessage(String mobile, String content) throws UnirestException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("u", username);
        params.put("p", md5(password));
        params.put("m", mobile);
        params.put("c", content);
        log.info("BaoSMSParameters====", params.toString());
        String resultXml= HttpSend.yunpianPost(gateway, params);
        log.info("result = {}", resultXml);
        return parseXml(resultXml);
    }

    @Override
    public MessageResult sendMessageByTempId(String mobile, String content, String templateId) throws Exception {
        return null;
    }

    @Override
    public MessageResult sendInternationalMessage(String mobile, String content) throws IOException, DocumentException {
        content = String.format("【bitwait】Your verification code is %s", content);
        Map<String, String> params = new HashMap<String, String>();
        params.put("u", username);
        params.put("p", md5(password));
        params.put("m", mobile);
        params.put("c", content);
        String resultXml= HttpSend.yunpianPost(gateway, params);
        log.info("result = {}", resultXml);
        return parseXml(resultXml);
    }

    /**
     * 获取验证码信息格式
     *
     * @param code
     * @return
     */
    @Override
    public String formatVerifyCode(String code) {
        return String.format("【bitwait】您的验证码为：%s，请按页面提示填写，切勿泄露于他人。", code);
    }

    @Override
    public MessageResult sendVerifyMessage(String mobile, String verifyCode) throws Exception {
        String content = formatVerifyCode(verifyCode);
        return sendSingleMessage(mobile, content);
    }

    private MessageResult parseXml(String xml) {
        JSONObject myJsonObject = JSONObject.fromObject(xml);
        int code = myJsonObject.getInt("code");
        MessageResult result = new MessageResult(500, "系统错误");
        if(code == 0)
        {
            result.setCode(code);
            result.setMessage(myJsonObject.getString("msg"));
        }
        return result;
    }

    @Override
    public MessageResult sendCustomMessage(String mobile, String content) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public static String md5(String plainText) {
        StringBuffer buf = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String encodeUrlString(String str, String charset) {
        String strret = null;
        if (str == null)
            return str;
        try {
            strret = java.net.URLEncoder.encode(str, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strret;
    }


}
