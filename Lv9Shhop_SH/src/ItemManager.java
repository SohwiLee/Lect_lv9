import java.util.Scanner;
import java.util.Vector;

public class ItemManager {
	Scanner scan = new Scanner(System.in);
	Vector<String> category = new Vector<>(); 
	Vector<Item> itemList = new Vector<>(); // ��ü�����۸���Ʈ
	Vector<Cart> jangList = new Vector<>(); // ��ü ��ٱ���
	
	public ItemManager() {
		init();
	}
	public void init() {
		category.add("����");
		category.add("����");
		category.add("����");
		category.add("�����");
		Item temp = new Item("�����", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("ĭ��", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("����", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("����", 1800, category.get(1));
		itemList.add(temp);
		temp = new Item("�Ұ��", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("�ݶ�", 500, category.get(3));
		itemList.add(temp);
	}
	
	//��ٱ��ϸ���Ʈ
	public void printJang() {
		for(int i=0;i<jangList.size();i++) {
			jangList.get(i).print();
		}
	}
	public void printJang(User u) {
		for(int i=0;i<jangList.size();i++) {
			if(u.id.equals(jangList.get(i).userId)) {
				jangList.get(i).print();
			}
		}
	}
	
	// ī�װ���
	public void printCategory() {
		for(int i=0;i<category.size();i++) {
			System.out.println(category.get(i));
		}
	}
	
	// �����۸���Ʈ
	public void printItemList() {}

}
