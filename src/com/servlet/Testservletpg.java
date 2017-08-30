package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.CurrentUser;
import com.pojo.UserDetailsPojo;
import com.service.Studservice;

public class Testservletpg extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		Studservice ser=new Studservice();
		String userName=arg0.getParameter("user");
		String password=arg0.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		UserDetailsPojo log=ser.login(userName);
	    String nextPage = "WEB-INF/login.jsp";
	    
		/*if(userName.equals(password)){
			UserDetailsPojo userDetails=new UserDetailsPojo();
			userDetails.setCountry("india");
			userDetails.setLanguage("en");
			userDetails.setRole("USER");
			userDetails.setTimeZone("timeZone");
			userDetails.setUserName(userName);
			userDetails.setPassword(password);
			System.out.println(userDetails.getRole());
			System.out.println("Testing if");
			
			arg0.getSession().setAttribute("user", userName);
			CurrentUser.addUser(userName);
			Integer count=(Integer)arg0.getServletContext().getAttribute("count");
			if(count==null){
				count=1;
			}
			else{
				count++;
			}
			arg0.getServletContext().setAttribute("count", count);		
			System.out.println("Test count");
			nextPage="WEB-INF/home.jsp";
		}
		else{
			arg0.setAttribute("message", "Plz provide valid username N pwd");
		}
		PrintWriter pw=arg1.getWriter();
		RequestDispatcher rd=arg0.getRequestDispatcher(nextPage);
		rd.forward(arg0, arg1);
		pw.write("hiiiiii"+userName);
	}*/
	
	    if(userName.equals(password)){
	    	CurrentUser.addUser(userName);
			log.getUserName();
			log.getRole();
			log.getTimeZone();
			log.getCountry();
			log.getPassword();
			log.getLanguage();
			System.out.println(log.getRole());
			arg0.getSession().setAttribute("userdetails", log);
			arg0.getSession().setAttribute("userName", userName);
			nextPage="WEB-INF/home.jsp";
			}
	    else{
			
			arg0.setAttribute("message", "<h3>Enter valid authentications</h3>");
			
		
	}
	arg0.getRequestDispatcher(nextPage).forward(arg0,arg1);

	
	}
}
