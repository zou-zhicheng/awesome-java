
import java.awt.*;
import java.awt.event.*;
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
public class CardLayoutTest
{
	Frame f = new Frame("���Դ���");
	String[] names = {"��һ��", "�ڶ���", "������",
		"������", "������"};
	Panel pl = new Panel();
	public void init()
	{
		final var c = new CardLayout();
		pl.setLayout(c);
		for (var i = 0; i < names.length; i++)
		{
			pl.add(names[i], new Button(names[i]));
		}
		var p = new Panel();
		ActionListener listener = e -> {
			switch (e.getActionCommand())
			{
				case "��һ��":
					c.previous(pl);
					break;
				case "��һ��":
					c.next(pl);
					break;
				case "��һ��":
					c.first(pl);
					break;
				case "���һ��":
					c.last(pl);
					break;
				case "������":
					c.show(pl, "������");
					break;
			}
		};
		// ������ʾ��һ�ŵİ�ť
		var previous = new Button("��һ��");
		previous.addActionListener(listener);
		// ������ʾ��һ�ŵİ�ť
		var next = new Button("��һ��");
		next.addActionListener(listener);
		// ������ʾ��һ�ŵİ�ť
		var first = new Button("��һ��");
		first.addActionListener(listener);
		// ������ʾ���һ�ŵİ�ť
		var last = new Button("���һ��");
		last.addActionListener(listener);
		// ���Ƹ���Card����ʾ�İ�ť
		var third = new Button("������");
		third.addActionListener(listener);
		p.add(previous);
		p.add(next);
		p.add(first);
		p.add(last);
		p.add(third);
		f.add(pl);
		f.add(p, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new CardLayoutTest().init();
	}
}
