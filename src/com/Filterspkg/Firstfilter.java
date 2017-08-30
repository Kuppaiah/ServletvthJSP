package com.Filterspkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.pojo.UserDetailsPojo;

public class Firstfilter implements Filter {

private static Map<String, List<String>> accesrules=new HashMap<>();
	

	static{
		List<String> adminPages=new ArrayList<String>();
		adminPages.add("/ServletvthJSP/saveservlet");
		adminPages.add("/ServletvthJSP/getservlet");
		adminPages.add("/ServletvthJSP/updateservlet");
		adminPages.add("/ServletvthJSP/getallservlet");
		adminPages.add("/ServletvthJSP/deleteservlet");
		adminPages.add("/ServletvthJSP/data");
		adminPages.add("/ServletvthJSP/logout");
		accesrules.put("ADMIN",adminPages);
		
		ArrayList<String> user=new ArrayList<>();
		user.add("/ServletvthJSP/saveservlet");
		user.add("/ServletvthJSP/updateservlet");
		user.add("/ServletvthJSP/deleteservlet");
		user.add("/ServletvthJSP/getservlet");
		user.add("/ServletvthJSP/logout");
		
		accesrules.put("USER", user);
		
		
	}
	
	private static Set<String> preLoginpages=new HashSet<String>();
	static{
		preLoginpages.add("/ServletvthJSP/logindisplayservlet");
		preLoginpages.add("/ServletvthJSP/testpgservlet");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter::destroy");
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter::doFilter::start");
		//arg2.doFilter(arg0, arg1);
	    HttpServletRequest req= (HttpServletRequest) arg0;
	    String uri=req.getRequestURI();
	  /*for knowing URI and URl for pre-login pages and post-login pages but we nee URI based on that 
	    we can perform security...
	    StringBuffer url=req.getRequestURL();
	    System.out.println("uri::"+uri);
	    System.out.println("url::"+url);
	    O/P::
	    FirstFilter::doFilter::start
        SecondFilter::doFilter::start
        SecondFilter::doFilter::end
        uri::/ServletwithJsp/displayservlet
         url::http://localhost:8080/ServletwithJsp/displayservlet*/ 
	    
	    if(preLoginpages.contains(uri)){
	    	arg2.doFilter(arg0, arg1);
	    	System.out.println("preloginpages checking block");
	    }
	    else{
	    	String user1=(String)req.getSession().getAttribute("userName");
	    	UserDetailsPojo userdetails=(UserDetailsPojo)req.getSession().getAttribute("userdetails");
			req.setAttribute("UserRoles", userdetails);
	    	if(userdetails!=null){
	    		System.out.println("userroleChecking block");
	    		String role=userdetails.getRole();
				 List<String> page= accesrules.get(role); 
				 System.out.println("::"+role);
				 if(!page.contains(uri)){
					 System.out.println(page);
			    		arg0.setAttribute("errormessage", "You are Not allowed");
			    		 arg0.getRequestDispatcher("WEB-INF/data.jsp").forward(arg0, arg1);
			    		return;
			    	}
				 else{
	    		arg2.doFilter(arg0, arg1);
	    	}
	    	}
	    	else{
	    		arg0.getRequestDispatcher("WEB-INF/login.jsp").forward(arg0, arg1);
	    	}
	    }
	    StringBuffer url=req.getRequestURL();
	    System.out.println("FirstFilter::doFilter::end");
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter::init");
		
	}
	
}
