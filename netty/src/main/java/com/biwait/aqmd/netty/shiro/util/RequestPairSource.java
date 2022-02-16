/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: RequestPairSource.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年7月25日, Create
 */
package com.bitwait.aqmd.netty.shiro.util;


import com.bitwait.aqmd.core.entity.RequestPacket;
import com.bitwait.aqmd.core.entity.ResponsePacket;

/**
 * <p>Title: RequestPairSource</p>
 * <p>Description: </p>
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月25日
 */
public interface RequestPairSource {

	RequestPacket getHawkRequest();

	ResponsePacket getHawkResponse();
}
