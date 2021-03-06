package controller;

import java.util.ArrayList;

import models.Item;

public class Shop {
	ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "나무검";
		temp.power = 3;
		temp.price = 1000;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "철검";
		temp.power = 5;
		temp.price = 2000;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.WEAPON;
		temp.name = "레이피어";
		temp.power = 7;
		temp.price = 2500;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "티셔츠";
		temp.power = 1;
		temp.price = 300;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "가죽갑옷";
		temp.power = 4;
		temp.price = 800;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.ARMOR;
		temp.name = "강철갑옷";
		temp.power = 7;
		temp.price = 1500;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "은반지";
		temp.power = 7;
		temp.price = 3000;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "금반지";
		temp.power = 17;
		temp.price = 6000;
		itemList.add(temp);
		temp = new Item();
		temp.kind = Item.RING;
		temp.name = "다이아반지";
		temp.power = 35;
		temp.price = 20000;
		itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			System.out.println("=============== [상점] ================");
			System.out.println("1.무기 2.방어구 3.장신구 0.뒤로가기");
			int sel = MainGame.scan.nextInt();
			if (sel == 0)
				return;
			while (true) {
				if (sel == Item.WEAPON) {
					System.out.println("----------[무기]-----------");
				} else if (sel == Item.ARMOR) {
					System.out.println("---------[방어구]-----------");
				} else if (sel == Item.RING) {
					System.out.println("---------[장신구]-----------");
				}
				printItems(sel);
				System.out.println("내골드:" + Player.money + "G");
				System.out.print("구입할 아이템 번호 (0:뒤로가기) : ");
				int selItem = MainGame.scan.nextInt();
				if (selItem == 0) {
					break;
				}
				int count = 0;
				System.out.println("--------------------------");
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).kind == sel) {
						count++;
						if (count == selItem) {
							Player.inven.addItem(itemList.get(i));
							Player.money -= itemList.get(i).price;
							System.out.println(itemList.get(i).name + "를(을) 구입했습니다.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}

			}
		}

	}

	public void printItems(int kind) { // 종류선택
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).kind != kind) {
				continue;
			}
			System.out.print((count + 1) + ") ");
			System.out.print(itemList.get(i).name);
			System.out.print(" / 능력치:" + itemList.get(i).power);
			System.out.print(" / 가격:" + itemList.get(i).price + "\n");
			count++;
		}
	}

}
