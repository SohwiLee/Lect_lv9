package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;

import models.Kiosk;
import models.Menu;
import models.MyUtil;

public class TeaPanel extends MyUtil {
	private int totalPrice = 0;
	private int itemCount[][] = new int[4][4];
	private String itemNames[][] = new String[4][4];
	private int itemPrices[][] = new int[4][4];
	// table
	TablePanel table = new TablePanel();
	// ����޴�
	private final int SIZE = 4;
	private JButton menuBtn[][] = new JButton[SIZE][SIZE];
	private int num = 1;
	private Menu item;

	int x = 100;
	int y = 80;
	int w = 120;
	int h = 130;

	// ��ư�� �̹��� ������
	public TeaPanel() {
		setLayout(null);
		setBounds(0, 0, Kiosk.width, 1000);
		setImages();
		add(table);

	}

	private void setImages() {
		// teaMenuSet
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.item = new Menu(Kiosk.TEA, num, w, h);
				this.menuBtn[i][j] = new JButton(this.item.getImage());
				this.menuBtn[i][j].setBounds(x, y, 150, 150);
				this.menuBtn[i][j].setBackground(Color.white);
				this.menuBtn[i][j].setBorderPainted(false);
				this.menuBtn[i][j].addActionListener(this);
				this.itemNames[i][j] = item.getItemName();
				this.itemPrices[i][j] = item.getPrice();
				this.itemCount[i][j] = 0;
				add(this.menuBtn[i][j]);
				num++;
				x += 150;
			}
			x = 100;
			y += 150;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				// �޴� Ŭ���� ���̺� ������ ������
				if (target == this.menuBtn[i][j]) {
					this.itemCount[i][j]++;
					if (!table.itemOrdered[i][j]) { // ������ �űԻ���
						addItems(this.itemNames[i][j], String.valueOf(this.itemPrices[i][j]),
								String.valueOf(this.itemCount[i][j]));
						table.itemOrdered[i][j] = true;
					} else { // �����߰�
						for (int k = 0; k < Kiosk.selectItems.size(); k++) {
							if (this.itemNames[i][j] == Kiosk.selectItems.get(k).get(0)) {
								Kiosk.selectItems.get(k).set(2, String.valueOf(itemCount[i][j]));
							}
						}
					}
					add(table, 0);
				}
			}
		}
		Kiosk.calculate();
		Kiosk.setTotal();
		add(Kiosk.totalText);
	}

	public void addItems(String menu, String price, String count) {
		Vector<String> itemList = new Vector<>();
		itemList.add(menu); // �޴�
		itemList.add(price); // ����
		itemList.add(count); // ����
		Kiosk.selectItems.add(itemList);

		revalidate();
		repaint();
	}

}
