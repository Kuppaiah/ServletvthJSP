package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import com.dbutil.Dbutil;
import com.exceppkg.AppException;
import com.pojo.Studentpojo;
import com.pojo.UserDetailsPojo;

public class Daocls {
	
	private final Logger LOGGER=Logger.getLogger(this.getClass());
	
	//Just to check weather the modifications made by shylu are reflecting or not...
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs=null;
	Integer stno;
	String stname;
	String marks;
	
	/*public LoginPojo login(String username){
		 Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		   LoginPojo lg=new LoginPojo();
		  try {
			  
			con=StudentBasicDataSource.getConnection();
			 ps=con.prepareStatement("select * from login where username=?");
			 ps.setString(1, username);
			 rs=ps.executeQuery();
			 while(rs.next()){
				 String usernames=rs.getString("username");
				 String password=rs.getString("passwords");
				 String role=rs.getString("role");
				 String Language=rs.getString("Language");
				 String Country=rs.getString("country");
				 String TimeZone=rs.getString("timezone");
				lg.setUsername(usernames);
				 lg.setPasswords(password);
				 lg.setCountry(Country);
				 lg.setLanguage(Language);
				 lg.setRole(role);
				 lg.setTimezone(TimeZone);
				 
			 }
			 
		  }
		  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  finally{
				  try {
						
						ps.close();
						rs.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

			  }return lg;
	 }
	
	*/
	
	public UserDetailsPojo login(String userName){
		 Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		   UserDetailsPojo lg=new UserDetailsPojo();
		  try {
			  
			con=Dbutil.getConnection();
			 ps=con.prepareStatement("select * from userdetails where username=?");
			 ps.setString(1, userName);
			 rs=ps.executeQuery();
			 while(rs.next()){
				 String usernames=rs.getString("username");
				 String password=rs.getString("password");
				 String role=rs.getString("role");
				 String Language=rs.getString("Language");
				 String Country=rs.getString("country");
				 String TimeZone=rs.getString("timezone");
				lg.setUserName(usernames);
				 lg.setPassword(password);
				 lg.setRole(role);
				 lg.setLanguage(Language);
				 lg.setCountry(Country);
				 lg.setTimeZone(TimeZone);
			 }
			 
		  }
		  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  finally{
				  try {
						
						ps.close();
						rs.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

			  }return lg;
	 }
	public void savestudent(Studentpojo sp) {
		
		try {
			con=Dbutil.getConnection();
            ps=con.prepareStatement("insert into slokam.exam(stname,marks) values(?,?)");
			ps.setString(1, sp.getStname());
	   	    ps.setString(2, sp.getMarks());
	   	    ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
	    	  try{
	    	  ps.close();
	    	  con.close();
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  e.printStackTrace();
	    	  }
	      }
	      
	      System.out.println("success");
	}
	
public  Studentpojo getStudent(Integer stno){
		
	Studentpojo s=new Studentpojo();
		try {
			
			con=Dbutil.getConnection();
			
			ps=con.prepareStatement("select * from  exam where stno=?");
			ps.setInt(1, stno);
			rs=ps.executeQuery();

			if(rs.next()){
				stno=rs.getInt("stno");
				stname=rs.getString("stname");
				marks = rs.getString("marks");
			 
	
			
			 }
			s.setStno(stno);
			s.setStname(stname);
			s.setMarks(marks);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	   finally
	   {
		   try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	   }
		return s;
	}
	
	public List<Studentpojo> getallStudents() throws AppException{
		List<Studentpojo> stdlist=new ArrayList<Studentpojo>();
		try {
			con=Dbutil.getConnection();
			ps=con.prepareStatement("select * from exam");
			rs=ps.executeQuery();
			while(rs.next()){
				
				stno=rs.getInt("stno");
				stname=rs.getString("stname");
				marks=rs.getString("marks");
				Studentpojo student = new Studentpojo();
				student.setStno(stno);
				student.setStname(stname);
				student.setMarks(marks);
				stdlist.add(student);	
			}
			
			/*String str="[";
			while(rs.next()){
			   id=rs.getInt("id");
			   name=rs.getString("name");
			   qual=rs.getString("qual");
					str=str+"{";
					str=str+"\"id\":\""+id+"\",";
					str=str+"\"name\":\""+name+"\",";
					str=str+"\"qual\":\""+qual+"\"";
					str=str+"},";
				}
				str=str+"]";
				str=str.replace("},]", "}]");
				System.out.println(str);*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();  Throwing exception explicitly 
			LOGGER.error(e.getMessage());
			throw new AppException("Problem due to sql querry");
		}
		return stdlist;	
	}
	public void updateStudent(Studentpojo student){
	    
		try {
			con=Dbutil.getConnection();
			ps=con.prepareStatement("update exam set stname=?,marks=? where stno=?");
			ps.setString(1, student.getStname());
			ps.setString(2, student.getMarks());
			ps.setInt(3, student.getStno());
			int i=ps.executeUpdate();
		    System.out.println(i+"::records updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	public void deletestud(Studentpojo sp) {
		// TODO Auto-generated method stub
		
			try {
				con=Dbutil.getConnection();
				ps=con.prepareStatement("delete from exam where stno=?");
				ps.setInt(1,sp.getStno());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally{
		    	  try{
		    	  ps.close();
		    	  con.close();
		    	  }
		    	  catch(Exception e)
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		   
		   System.out.println("Success");
		   
	}


}
