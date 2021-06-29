

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
public class NestedLoopTest
{
	public static void main(String[] args)
	{
		// 外层循环
		for (var i = 0; i < 5; i++)
		{
			// 内层循环
			for (var j = 0; j < 3; j++)
			{
				System.out.println("i的值为:" + i + "  j的值为:" + j);
			}
		}
	}
}
