package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Studentpojo;
import com.service.Studservice;

public class Deleteservlet extends HttpServlet{

	/*@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		
		//String stname=arg0.getParameter("stname");
		//String marks=arg0.getParameter("marks");
		String stno=arg0.getParameter("stno");
		Integer stno1=Integer.parseInt(stno);
		
	    Studentpojo sp=new Studentpojo();
	
		//sp.setStname(stname);
		//sp.setMarks(marks);
		//sp.setStno(stno1);
	
		Studservice studser=new Studservice();
	    studser.deletestud(stno1);
	    arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
	}*/

	    
		@Override
	    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			String stname=req.getParameter("stname");
			String marks=req.getParameter("marks");
			String stno=req.getParameter("stno");
			Integer stno1=Integer.parseInt("stno");
			
			Studentpojo sp=new Studentpojo();
			
			sp.setStname(stname);
			sp.setMarks(marks);
			sp.setStno(stno1);
			Studservice studser=new Studservice();
			studser.deletestud(sp);
		    req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);

	    }


}
