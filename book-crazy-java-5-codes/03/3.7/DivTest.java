

/**
 * Description:
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2020, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 5.0
 */
public class DivTest
{
	public static void main(String[] args)
	{
		var a = 5.2;
		var b = 3.1;
		var div = a / b;
		// div��ֵ����1.6774193548387097
		System.out.println(div);
		// ����������Infinity
		System.out.println("5����0.0�Ľ����:" + 5 / 0.0);
		// ����������-Infinity
		System.out.println("-5����0.0�Ľ����:" + - 5 / 0.0);
		// ������뽫�����쳣
		// java.lang.ArithmeticException: / by zero
		System.out.println("-5����0�Ľ����::" + -5 / 0);
	}
}

