
import java.util.*;
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
public class TreeSetErrorTest2
{
	// ����ʱ����
	// Exception in thread "main" java.lang.ClassCastException: 
	// class Err cannot be cast to class java.lang.Comparable (Err is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	public static void main(String[] args)
	{
		var ts = new TreeSet();
		// ��TreeSet�����������������
		ts.add(new String("���Java����"));
		ts.add(new Date());   // ��
	}
}
