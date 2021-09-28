package com.atguigu.java8;

import com.atguigu.c01.lamda.MyClass;
import com.atguigu.c01.lamda.MyInterface;

public class SubClass /*extends MyClass*/ implements MyClass, MyInterface{

	@Override
	public String getName() {
		return MyInterface.super.getName();
	}

}
