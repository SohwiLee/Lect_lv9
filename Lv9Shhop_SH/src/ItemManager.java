import java.util.Scanner;
import java.util.Vector;

public class ItemManager {
	Scanner scan = new Scanner(System.in);
	Vector<String> category = new Vector<>(); 
	Vector<Item> itemList = new Vector<>(); // 전체아이템리스트
	Vector<Cart> jangList = new Vector<>(); // 전체 장바구니
	
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
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
	}
	
	//장바구니리스트
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
	
	// 카테고리들
	public void printCategory() {
		for(int i=0;i<category.size();i++) {
			System.out.println(category.get(i));
		}
	}
	
	// 아이템리스트
	public void printItemList() {}

}
