/**
 * Copyright (c) 2016-2017  All Rights Reserved.
 * 
 * <p>FileName: HawkFilterValue.java</p>
 * 
 * Description: 
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月18日
 * @version 1.0
 * History:
 * v1.0.0, , 2020年7月18日, Create
 */
package com.bitwait.aqmd.core.annotation;


import com.bitwait.aqmd.core.filter.HFilter;

/**
 * <p>Title: HawkFilterValue</p>
 * <p>Description: </p>
 * @author ragan QQ:2098401701 E-mail:bitwait@qq.com
 * @date 2020年7月18日
 */
public class HawkFilterValue implements Comparable<HawkFilterValue>{
	// 顺序
    private int order;
    private int [] cmds;
    private int [] ignoreCmds;
    private HFilter hfilter;

    public HawkFilterValue(int order, int[] cmds, int[] ignoreCmds, HFilter hfilter) {
        this.order = order;
        this.cmds = cmds;
        this.ignoreCmds = ignoreCmds;
        this.hfilter = hfilter;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

   
    public int[] getCmds() {
        return cmds;
    }

    public void setCmds(int[] cmds) {
        this.cmds = cmds;
    }

    public int[] getIgnoreCmds() {
        return ignoreCmds;
    }

    public void setIgnoreCmds(int[] ignoreCmds) {
        this.ignoreCmds = ignoreCmds;
    }

    public HFilter getHfilter() {
		return hfilter;
	}

	public void setHfilter(HFilter hfilter) {
		this.hfilter = hfilter;
	}

	@Override
    public int compareTo(HawkFilterValue another) {
        return Integer.compare(this.order, another.order);
    }
}
