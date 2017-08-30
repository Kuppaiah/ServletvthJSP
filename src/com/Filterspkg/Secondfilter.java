package com.Filterspkg;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Secondfilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter::destroy");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
	System.out.println("SecondFilter::doFilter::start");
	 arg2.doFilter(arg0, arg1);
	System.out.println("SecondFilter::doFilter::end");
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("SecondFilter::init");
	}

}
