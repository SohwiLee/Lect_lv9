package Controller;

import java.util.ArrayList;

import Models.Item;

public class Inventory {

	ArrayList<Item> itemList = new ArrayList<>();
	ArrayList<Item> potionAlign = new ArrayList<>();
	ArrayList<Item> armsAlign = new ArrayList<>();

	void printMenu() {
		while (true) {
			System.out.println("[ 인벤토리 ]");
			System.out.println("1.포션 2.강화제 0.뒤로가기");
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

	public void selectPotion() {
		while (true) {
			potionList();
			System.out.println("포션선택(0.뒤로가기):");
			int sel = Game.scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel > potionAlign.size()) {
				System.out.println("Wrong Number");
				continue;
			} else {
				sel -= 1;
				System.out.println(potionAlign.get(sel).getPow() + "의 체력 회복!");
				Game.pl.setHp(Game.pl.getHp() + potionAlign.get(sel).getPow());
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i) == potionAlign.get(sel)) {
						itemList.remove(i);
						Game.pl.setPoCnt(Game.pl.getPoCnt() - 1);
					}
				}
				potionAlign.remove(sel);
			}
		}

	}

	void selectArm() {
		while (true) {
			armList();
			System.out.println("아이템선택(0.뒤로가기):");
			int sel = Game.scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel > armsAlign.size()) {
				System.out.println("Wrong Number");
				continue;
			} else {
				sel -= 1;
				if (armsAlign.get(sel).getCode() == 2) {
					System.out.println(armsAlign.get(sel).getPow() + "만큼 무기강화!");
					Game.pl.setAtt(Game.pl.getAtt() + armsAlign.get(sel).getPow());
				} else if (armsAlign.get(sel).getCode() == 3) {
					Game.pl.setAtt(Game.pl.getDef() + armsAlign.get(sel).getPow());
					System.out.println(armsAlign.get(sel).getPow() + "만큼 방어강화!");
				}
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i) == armsAlign.get(sel)) {
						itemList.remove(i);
						Game.pl.setPoCnt(Game.pl.getPoCnt() - 1);
					}
				}
				armsAlign.remove(sel);
			}
		}
	}

	void potionList() {
		potionAlign.clear();
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getCode() == 1) {
				potionAlign.add(itemList.get(i));
			}
		}
		for (int i = 0; i < potionAlign.size(); i++) {
			System.out.println((i + 1) + ")" + potionAlign.get(i).getName() + "(" + potionAlign.get(i).getPow() + ")");
		}
	}

	void armList() {
		armsAlign.clear();
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getCode() != 1) {
				armsAlign.add(itemList.get(i));
			}
		}
		for (int i = 0; i < armsAlign.size(); i++) {
			System.out.println((i + 1) + ")" + armsAlign.get(i).getName() + "(" + armsAlign.get(i).getPow() + ")");
		}
	}

}
