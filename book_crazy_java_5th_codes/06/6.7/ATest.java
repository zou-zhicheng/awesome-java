

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
interface A
{
	void test();
}
public class ATest
{
	public static void main(String[] args)
	{
		int age = 8;     // ①
		// 下面代码将会导致编译错误
		// 由于age局部变量被匿名内部类访问了，因此age相当于被final修饰了
		// 能运行, 但最终结果还是8
		// age = 2;
		var a = new A()
		{
			public void test()
			{
				// 在Java 8以前下面语句将提示错误: age必须使用final修饰
				// 从Java 8开始, 匿名内部类, 局部内部类允许访问非final的局部变量
				System.out.println(age);
			}
		};
		a.test();
	}
}

