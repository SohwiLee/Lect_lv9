package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;

import models.Kiosk;
import models.Menu;
import models.MyUtil;

public class CoffeePanel extends MyUtil {
	private int itemCount[][] = new int[4][4]; // 개당 총 개수
	private String itemNames[][] = new String[4][4];
//	private boolean itemOrdered[][] = new boolean[4][4]; // 1개주문상태
	private int itemPrices[][] = new int[4][4];
	// table
	TablePanel table = new TablePanel();
	// JLabel total = new JLabel();
	// 음료메뉴
	private final int SIZE = 4;
	private JButton menuBtn[][] = new JButton[SIZE][SIZE];

	private int num = 1;

	private Menu item;
	int x = 100;
	int y = 80;
	int w = 120;
	int h = 130;

	// 버튼에 이미지 입히기
	public CoffeePanel() {
		setBackground(Color.blue);
		setLayout(null);
		setBounds(0, 80, Kiosk.width, 600);
		setImages();
//		setLabel();
	}

//	private void setLabel() {
//		this.total.setBounds(100, 770, 550, 100);
//		this.total.setHorizontalAlignment(JLabel.RIGHT);
//		this.total.setText("합계 : " +0+ "원");
//		
//		this.total.setFont(new Font("", Font.BOLD, 25));
//		add(this.total);
//	}

//2>6>18
	private void setImages() {
		// coffeeMenuSet
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.item = new Menu(Kiosk.COFFEE, num, w, h);
				this.menuBtn[i][j] = new JButton(this.item.getImage());
				this.menuBtn[i][j].setBounds(x, y, 150, 150);
				this.menuBtn[i][j].setBackground(Color.white);
				this.menuBtn[i][j].setBorderPainted(false);
				this.menuBtn[i][j].addActionListener(this);
//				this.itemNames[i][j] = item.getFileName().substring(23,25);
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
//		table.totalPrice = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				// 메뉴 클릭시 테이블에 생성할 데이터
				if (target == this.menuBtn[i][j]) {
					this.itemCount[i][j]++;
					if (!table.itemOrdered[i][j]) { // 데이터 신규생성
						table.addItems(this.itemNames[i][j], String.valueOf(this.itemPrices[i][j]),
								String.valueOf(this.itemCount[i][j]));
						table.itemOrdered[i][j] = true;
					} else { // 개수추가
						for (int k = 0; k < table.selectItems.size(); k++) {
							if (this.itemNames[i][j] == table.selectItems.get(k).get(0)) {
								table.selectItems.get(k).set(2, String.valueOf(this.itemCount[i][j]));
							}
						}
					}
					add(table, 0);

				}
			}
		}

//		for (int k = 0; k < table.selectItems.size(); k++) {
////			System.out.println(table.selectItems.get(k).get(1) + "*" + table.selectItems.get(k).get(2));
//			totalPrice += (Integer.parseInt(table.selectItems.get(k).get(1))
//					* Integer.parseInt(table.selectItems.get(k).get(2)));
//		}
//		System.out.println(totalPrice);
//		this.total.setText("합계 : " +totalPrice+ "원");
	}

//	public void addItems(String menu, String price, String count) {
//		table.itemList = new Vector<>();
//		table.itemList.add(menu); // 메뉴
//		table.itemList.add(price); // 가격
//		table.itemList.add(count); // 수량
//		table.selectItems.add(table.itemList);
//		revalidate();
//		repaint();
//	}

}
