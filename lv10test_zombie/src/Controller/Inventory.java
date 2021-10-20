package Controller;

import java.util.ArrayList;

import Models.Item;

public class Inventory {

	ArrayList<Item> itemList = new ArrayList<>();
	int cnt;

	void itemSetting() {
	}

	void printMenu() {
		while (true) {
			System.out.println("[ �κ��丮 ]");
			System.out.println("1.���� 2.��ȭ�� 0.�ڷΰ���");
			int sel = Game.scan.nextInt();
			if (sel == 1) {
				selectPotion();
			} else if (sel == 2) {
				selectArm();
			} else if (sel == 0) {
				break;
			} else {
				System.out.println("Wrong Number!");
			}
		}
	}

	void selectPotion() {
		while (true) {
			potionList();
			System.out.println("���Ǽ���(0.�ڷΰ���):");
			int sel = Game.scan.nextInt();
			if (sel == 0) {
				break;
			}
			if (cnt == sel) {
				Game.pl.setHp(Game.pl.getHp() + itemList.get(sel).getPow());
				System.out.println(itemList.get(sel).getPow() + "�� ü���� ȸ���ߴ�!");
				itemList.remove(sel);
			}
		}

	}

	void selectArm() {
		while (true) {
			armList();
			System.out.println("�����ۼ���(0.�ڷΰ���):");
			int sel = Game.scan.nextInt();
			if (sel == 0) {
				break;
			}
			if (cnt == sel) {
				if (itemList.get(sel).getCode() == 2) {
					Game.pl.setAtt(Game.pl.getAtt() + itemList.get(sel).getPow());
					System.out.println("���Ⱝȭ! +" + itemList.get(sel).getPow());
				} else if (itemList.get(sel).getCode() == 3) {
					Game.pl.setDef(Game.pl.getDef() + itemList.get(sel).getPow());
					System.out.println("��ȭ! +" + itemList.get(sel).getPow());
				}
				itemList.remove(sel);
			}
		}
	}

	void potionList() {
		cnt = 1;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getCode() == 1) {
				System.out.println(cnt + ")" + itemList.get(i).getName() + "(" + itemList.get(i).getPow() + ")");
				cnt++;
			}
		}
	};

	void armList() {
		cnt = 1;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getCode() != 1) {
				System.out.println(cnt + ")" + itemList.get(i).getName() + "(" + itemList.get(i).getPow() + ")");
				cnt++;
			}
		}
	};

}
