/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: FilterChain.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月28日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年7月28日, Create
 */
package com.bitwait.aqmd.core.filter;

import com.bitwait.aqmd.core.entity.RequestPacket;
import com.bitwait.aqmd.core.entity.ResponsePacket;
import io.netty.channel.ChannelHandlerContext;

/**
 * <p>Title: FilterChain</p>
 * <p>Description: </p>
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月28日
 */
public interface FilterChain {
	
	public void doFilter(RequestPacket request, ResponsePacket response, ChannelHandlerContext ctx);
}
