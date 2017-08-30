package com.pojo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sortingpkg.StudentCompByMarks;
import com.sortingpkg.StudentCompByName;
import com.sortingpkg.StudentCompByStno;

public class StudentCompUtil{
	
	public static void sort(List<Studentpojo> list,String param){
		Collections.sort(list,getComprator(param));
	}
	
	public static Comparator<Studentpojo> getComprator(String param){
		
		Comparator<Studentpojo> c=null;
		if(param==null) param="stno";
		switch(param){
		
		case "stno":c=new StudentCompByStno();
		            break;
		case "stname":c=new StudentCompByName();
                    break;
		case "marks":c=new StudentCompByMarks();
                    break;
		}
		return c;
		
	}
}
