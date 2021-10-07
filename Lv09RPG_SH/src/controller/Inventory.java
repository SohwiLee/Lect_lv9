package controller;

import java.util.ArrayList;

import models.Item;

public class Inventory {

	public ArrayList<Item> itemList = new ArrayList<>();;

	public void inventoryMenu() {
		while (true) {
			System.out.println("=============== [장비함] ================");
			System.out.println("1.착용 2.판매 0.뒤로가기");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				equipMenu();
			} else if (sel == 2) {
				sellMenu();
			} else {
				break;
			}

		}
	}

	public void equipMenu() {
		Player.guild.printAllUnitStatus(); // 전체 길드원 중 택1명
		System.out.print("길드원 선택 : ");
		int selUnit=MainGame.scan.nextInt();
		while(true) {
			// 선택한 길드원의 정보 보여주기
			Player.guild.printUnitStatus(selUnit-1);
			Player.guild.printUnitItem(selUnit-1);
			printItemList();
			System.out.print("착용할 아이템 번호 (0.뒤로가기) : ");
			int selEquip = MainGame.scan.nextInt();
		}
		
	}
	
	public void printItemList() {
		System.out.println("아이템 리스트 >>");
		for(int i=0;i<itemList.size();i++) {
			System.out.println((i+1)+") ");
			System.out.print(itemList.get(i).name);
			System.out.print(" / 능력치:" + itemList.get(i).power);
			System.out.print(" / 가격:" + itemList.get(i).price+"\n");
			
		}
	}

	public void sellMenu() {
		// TODO Auto-generated method stub
		
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

}
