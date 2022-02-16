/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: LoginUserDao.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年10月26日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年10月26日, Create
 */
package com.bitwait.aqmd.service;


import com.bitwait.aqmd.core.entity.CustomerMsg;

/**
 * <p>Title: LoginUserDao</p>
 * <p>Description: </p>
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年10月26日
 */
@SuppressWarnings("rawtypes")
public interface LoginUserService {
	/**
	 * 
	 * <p>Title: findUserByLoginNo</p>
	 * <p>Description: </p>
	 * 根据用户名查询用户信息
	 * @param loginNo
	 * @return
	 */
	public CustomerMsg findUserByLoginNo(String loginNo);

	public Integer updPassword(String accountNo, String password);
}
