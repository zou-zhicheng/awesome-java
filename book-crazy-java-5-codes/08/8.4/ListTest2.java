
import java.util.*;
/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 5.0
 */
class A
{
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class ListTest2
{
	public static void main(String[] args)
	{
		var books = new ArrayList();
		books.add("轻量级Java EE企业应用实战");
		books.add("疯狂Java讲义");
		books.add("疯狂Android讲义");
		System.out.println(books);
		// 删除集合中的A对象，将导致第一个元素被删除
		books.remove(new A());	 // ①
		System.out.println(books);
		// 删除集合中的A对象，再次删除集合中的第一个元素
		books.remove(new A());	 // ②
		System.out.println(books);
	}
}
