package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.Daocls;
import com.exceppkg.AppException;
import com.pojo.Studentpojo;
import com.pojo.UserDetailsPojo;
import com.servlet.Studservlet;

public class Studservice{

	static Daocls dao=new Daocls();
	
	/*public LoginPojo login(String username){
		return studentDao.login(username);
	   }*/
	
	public UserDetailsPojo login(String userName){
		return dao.login(userName);
		
	}
		public void savestudent(Studentpojo sp) {
			//Daocls dao=new Daocls();
			// TODO Auto-generated method stub
			dao.savestudent(sp);
		}
	
		public void deletestud(Studentpojo sp) {
			dao.deletestud(sp);
		}
		
		public void updatestud(Studentpojo sp) {
		     dao.updateStudent(sp);
		}

		public List<Studentpojo> getallStudents() throws AppException {
			// TODO Auto-generated method stub
			Daocls dao=new Daocls();
			return dao.getallStudents();
		}
		
		public Studentpojo getStudent(Integer stno){
			Daocls dao=new Daocls();
			return dao.getStudent(stno);
		}
}
