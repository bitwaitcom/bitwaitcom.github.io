package com.spark.bipay.http.client;

import com.spark.bipay.http.ResponseMessage;

import java.util.Map;

public interface Client<T> {

    ResponseMessage<T> post(String url, Map<String, String> list);

    ResponseMessage<T> get(String url);

}
