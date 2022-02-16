package com.spark.bipay.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Slf4j
public class HttpUtil {

    public static Map<String ,String> wrapperParams(String key,String body) throws Exception {
        String timestamp = System.currentTimeMillis()+"" ;
        String nonce = String.valueOf(getNonceString(8));
        String sign = SignUtil.sign(key,timestamp,nonce,body);
        Map<String ,String> map = new HashMap<>();
        map.put("body",body);
        map.put("sign",sign);
        map.put("timestamp",timestamp);
        map.put("nonce",nonce);
        return map;
    }

    public static String getNonceString(int len){
        String seed = "1234567890";
        StringBuffer tmp = new StringBuffer();
        for (int i = 0; i < len; i++) {
            tmp.append(seed.charAt(getRandomNumber(0,9)));
        }
        return tmp.toString();
    }

    public static int getRandomNumber(int from, int to) {
        float a = from + (to - from) * (new Random().nextFloat());
        int b = (int) a;
        return ((a - b) > 0.5 ? 1 : 0) + b;
    }

    public static boolean checkSign(String key , String timestamp,String nonce,String body,String sign) throws Exception {
        String checkSign = SignUtil.sign(key,timestamp,nonce,body);
        return checkSign.equals(sign);
    }
}
