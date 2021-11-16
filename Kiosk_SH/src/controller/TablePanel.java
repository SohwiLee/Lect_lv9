package controller;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.MyUtil;

public class TablePanel extends MyUtil {

	// 테이블용 데이터
	public Vector<Vector<String>> selectItems = new Vector<>();
	Vector<String> colName = new Vector<>();
//	Vector<String> itemList=new Vector<>();
	Vector<String> itemList;
	public boolean itemOrdered[][] = new boolean[4][4];
	JTable table = null;

	int totalPrice;

	public TablePanel() {
		setLayout(null);
		setBounds(100, 680, 600, 120);
//		init();
		setTable();
	}

	public void addItems(String menu, String price, String count) {
		this.itemList = new Vector<>();
		this.itemList.add(menu); // 메뉴
		this.itemList.add(price); // 가격
		this.itemList.add(count); // 수량
		this.selectItems.add(this.itemList);
	
		revalidate();
		repaint();
	}

	private void init() {
		for (int i = 0; i < 100; i++) {
			Vector<String> data = new Vector<>();
			data.add(i + 1 + "");
			data.add(i + 1 + "");
			data.add(i + 1 + "");
			selectItems.add(data);
		}
	}

	private void setTable() {
		this.colName.add("메뉴");
		this.colName.add("가격");
		this.colName.add("개수");

		this.table = new JTable(selectItems, colName);
		this.table.setBounds(0, 0, 600, 120);
		this.table.setGridColor(Color.gray);
		this.table.setVisible(true);
		add(this.table);

		JScrollPane js = new JScrollPane(table); // 스크롤가능하도록
		js.setBounds(0, 0, 600, 120);
		js.setAutoscrolls(true);// 필요시에 스크롤바 등장
		js.setVisible(true);
		add(js);

//		revalidate();repaint(); >> addItems 마지막에 
	}

}
