
import java.awt.*;
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
public class FlowLayoutTest
{
	public static void main(String[] args)
	{
		var f = new Frame("���Դ���");
		// ����Frame����ʹ��FlowLayout���ֹ�����
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		// �򴰿�������10����ť
		for (var i = 0; i < 10; i++)
		{
			f.add(new Button("��ť" + i));
		}
		// ���ô���Ϊ��Ѵ�С
		f.pack();
		// ��������ʾ������Frame����Ĭ�ϴ�������״̬��
		f.setVisible(true);
	}
}
