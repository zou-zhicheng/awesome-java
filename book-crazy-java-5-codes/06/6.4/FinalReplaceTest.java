

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
public class FinalReplaceTest
{
	public static void main(String[] args)
	{
		// 下面定义了4个final“宏变量”
		final var a = 5 + 2;
		final var b = 1.2 / 3;
		final var str = "疯狂" + "Java";
		final var book = "疯狂Java讲义：" + 99.0;
		// 下面的book2变量的值因为调用了方法，所以无法在编译时被确定下来
		final var book2 = "疯狂Java讲义：" + String.valueOf(99.0);  // ①
		// true
		System.out.println(book == "疯狂Java讲义：99.0");
		// false
		System.out.println(book2 == "疯狂Java讲义：99.0");
	}
}
