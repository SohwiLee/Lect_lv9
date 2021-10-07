package controller;

import java.util.Scanner;
import java.util.Vector;

import models.Cart;
import models.Item;
import models.User;

public class ItemManager {
	Scanner scan = new Scanner(System.in);
	public Vector<String> category = new Vector<>();
	Vector<Item> itemList = new Vector<>(); // 전체아이템리스트
	Vector<Cart> jangList = new Vector<>(); // 전체 장바구니
	Vector<Cart> count = new Vector<>();
	
	
	//setCount
	public void seCount() {
		
	}

	public ItemManager() {
		init();
	}
	
	

	public void init() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("닭가슴살", 5500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("사이다", 700, category.get(3));
		itemList.add(temp);
	}

	// 장바구니리스트
	public void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).print();
		}
	}

	// 개인 장바구니리스트
	public void printJang(User u) {
		for (int i = 0; i < jangList.size(); i++) {
			if (u.id.equals(jangList.get(i).userId)) {
				jangList.get(i).printPersonalCart();
				System.out.println(count.get(i).cnt);
			}
		}
	}

	// 카테고리들
	public void printCategory() {
		for (int i = 0; i < category.size(); i++) {
			System.out.print((i + 1) + ") ");
			System.out.println(category.get(i));
		}
	}

	// 아이템리스트
	public void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print((i + 1) + ") ");
			itemList.get(i).print();
		}
	}

	public void printItemList(int caId) {
		int n = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caId).equals(itemList.get(i).category)) {
				System.out.print((n + 1) + ") ");
				itemList.get(i).print();
				n++;
			}
		}
	}

	public int itemListSize(int index) {
		return itemList.get(index).category.length();
	}

	// 장바구니에 쇼핑아이템 추가
	public void addCart(String userId, int categoryId, int itemId) {
		int n = 0;
		Cart temp = new Cart();
		System.out.print(":::");
		for(int i=0;i<count.size();i++) {
			System.out.println(count.get(i)+" ");
		} 
		System.out.println();
		
		temp.userId = userId;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(categoryId).equals(itemList.get(i).category)) {
				if (itemId == n) {
					temp.itemName = itemList.get(i).name;
					for (int j = 0; j < jangList.size(); j++) {
						if (jangList.get(j).itemName.equals(temp.itemName)) {
							count.get(j).cnt++;
						}
					}
				}
				n++;
			}
		}
		int check = -1;
		for (int i = 0; i < jangList.size(); i++) {
			if (jangList.get(i).itemName.equals(temp.itemName)) {
				check = i;
			}
		}

		if (check == -1) {
			jangList.add(temp);
		}

	}

	public void addItem() {
		System.out.print("추가할 아이템 : ");
		String name = scan.next();
		boolean check = true;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).name.equals(name)) {
				check = false;
			}
		}
		if (check) {
			System.out.print("아이템 가격: ");
			int price = scan.nextInt();
			printCategory();
			System.out.print("카테고리 선택(1~" + category.size() + ") : ");
			int sel = scan.nextInt() - 1;
			Item temp = new Item(name, price, category.get(sel));
			itemList.add(temp);
		} else {
			System.out.println("이미 존재하는 아이템입니다.");
		}
	}

	public void removeItem() {
		printItemList();
		System.out.print("삭제할 아이템 : ");
		String name = scan.next();
		boolean check = true;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).name.equals(name)) {
				check = false;
				itemList.remove(i);
				System.out.println("삭제완료");
			}
		}
		if (check) {
			System.out.println("존재하지 않는 아이템입니다.");
		}
	}

	public void addCategory() {
		System.out.print("추가할 카테고리 : ");
		String name = scan.next();
		boolean check = true;
		for (int i = 0; i < category.size(); i++) {
			if (category.get(i).equals(name)) {
				check = false;
			}
		}
		if (!check) {
			System.out.println("이미 존재하는 카테고리입니다.");
		} else {
			category.add(name);
		}

	}

	public void removeCategory() {
		printCategory();
		System.out.print("삭제할 카테고리 : ");
		String name = scan.next();
		boolean check = true;
		for (int i = 0; i < category.size(); i++) {
			if (category.get(i).equals(name)) {
				check = false;
				category.remove(i);
				System.out.println("삭제완료");
			}
		}
		if (check) {
			System.out.println("없는 카테고리입니다.");
		}

	}

}
