package controller;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.Kiosk;
import models.MyUtil;

public class TablePanel extends MyUtil {

	// ���̺�� ������
	Vector<String> colName = new Vector<>();
	public boolean itemOrdered[][] = new boolean[4][4];
	JTable table = null;

	public TablePanel() {
		setLayout(null);
		setBounds(100, 680, 600, 120);
//		init();
		setTable();
	}

	private void init() {// test
		for (int i = 0; i < 100; i++) {
			Vector<String> data = new Vector<>();
			data.add(i + 1 + "");
			data.add(i + 1 + "");
			data.add(i + 1 + "");
			Kiosk.selectItems.add(data);
		}
	}

	private void setTable() {
		this.colName.add("�޴�");
		this.colName.add("����");
		this.colName.add("����");

//		this.table = new JTable(selectItems, colName);
		this.table = new JTable(Kiosk.selectItems, colName);
		this.table.setBounds(0, 0, 600, 120);
		this.table.setGridColor(Color.gray);
		this.table.setVisible(true);
		add(this.table);

		JScrollPane js = new JScrollPane(table); // ��ũ�Ѱ����ϵ���
		js.setBounds(0, 0, 600, 120);
		js.setAutoscrolls(true);// �ʿ�ÿ� ��ũ�ѹ� ����
		js.setVisible(true);
		add(js);

//		revalidate();repaint(); >> addItems �������� 
	}

}
