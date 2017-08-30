package com.servlet;

	import java.io.IOException;

	import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Studentpojo;
import com.service.Studservice;


	public class Getservlet extends HttpServlet{
		
		@Override
		public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String user1=(String)req.getSession().getAttribute("user");
			if(user1!=null){
			String stno=req.getParameter("stno");
			Studservice service=new Studservice();
			Studentpojo student=new Studentpojo();
			Studentpojo std =service.getStudent(Integer.parseInt(stno));
			req.setAttribute("student", std);
			req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);
			}
			
		}

	}

