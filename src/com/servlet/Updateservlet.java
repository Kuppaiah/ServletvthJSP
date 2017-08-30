package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Studentpojo;
import com.service.Studservice;

public class Updateservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		
		String stname=arg0.getParameter("stname");
		String marks=arg0.getParameter("marks");
		String stno=arg0.getParameter("stno");
		int stno1=Integer.parseInt(stno);
		Studentpojo sp=new Studentpojo();
		sp.setStname(stname);
		sp.setMarks(marks);
		sp.setStno(stno1);
		
		System.out.println("stname::"+stname+"marks::"+marks+"stno::"+stno);
		Studservice studser=new Studservice();
	    studser.updatestud(sp);
	    arg0.getRequestDispatcher("home.jsp").forward(arg0, arg1);
	   
	}
}
