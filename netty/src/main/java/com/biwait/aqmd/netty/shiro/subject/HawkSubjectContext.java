/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: HawkSubjectContext.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年7月25日, Create
 */
package com.bitwait.aqmd.netty.shiro.subject;

import com.bitwait.aqmd.core.entity.RequestPacket;
import com.bitwait.aqmd.core.entity.ResponsePacket;
import com.bitwait.aqmd.netty.shiro.util.RequestPairSource;
import org.apache.shiro.subject.SubjectContext;

/**
 * <p>Title: HawkSubjectContext</p>
 * <p>Description: </p>
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 */
public interface HawkSubjectContext extends SubjectContext,RequestPairSource {

	 RequestPacket getHawkRequest();

	 void setHawkRequest(RequestPacket request);

	 RequestPacket resolveHawkRequest();

	 ResponsePacket getHawkResponse();

	 void setHawkResponse(ResponsePacket response);

	 ResponsePacket resolveHawkResponse();
}
