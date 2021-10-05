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

	// ��ٱ��ϸ���Ʈ
	public void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).print();
		}
	}

	public void printJang(User u) {
		for (int i = 0; i < jangList.size(); i++) {
			if (u.id.equals(jangList.get(i).userId)) {
				jangList.get(i).print();
			}
		}
	}

	// ī�װ���
	public void printCategory() {
		for (int i = 0; i < category.size(); i++) {
			System.out.print((i+1)+") ");
			System.out.println(category.get(i));
		}
	}

	// �����۸���Ʈ
	public void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print((i+1)+") ");
			itemList.get(i).print();
		}
	}

	public void printItemList(int caId) {
		int n = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caId).equals(itemList.get(i).category)) {
				System.out.print((n+1)+") ");
				itemList.get(i).print();
				n++;
			}
		}
	}

	// ��ٱ��Ͽ� ���ξ����� �߰�
	public void addCart(String userId, int categoryId, int itemId) {
		int n = 0;
		Cart temp = new Cart();
		temp.userId = userId;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(categoryId).equals(itemList.get(i).category)) {
				if (itemId == n) {
					temp.itemName = itemList.get(i).name;
				}
				n++;
			}
		}
		jangList.add(temp);
	}

	public void addItem() {
		System.out.print("�߰��� ������ : ");
		String name = scan.next();
		System.out.print("������ ����: ");
		int price = scan.nextInt();
		printCategory();
		System.out.print("ī�װ� ����(1~"+category.size()+") : ");
		int sel = scan.nextInt()-1;
		Item temp = new Item(name, price, category.get(sel));
		itemList.add(temp);
	}

	public void removeItem() {
		printItemList();
		System.out.print("������ ������ : ");
		String name = scan.next();
		boolean check=true;
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).name.equals(name)) {
				check=false;
				itemList.remove(i);
				System.out.println("�����Ϸ�");
			}
		}
		if(check) {
			System.out.println("�������� �ʴ� �������Դϴ�.");
		}
	}

	public void addCategory() {
		System.out.print("�߰��� ī�װ� : ");
		String name = scan.next();
		boolean check=true;
		for(int i=0;i<category.size();i++) {
			if(category.get(i).equals(name)) {
				check=false;
			}
		}
		if(!check) {
			System.out.println("�̹� �����ϴ� ī�װ��Դϴ�.");
		}else{
			category.add(name);
		}
		
		
	}

	public void removeCategory() {
		printCategory();
		System.out.print("������ ī�װ� : ");
		String name = scan.next();
		boolean check=true;
		for(int i=0;i<category.size();i++) {
			if(category.get(i).equals(name)) {
				check=false;
				category.remove(i);
				System.out.println("�����Ϸ�");
			}
		}
		if(check) {
			System.out.println("���� ī�װ��Դϴ�.");
		}
		
	}

}
