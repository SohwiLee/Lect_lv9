package models;

public class Cart {
	public String userId; // ������ ����id
	public String itemName; // ������ ������
	public int cnt; // ���ż���
	public void print() {
		System.out.println("[" + userId + "]" + "������ : " + itemName);
	}
	public void printPersonalCart() {
		System.out.println("������ : " + itemName+" "+cnt+"��");
	}
}
