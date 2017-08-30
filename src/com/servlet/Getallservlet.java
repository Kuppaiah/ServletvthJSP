package com.servlet;

	import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

	import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exceppkg.AppException;
import com.pojo.StudentCompUtil;
import com.pojo.Studentpojo;
import com.pojo.UserDetailsPojo;
import com.service.Studservice;
import com.sortingpkg.StudentCompByName;


	public class Getallservlet extends HttpServlet{
		
		@Override
		 public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			/*UserDetailsPojo userDetails=(UserDetailsPojo)req.getSession().getAttribute("UserName");
			String role=userDetails.getRole();
			if(role==null || !role.equals("ADMIN")){
				req.setAttribute("error","Not authorized to access Getall");
				req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);
				return;
			}*/
			
			List<Studentpojo> stdlist=null;
			Studservice service=new Studservice();
			try {
				stdlist=service.getallStudents();
				String sort=req.getParameter("sort");
				//Collections.sort(stdlist,StudentCompUtil.getComprator(sort));
				StudentCompUtil.sort(stdlist,sort);
				req.setAttribute("studentsList", stdlist);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				req.setAttribute("error", e.getMessage());
			}
			//sorting
			/*
			req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);
			
			Studservice stdser=new Studservice();
			List<Studentpojo> stdlist;
			try {
				stdlist = stdser.getallStudents();
				String sort=req.getParameter("sort");
				StudentCompUtil.sort(stdlist,sort);
				req.setAttribute("studentsList", stdlist);
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, res);*/
			
		
		}

	}

