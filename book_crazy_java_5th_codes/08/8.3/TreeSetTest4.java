
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
class M
{
	int age;
	public M(int age)
	{
		this.age = age;
	}
	public String toString()
	{
		return "M [age:" + age + "]";
	}
}
public class TreeSetTest4
{
	public static void main(String[] args)
	{
		// �˴�Lambda���ʽ��Ŀ��������Comparator
		var ts = new TreeSet((o1, o2) ->
		{
			var m1 = (M) o1;
			var m2 = (M) o2;
			// ����M�����age������������С��ageԽ��M���󷴶�ԽС
			return m1.age > m2.age ? -1
				: m1.age < m2.age ? 1 : 0;
		});
		ts.add(new M(5));
		ts.add(new M(-3));
		ts.add(new M(9));
		System.out.println(ts);
	}
}

