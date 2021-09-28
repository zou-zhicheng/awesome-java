package com.atguigu.java8;

import com.atguigu.c01.lamda.MyInterface;

public class TestDefaultInterface {
	
	public static void main(String[] args) {
		SubClass sc = new SubClass();
		System.out.println(sc.getName());
		
		MyInterface.show();
	}

}
