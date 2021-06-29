

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
interface Foo<T>
{
	void test(T t);
}
public class AnnoymousDiamond
{
	public static void main(String[] args)
	{
		// 指定Foo类中泛型为String
		Foo<String> f1 = new Foo<>()
		{
			// test()方法的参数类型为String
			public void test(String t)
			{
				System.out.println("test方法的t参数为：" + t);
			}
		};
		f1.test("f1");
		// 使用泛型通配符，此时相当于通配符的上限为Object
		Foo<?> f2 = new Foo<>()
		{
			// test()方法的参数类型为Object
			public void test(Object t)
			{
				System.out.println("test方法的Object参数为：" + t);
			}
		};
		// f2.test(new String("f2"));
		// 使用泛型通配符，通配符的上限为Number
		Foo<? extends Number> f3 = new Foo<>()
		{
			// 此时test()方法的参数类型为Number
			public void test(Number t)
			{
				System.out.println("test方法的Number参数为：" + t);
			}
		};
		// f3.test(Integer.valueOf(3));
	}
}
