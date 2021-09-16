package com.atguigu.c01.lamda;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
