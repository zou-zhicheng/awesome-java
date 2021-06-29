
import java.util.ArrayList;

import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Description:
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 5.0
 */
public class DefaultTableModelTest
{
	JFrame mainWin = new JFrame("���������С�������");
	final int COLUMN_COUNT = 5;
	DefaultTableModel model;
	JTable table;
	// ���ڱ��汻�����е�List����
	ArrayList<TableColumn> hiddenColumns = new ArrayList<>();
	public void init()
	{
		model = new DefaultTableModel(COLUMN_COUNT, COLUMN_COUNT);
		for (var i = 0; i < COLUMN_COUNT; i++)
		{
			for (var j = 0; j < COLUMN_COUNT; j++)
			{
				model.setValueAt("�ϵ�Ԫ��ֵ " + i + " " + j, i, j);
			}
		}
		table = new JTable(model);
		mainWin.add(new JScrollPane(table), BorderLayout.CENTER);
		// Ϊ���ڰ�װ�˵�
		var menuBar = new JMenuBar();
		mainWin.setJMenuBar(menuBar);
		var tableMenu = new JMenu("����");
		menuBar.add(tableMenu);
		var hideColumnsItem = new JMenuItem("����ѡ����");
		hideColumnsItem.addActionListener(event -> {
			// ��ȡ����ѡ���е�����
			int[] selected = table.getSelectedColumns();
			TableColumnModel columnModel = table.getColumnModel();
			// ���ΰ�ÿһ��ѡ�е���������������ʹ��List������Щ��
			for (var i = selected.length - 1; i >= 0; i--)
			{
				TableColumn column = columnModel.getColumn(selected[i]);
				// ����ָ����
				table.removeColumn(column);
				// �����ص��б���������ȷ���Ժ������ʾ����
				hiddenColumns.add(column);
			}
		});
		tableMenu.add(hideColumnsItem);
		var showColumnsItem = new JMenuItem("��ʾ������");
		showColumnsItem.addActionListener(event -> {
			// ������������������ʾ����
			for (var tc : hiddenColumns)
			{
				// ���ΰ��������ص�����ʾ����
				table.addColumn(tc);
			}
			// ��ձ��������е�List����
			hiddenColumns.clear();
		});
		tableMenu.add(showColumnsItem);
		var addColumnItem = new JMenuItem("����ѡ����");
		addColumnItem.addActionListener(event -> {
			// ��ȡ����ѡ���е�����
			int[] selected = table.getSelectedColumns();
			TableColumnModel columnModel = table.getColumnModel();
			// ���ΰ�ѡ�е�����ӵ�JTable֮��
			for (var i = selected.length - 1; i >= 0; i--)
			{
				TableColumn column = columnModel.getColumn(selected[i]);
				table.addColumn(column);
			}
		});
		tableMenu.add(addColumnItem);
		var addRowItem = new JMenuItem("������");
		addRowItem.addActionListener(event -> {
			// ����һ��String������Ϊ�����е�����
			var newCells = new String[COLUMN_COUNT];
			for (var i = 0; i < newCells.length; i++)
			{
				newCells[i] = "�µ�Ԫ��ֵ " + model.getRowCount()
					+ " " + i;
			}
			// ��TableModel������һ�С�
			model.addRow(newCells);
		});
		tableMenu.add(addRowItem);
		var removeRowsItem = new JMenuItem("ɾ��ѡ����");
		removeRowsItem.addActionListener(event -> {
			// ��ȡ����ѡ����
			int[] selected = table.getSelectedRows();
			// ����ɾ������ѡ����
			for (var i = selected.length - 1; i >= 0; i--)
			{
				model.removeRow(selected[i]);
			}
		});
		tableMenu.add(removeRowsItem);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DefaultTableModelTest().init();
	}
}
