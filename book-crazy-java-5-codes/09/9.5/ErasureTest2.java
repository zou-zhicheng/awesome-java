
import java.util.*;
/**
 * Description:
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 5.0
 */
public class ErasureTest2
{
	public static void main(String[] args)
	{
		List<Integer> li = new ArrayList<>();
		li.add(6);
		li.add(9);
		List list = li;
		// 下面代码引起“未经检查的转换”的警告，编译、运行时完全正常
		List<String> ls = list;     // ①
		// 但只要访问ls里的元素，如下面代码将引起运行时异常。
		// Exception in thread "main" java.lang.ClassCastException: 
		// class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
		// at ErasureTest2.main(ErasureTest2.java:24)
		System.out.println(ls.get(0));
	}
}
