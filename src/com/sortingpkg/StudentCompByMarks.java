package com.sortingpkg;

import java.util.Comparator;

import com.pojo.Studentpojo;

public class StudentCompByMarks implements Comparator<Studentpojo>{

	public int compare(Studentpojo arg0, Studentpojo arg1) {
		// TODO Auto-generated method stub
		return arg0.getMarks().compareTo(arg1.getMarks());
	}

	
	}


