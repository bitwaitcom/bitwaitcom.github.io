package com.spark.bipay.http.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spark.bipay.constant.API;
import com.spark.bipay.entity.Address;
import com.spark.bipay.entity.SupportCoin;
import com.spark.bipay.entity.Transaction;
import com.spark.bipay.entity.Transfer;
import com.spark.bipay.http.ResponseMessage;
import com.spark.bipay.utils.HttpUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
public class BiPayClient implements Client<String> {
    private String gateway;
    private static String CONNECTION_EXCEPTION = "connect exception";
    private static String ENCODE_TYPE = "UTF-8";
    private static String CONTENT_TYPE_VALUE = "application/json";
    private static String CONTENT_TYPE_NAME = "Content-Type";
    private int connectTimeout = 1000;
    private int requestTimeout = 1000;
    private Boolean redirectEnabled = true;

    private String merchantId;
    private String merchantKey;

    public static final CookieStore cookieStore = new BasicCookieStore();

    public RequestConfig requestConfig;

    public BiPayClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(requestTimeout)
                .setRedirectsEnabled(redirectEnabled).build();
        this.requestConfig = requestConfig;
    }

    public BiPayClient(String gateway, String merchantId, String key) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(requestTimeout)
                .setRedirectsEnabled(redirectEnabled).build();
        this.gateway = gateway;
        this.merchantId = merchantId;
        this.merchantKey = key;
        this.requestConfig = requestConfig;
    }

    public BiPayClient(String host, String merchantId, String key, RequestConfig requestConfig) {
        this.gateway = host;
        this.merchantId = merchantId;
        this.merchantKey = key;
        this.requestConfig = requestConfig;
    }

    /**
     * 创建地址
     *
     * @param mainCoinType
     * @param callbackUrl
     * @return
     * @throws Exception
     */
    public ResponseMessage<Address> createCoinAddress(String mainCoinType, String callbackUrl, String alias, String walletId) throws Exception {
        JSONArray body = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("merchantId", this.merchantId);
        item.put("coinType", mainCoinType);
        item.put("callUrl", callbackUrl);
        if (alias != null && alias != "") {
            item.put("alias", alias);
        } else
            item.put("alias", "");
        if (walletId != null && walletId != "") {
            item.put("walletId", walletId);
        } else
            item.put("walletId", "");
        body.add(item);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, body.toJSONString());
        ResponseMessage<String> response = post(API.CREATE_ADDRESS, map);
        ResponseMessage<Address> result = new ResponseMessage<>(response.getCode(), response.getMessage());
        if (result.getCode() == ResponseMessage.SUCCESS_CODE) {
            result.setData(Address.parse(response.getData()));
        }
        return result;
    }

    /**
     * 创建批量地址
     *
     * @param mainCoinType
     * @param callbackUrl
     * @param count
     * @return
     * @throws Exception
     */
    public ResponseMessage<List<Address>> createBatchCoinAddress(String mainCoinType, String callbackUrl, int count) throws Exception {
        JSONArray body = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("merchantId", this.merchantId);
        item.put("coinType", mainCoinType);
        item.put("callUrl", callbackUrl);
        item.put("count", count);
        body.add(item);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, body.toJSONString());
        ResponseMessage<String> response = post(API.CREATE_BATCH_ADDRESS, map);
        ResponseMessage<List<Address>> result = new ResponseMessage<>(response.getCode(), response.getMessage());
        if (result.getCode() == ResponseMessage.SUCCESS_CODE) {
            result.setData(JSONArray.parseArray(response.getData(), Address.class));
        }
        return result;
    }

    /**
     * 转账
     *
     * @param orderId
     * @param amount
     * @param mainCoinType
     * @param subCoinType
     * @param address
     * @param callbackUrl
     * @return
     * @throws Exception
     */
    public ResponseMessage<String> transfer(String orderId, BigDecimal amount, String mainCoinType, String subCoinType, String address, String callbackUrl, String memo) throws Exception {
        Transfer transfer = new Transfer();
        transfer.setAddress(address);
        transfer.setMainCoinType(mainCoinType);
        transfer.setCoinType(subCoinType);
        transfer.setBusinessId(orderId);
        transfer.setMerchantId(merchantId);
        transfer.setAmount(amount);
        transfer.setCallUrl(callbackUrl);
        transfer.setMemo(memo);
        JSONArray body = new JSONArray();
        body.add(transfer);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, body.toJSONString());
        ResponseMessage<String> response = post(API.WITHDRAW, map);
        return response;
    }

    /**
     * 代付
     *
     * @param orderId
     * @param amount
     * @param mainCoinType
     * @param subCoinType
     * @param address
     * @param callbackUrl
     * @return
     * @throws Exception
     */
    public ResponseMessage<String> autoTransfer(String orderId, BigDecimal amount, String mainCoinType, String subCoinType, String address, String callbackUrl, String memo) throws Exception {
        Transfer transfer = new Transfer();
        transfer.setAddress(address);
        transfer.setMainCoinType(mainCoinType);
        transfer.setCoinType(subCoinType);
        transfer.setBusinessId(orderId);
        transfer.setMerchantId(merchantId);
        transfer.setAmount(amount);
        transfer.setCallUrl(callbackUrl);
        transfer.setMemo(memo);
        JSONArray body = new JSONArray();
        body.add(transfer);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, body.toJSONString());
        ResponseMessage<String> response = post(API.AUTO_WITHDRAW, map);
        return response;
    }

    /**
     * 检查是否内部地址
     *
     * @param address
     * @return
     * @throws Exception
     */
    public boolean checkAddress(String mainCoinType, String address) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("merchantId", merchantId);
        jsonObject.put("mainCoinType", mainCoinType);
        jsonObject.put("address", address);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, "[" + jsonObject.toJSONString() + "]");
        ResponseMessage<String> response = post(API.CHECK_ADDRESS, map);
        return  response.getCode() == 200;
        //return (boolean) JSONObject.parse(response.getData());
    }

    /**
     * 获取支持的币种和对应余额
     *
     * @return
     * @throws Exception
     */
    public List<SupportCoin> getSupportCoin(Boolean showBalance) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("merchantId", merchantId);
        jsonObject.put("showBalance", showBalance);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, jsonObject.toJSONString());
        ResponseMessage<String> response = post(API.SUPPORT_COIN, map);
        List<SupportCoin> supportCoinList = JSONObject.parseArray(response.getData(), SupportCoin.class);
        return supportCoinList;
    }

    /**
     * 检查是否支持该币种
     *
     * @param coinName
     * @return
     * @throws Exception
     */
    public boolean checkSupport(Long merchantId, String coinName) throws Exception {
        boolean supported = false;
        List<SupportCoin> supportCoinList = getSupportCoin(false);
        for (SupportCoin supportCoin : supportCoinList) {
            if (supportCoin.getName().equals(coinName)) {
                supported = true;
                break;
            }
        }
        return supported;
    }

    /**
     * 是否支持代付条件
     *
     * @param amount
     * @param mainCoinType
     * @param subCoinType
     * @return
     * @throws Exception
     */
    public boolean checkProxy(BigDecimal amount, String mainCoinType, String subCoinType) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mainCoinType", mainCoinType);
        jsonObject.put("subCoinType", subCoinType);
        jsonObject.put("amount", amount);
        jsonObject.put("merchantId", merchantId);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, jsonObject.toJSONString());
        ResponseMessage<String> response = post(API.CHECK_PROXY, map);
        return (boolean) JSONObject.parse(response.getData());
    }

    /**
     * 查询交易记录
     *
     * @param mainCoinType
     * @param coinType
     * @param tradeId
     * @param tradeType
     * @param address
     * @param startTimestamp 时间戳 毫秒
     * @param endTimestamp   时间戳 毫秒
     * @return
     * @throws Exception
     */
    public List<Transaction> queryTransaction(String mainCoinType, String coinType, String tradeId,
                                              Integer tradeType, String address, String startTimestamp, String endTimestamp) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mainCoinType", mainCoinType);
        jsonObject.put("coinType", coinType);
        jsonObject.put("tradeId", tradeId);
        jsonObject.put("tradeType", tradeType);
        jsonObject.put("address", address);
        jsonObject.put("startTimestamp", startTimestamp);
        jsonObject.put("endTimestamp", endTimestamp);
        Map<String, String> map = HttpUtil.wrapperParams(this.merchantKey, jsonObject.toJSONString());
        ResponseMessage<String> response = post(API.TRANSACTION, map);
        List<Transaction> trades = JSONObject.parseArray(response.getData(), Transaction.class);
        return trades;
    }


    public ResponseMessage<String> post(String url, Map<String, String> map) {
        CloseableHttpClient httpCilent = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost httpPost = new HttpPost(gateway + url);
        httpPost.setConfig(requestConfig);
        HttpResponse httpResponse = null;
        try {
            StringEntity entity = new StringEntity(JSONObject.toJSONString(map), Charset.forName(ENCODE_TYPE));
            entity.setContentType(CONTENT_TYPE_VALUE);
            entity.setContentEncoding(ENCODE_TYPE);
            httpPost.addHeader(CONTENT_TYPE_NAME, CONTENT_TYPE_VALUE);
            httpPost.setEntity(entity);
            httpResponse = httpCilent.execute(httpPost);
            String strResult;
            ResponseMessage<String> response;
            if (httpResponse != null) {
                log.info("httpResponse:{}", httpResponse.getStatusLine().toString());
                if (httpResponse.getStatusLine().getStatusCode() == 200) {
                    strResult = EntityUtils.toString(httpResponse.getEntity());
                    log.debug("strResult:,{}", strResult);
                    JSONObject json = JSONObject.parseObject(strResult);
                    response = ResponseMessage.success(json.getInteger("code"), json.getString("message"));
                    if (json.getString("data") != null) {
                        response.setData(json.getString("data"));
                    }
                } else {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                    JSONObject json = JSONObject.parseObject(strResult);
                    response = ResponseMessage.error(json.getInteger("code"), json.getString("message"));
                }
                log.info("Response:,{}", response);
                return response;
            }
        } catch (IOException e) {
            log.error("IOException:{}", e);
        } finally {
            if (httpCilent != null) {
                try {
                    httpCilent.close();
                } catch (IOException e) {
                    log.error("http client close exception:{}", e);
                }
            }
        }
        log.error(CONNECTION_EXCEPTION);
        return ResponseMessage.error(CONNECTION_EXCEPTION);
    }


    public ResponseMessage<String> get(String url) {
        CloseableHttpClient httpCilent = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        String strResult;
        ResponseMessage<String> response;
        try {
            HttpResponse httpResponse = httpCilent.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                strResult = EntityUtils.toString(httpResponse.getEntity());// 获得返回的结果
                response = ResponseMessage.success();
                response.setData(strResult);
            } else {
                strResult = EntityUtils.toString(httpResponse.getEntity());// 获得返回的结果
                response = ResponseMessage.error(strResult);
            }
            log.info("Response:,{}", response);
            return response;
        } catch (IOException e) {
            log.error("Request exception:{}", e);
        } finally {
            if (httpCilent != null) {
                try {
                    httpCilent.close();
                } catch (IOException e) {
                    log.error("http client close exception:{}", e);
                }
            }
        }
        log.error(CONNECTION_EXCEPTION);
        return ResponseMessage.error(CONNECTION_EXCEPTION);
    }

    public static void setCookieStore(List<BasicClientCookie> cookielist) {
        for (BasicClientCookie cookie : cookielist) {
            BiPayClient.cookieStore.addCookie(cookie);
        }
    }

    public static void createCookie(List<BasicClientCookie> cookielist) {
        for (BasicClientCookie cookie : cookielist) {
            BiPayClient.cookieStore.addCookie(cookie);
        }
    }

}
