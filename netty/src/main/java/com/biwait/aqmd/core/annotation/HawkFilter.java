/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: HawkFilter.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月18日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年7月18日, Create
 */
package com.bitwait.aqmd.core.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <p>Title: HawkFilter</p>
 * <p>Description: </p>
 * 过滤器注解
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月18日
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface  HawkFilter {
	/**
     * 顺序。值越小越先执行before方法，越晚执行after方法
     * @return
     */
    int order() default 0;

    /**
     * 拦截指令列表
     * @return
     */
    int [] cmds() default {};

    /**
     * 忽略拦截指令列表
     * @return
     */
    int [] ignoreCmds() default {};

}
