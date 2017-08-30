package com.servletnjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dataservlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		PrintWriter pw=arg1.getWriter();
		RequestDispatcher rd=arg0.getRequestDispatcher("WEB-INF/data.jsp");
		rd.forward(arg0, arg1);
	}
}
