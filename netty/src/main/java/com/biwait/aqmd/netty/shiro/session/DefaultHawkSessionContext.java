/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: DefaultHawkSessionContext.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年7月25日, Create
 */
package com.bitwait.aqmd.netty.shiro.session;

import com.bitwait.aqmd.core.entity.RequestPacket;
import com.bitwait.aqmd.core.entity.ResponsePacket;
import com.bitwait.aqmd.netty.shiro.mgt.HawkSessionContext;
import org.apache.shiro.session.mgt.DefaultSessionContext;

import java.util.Map;

/**
 * <p>Title: DefaultHawkSessionContext</p>
 * <p>Description: </p>
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 */
public class DefaultHawkSessionContext extends DefaultSessionContext implements HawkSessionContext {

    private static final long serialVersionUID = -3974604687792523072L;

    private static final String HAWK_REQUEST = DefaultHawkSessionContext.class.getName() + ".HAWK_REQUEST";
    private static final String HAWK_RESPONSE = DefaultHawkSessionContext.class.getName() + ".HAWK_RESPONSE";

    public DefaultHawkSessionContext() {
        super();
    }

    public DefaultHawkSessionContext(Map<String, Object> map) {
        super(map);
    }
    @Override
    public void setHawkRequest(RequestPacket request) {
        if (request != null) {
            put(HAWK_REQUEST, request);
        }
    }
    @Override
    public RequestPacket getHawkRequest() {
        return getTypedValue(HAWK_REQUEST, RequestPacket.class);
    }
    @Override
    public void setHawkResponse(ResponsePacket response) {
        if (response != null) {
            put(HAWK_RESPONSE, response);
        }
    }
    @Override
    public ResponsePacket getHawkResponse() {
        return getTypedValue(HAWK_RESPONSE, ResponsePacket.class);
    }
}
