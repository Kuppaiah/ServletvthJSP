package com.dbutil;

import java.util.LinkedList;
import java.util.List;

public class CurrentUser {

	public static List<String> currentUsers=new LinkedList<String>();
	
	public static void addUser(String user)
	{
		currentUsers.add(user);
	}
	
	public static void deleteUser(String user)
	{
		currentUsers.remove(user);
	}
	
	public static List<String> getAllCurrentUsers()
	{
		return currentUsers;
		
	}
}
