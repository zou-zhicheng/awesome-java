

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
public class AssignOperatorTest
{
	public static void main(String[] args)
	{
		var str = "Java"; // Ϊ����str��ֵΪJava
		var pi = 3.14; // Ϊ����pi��ֵΪ3.14
		var visited = true; // Ϊ����visited��ֵΪtrue
		var str2 = str; // ������str��ֵ����str2
		int a;
		int b;
		int c;
		// ͨ��Ϊa, b, c��ֵ������������ֵ����7
		a = b = c = 7;
		// �������������ֵ��
		System.out.println(a + "\n" + b + "\n" + c);

		var d1 = 12.34;
		var d2 = d1 + 5; // �����ʽ��ֵ����d2
		System.out.println(d2); // ���d2��ֵ�������17.34

	}
}
