package com.yc.mybatis.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

/**
 * 做filter的适配类
 * @author Administrator
 *
 */
public abstract class AbstractFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
