package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Models.Hero;
import Models.Item;

public class Inventory {
	Scanner scan = new Scanner(System.in);

	public static ArrayList<Item> itemList = new ArrayList<>();

	public void init() {
		itemList.add(new Item(1, "����", 80));
		itemList.add(new Item(1, "����", 90));
		itemList.add(new Item(1, "����", 100));
	}

	public void Menu() {
		while (true) {

			System.out.println("[ Inventory ]");
			System.out.println("1.������ 2.�������");
			int sel = scan.nextInt();
			if (sel != 1 && sel != 2) {
				break;
			}
			if (sel == 1) {
				printPotionList();
				takePotion();
			} else if (sel == 2) {
				printArmsList();
				takeArms();				
			} else {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}

	// ���
	public void takePotion() {
		while(true) {
			System.out.print("���Ǽ��� (0.�ڷΰ���) : ");
			int selPotion = scan.nextInt();
			if (selPotion == 0) {
				break;
			}
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i) == itemList.get(selPotion - 1)) {
					System.out.println("ü��ȸ��! +" + itemList.get(selPotion - 1).getPower());
					Game.p.setHp(Game.p.getHp() + itemList.get(selPotion - 1).getPower());
					itemList.remove(i);
					Game.p.setCnt(Game.p.getCnt() - 1);
				}
			}
			
		}
	}

	public void takeArms() {

		while(true) {
			System.out.print("����� (0.�ڷΰ���) : ");
			int selArms = scan.nextInt();
			if (selArms == 0) {
				break;
			}
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i) == itemList.get(selArms - 1) && itemList.get(i).getCode() == 2) {
					System.out.println("���� ����! " + itemList.get(selArms - 1).getPower());
					Game.p.setDef(Game.p.getDef() + itemList.get(selArms - 1).getPower());
				} else if (itemList.get(i) == itemList.get(selArms - 1) && itemList.get(i).getCode() == 3) {
					System.out.println("���ݷ� ����! " + itemList.get(selArms - 1).getPower());
					Game.p.setAtt(Game.p.getAtt() + itemList.get(selArms - 1).getPower());
				}
				itemList.remove(i);
			}
		}
	}

	// ����Ʈ
	public void printPotionList() {
		System.out.println("ITEMS - Potion >>");
		int cnt = 1;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getCode() == 1) {
				System.out.println(cnt + ") " + itemList.get(i).getItem() + " �ɷ�ġ:" + itemList.get(i).getPower());
				cnt++;
			}
		}
	}

	public void printArmsList() {
		System.out.println("ITEMS - Arms >>");
		int cnt = 1;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getCode() != 1) {
				System.out.println(cnt + ") " + itemList.get(i).getItem() + " �ɷ�ġ:" + itemList.get(i).getPower());
				cnt++;
			}
		}
	}

}
