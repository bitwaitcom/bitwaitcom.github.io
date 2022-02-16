/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: DefaultHawkSecurityManager.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年7月25日, Create
 */
package com.bitwait.aqmd.netty.shiro.mgt;

import com.bitwait.aqmd.core.entity.RequestPacket;
import com.bitwait.aqmd.core.entity.ResponsePacket;
import com.bitwait.aqmd.netty.shiro.session.DefaultHawkSessionContext;
import com.bitwait.aqmd.netty.shiro.subject.DefaultHawkSubjectContext;
import com.bitwait.aqmd.netty.shiro.subject.HawkSubjectContext;
import com.bitwait.aqmd.netty.shiro.util.HawkUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.SubjectContext;

import java.io.Serializable;

/**
 * <p>Title: DefaultHawkSecurityManager</p>
 * <p>Description: </p>
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 */
public class DefaultHawkSecurityManager  extends DefaultSecurityManager implements SecurityManager{

	@Override
    protected SubjectContext copy(SubjectContext subjectContext) {
        if (subjectContext instanceof HawkSubjectContext) {
            return new DefaultHawkSubjectContext((HawkSubjectContext) subjectContext);
        }
        return super.copy(subjectContext);
    }
	@Override
    protected SessionContext createSessionContext(SubjectContext subjectContext) {
        SessionContext sessionContext = super.createSessionContext(subjectContext);
        if (subjectContext instanceof HawkSubjectContext) {
            HawkSubjectContext wsc = (HawkSubjectContext) subjectContext;
            RequestPacket request = wsc.resolveHawkRequest();
            ResponsePacket response = wsc.resolveHawkResponse();
            DefaultHawkSessionContext webSessionContext = new DefaultHawkSessionContext(sessionContext);
            if (request != null) {
                webSessionContext.setHawkRequest(request);
            }
            if (response != null) {
                webSessionContext.setHawkResponse(response);
            }

            sessionContext = webSessionContext;
        }
        return sessionContext;
    }
	@Override
    protected SessionKey getSessionKey(SubjectContext context) {
        Serializable sessionId = context.getSessionId();
        RequestPacket request = HawkUtils.getRequest(context);
        ResponsePacket response = HawkUtils.getResponse(context);
        return new HawkSessionKey(sessionId, request, response);

    }

}
