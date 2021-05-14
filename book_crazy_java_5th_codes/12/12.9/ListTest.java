
import java.util.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
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
public class ListTest
{
	private JFrame mainWin = new JFrame("�����б��");
	String[] books = new String[] {
		"���Java����",
		"������Java EE��ҵӦ��ʵս",
		"���Android����",
		"���Ajax����",
		"����Java EE��ҵӦ��ʵս",
	};
	// ��һ���ַ�������������һ��JList����
	JList<String> bookList = new JList<>(books);
	JComboBox<String> bookSelector;
	// ���岼��ѡ��ť���ڵ����
	JPanel layoutPanel = new JPanel();
	ButtonGroup layoutGroup = new ButtonGroup();
	// ����ѡ��ģʽ��ť���ڵ����
	JPanel selectModePanel = new JPanel();
	ButtonGroup selectModeGroup = new ButtonGroup();
	JTextArea favorite = new JTextArea(4, 40);
	public void init()
	{
		// ����JList�Ŀ��Ӹ߶ȿ�ͬʱ��ʾ�����б���
		bookList.setVisibleRowCount(3);
		// Ĭ��ѡ�е�����������һ���������0��
		bookList.setSelectionInterval(2, 4);
		addLayoutButton("�������", JList.VERTICAL);
		addLayoutButton("������", JList.VERTICAL_WRAP);
		addLayoutButton("������", JList.HORIZONTAL_WRAP);
		addSelectModelButton("������", ListSelectionModel
			.MULTIPLE_INTERVAL_SELECTION);
		addSelectModelButton("��ѡ", ListSelectionModel
			.SINGLE_SELECTION);
		addSelectModelButton("����Χ", ListSelectionModel
			.SINGLE_INTERVAL_SELECTION);
		var listBox = new Box(BoxLayout.Y_AXIS);
		// ��JList�������JScrollPane�У��ٽ���JScrollPane��ӵ�listBox������
		listBox.add(new JScrollPane(bookList));
		// ��Ӳ���ѡ��ť��塢ѡ��ģʽ��ť���
		listBox.add(layoutPanel);
		listBox.add(selectModePanel);
		// ΪJList����¼�������
		bookList.addListSelectionListener(e -> {  // ��
			// ��ȡ�û���ѡ�������ͼ��
			List<String> books = bookList.getSelectedValuesList();
			favorite.setText("");
			for (var book : books )
			{
				favorite.append(book + "\n");
			}
		});
		Vector<String> bookCollection = new Vector<>();
		bookCollection.add("���Java����");
		bookCollection.add("������Java EE��ҵӦ��ʵս");
		bookCollection.add("���Android����");
		bookCollection.add("���Ajax����");
		bookCollection.add("����Java EE��ҵӦ��ʵս");
		// ��һ��Vector����������һ��JComboBox����
		bookSelector = new JComboBox<>(bookCollection);
		// ΪJComboBox����¼�������
		bookSelector.addItemListener(e -> {  // ��
			// ��ȡJComboBox��ѡ�е���
			Object book = bookSelector.getSelectedItem();
			favorite.setText(book.toString());
		});
		// ���ÿ���ֱ�ӱ༭
		bookSelector.setEditable(true);
		// ���������б��Ŀ��Ӹ߶ȿ�ͬʱ��ʾ4���б���
		bookSelector.setMaximumRowCount(4);
		var p = new JPanel();
		p.add(bookSelector);
		var box = new Box(BoxLayout.X_AXIS);
		box.add(listBox);
		box.add(p);
		mainWin.add(box);
		var favoritePanel = new JPanel();
		favoritePanel.setLayout(new BorderLayout());
		favoritePanel.add(new JScrollPane(favorite));
		favoritePanel.add(new JLabel("��ϲ����ͼ�飺"),
			BorderLayout.NORTH);
		mainWin.add(favoritePanel, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	private void addLayoutButton(String label, final int orientation)
	{
		layoutPanel.setBorder(new TitledBorder(new EtchedBorder(),
			"ȷ��ѡ���"));
		var button = new JRadioButton(label);
		// �Ѹõ�ѡ��ť��ӵ�layoutPanel�����
		layoutPanel.add(button);
		// Ĭ��ѡ�е�һ����ť
		if (layoutGroup.getButtonCount() == 0)
		button.setSelected(true);
		layoutGroup.add(button);
		button.addActionListener(event ->
			// �ı��б�����б���Ĳ��ַ���
			bookList.setLayoutOrientation(orientation));
	}
	private void addSelectModelButton(String label, final int selectModel)
	{
		selectModePanel.setBorder(new TitledBorder(new EtchedBorder(),
			"ȷ��ѡ��ģʽ"));
		var button = new JRadioButton(label);
		// �Ѹõ�ѡ��ť��ӵ�selectModePanel�����
		selectModePanel.add(button);
		// Ĭ��ѡ�е�һ����ť
		if (selectModeGroup.getButtonCount() == 0)
			button.setSelected(true);
		selectModeGroup.add(button);
		button.addActionListener(event ->
			// �ı��б�����ѡ��ģʽ
			bookList.setSelectionMode(selectModel));
	}
	public static void main(String[] args)
	{
		new ListTest().init();
	}
}
