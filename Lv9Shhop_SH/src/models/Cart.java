package models;

public class Cart {
	public String userId; // 구입한 유저id
	public String itemName; // 구입한 아이템
	public int cnt; // 구매수량
	public void print() {
		System.out.println("[" + userId + "]" + "아이템 : " + itemName);
	}
	public void printPersonalCart() {
		System.out.println("아이템 : " + itemName+" "+cnt+"개");
	}
}
