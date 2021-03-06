package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Models.Item;
import Models.Player;
import Models.Unit;
import Models.Zombie;

public class Game {
	Random ran = new Random();
	public static Scanner scan = new Scanner(System.in);

	private static Game instance = new Game();

	private Game() {
	}

	public static Game getInstance() {
		return instance;
	}

	ArrayList<Unit> enemy = new ArrayList<>();
	ArrayList<Item> treasure = new ArrayList<>();
	Inventory inven = new Inventory();
	static Player pl;

	void floorSetting() { // 총20층
		pl = new Player("용사", 50, 10, 10, 1);
		treasure.add(new Item(1, "포션", 20, 3));
		enemy.add(new Zombie("좀비1", 30, 5, 5, 4));
		treasure.add(new Item(1, "포션", 20, 5));
		treasure.add(new Item(2, "무기강화약", 20, 7));
		enemy.add(new Zombie("좀비2", 50, 15, 15, 8));
		treasure.add(new Item(1, "포션", 40, 10));
		enemy.add(new Zombie("좀비3", 80, 20, 20, 12));
		treasure.add(new Item(2, "무기강화약", 30, 13));
		treasure.add(new Item(3, "방어강화약", 20, 15));
		enemy.add(new Zombie("좀비4", 100, 30, 30, 16));
		treasure.add(new Item(3, "방어강화약", 30, 18));
		treasure.add(new Item(1, "포션", 50, 19));
		enemy.add(new Zombie("좀비5", 120, 45, 45, 20));
	}

	void printMenu(int act) {
		System.out.println("[ " + pl.getPos() + "층 ]");
		System.out.println("1.올라간다");
		if (act == 1) {
			System.out.println("2.인벤토리 사용");
		}
	}

	int chkZombie() {
		for (int i = 0; i < enemy.size(); i++) {
			if (enemy.get(i).getPos() == pl.getPos()) {
				System.out.println("적 출현! ");
				return i;
			}
		}
		return -1;
	}

	int chkItem() {
		for (int i = 0; i < treasure.size(); i++) {
			if (treasure.get(i).getPos() == pl.getPos()) {
				System.out.println("보물상자를 발견했다!");
				if (treasure.get(i).getCode() == 1) {
					System.out.println("포션(" + treasure.get(i).getPow() + ") get!");
				} else if (treasure.get(i).getCode() == 2) {
					System.out.println("무기강화약(" + treasure.get(i).getPow() + ") get!");
				} else if (treasure.get(i).getCode() == 3) {
					System.out.println("방어강화약(" + treasure.get(i).getPow() + ") get!");
				}
				return i;
			}
		}
		return -1;
	}

	boolean fight(Unit enemy) {
		while (true) {
			System.out.println("     >> FIGHT <<");
			pl.printInfo();
			System.out.println("- - - - - - VS - - - - - -");
			enemy.printInfo();
			System.out.println("1.공격 2.체력회복(" + pl.getPoCnt() + "개)");
			int sel = scan.nextInt();
			if (sel == 1) {
				pl.attack(enemy);
			} else if (sel == 2) {
				inven.selectPotion();
			}
			// 적이 죽지 않는한 계속되는 싸움
			if (die(enemy) != 0) {
				break;
			}
			// enemy turn
			enemy.attack(pl);
			if (die(pl) != 0) {
				break;
			}
		}
		if (die(enemy) == 1) {
			System.out.println("Game Over....");
			return false;
		} else {
			System.out.println("Player 승리!!");
			return true;
		}

	}

	int die(Unit unit) {
		if (pl.getHp() <= 0) {
			return 1;
		} else if (unit.getHp() <= 0) {
			return 2;
		} else {
			return 0;
		}

	}

	int retire(Unit unit) {
		return 0;
	}

	public void run() {
		floorSetting();
		int act = 1;
		while (true) {
			if (pl.getPos() >= 20) {
				System.out.println("좀비왕을 물리치고 탑을 정복했다!!");
				break;
			}
			printMenu(act);
			int sel = scan.nextInt();
			System.out.println("========================");
			if (sel == 1) {
				pl.setPos(pl.getPos() + 1);
				// 좀비,아이템 있는지 확인
				int check1 = chkZombie();
				int check2 = chkItem();
				if (check1 != -1) {
					// fight
					if (!fight(enemy.get(check1))) {
						break;
					}
					check1 = -1;
				} else if (check2 != -1) {
					inven.itemList.add(new Item(treasure.get(check2).getCode(), treasure.get(check2).getName(),
							treasure.get(check2).getPow()));
					if (treasure.get(check2).getCode() == 1) {
						pl.setPoCnt(pl.getPoCnt() + 1);
					} else {
						pl.setArmCnt(pl.getArmCnt() + 1);
					}

				} else if (check1 == -1 && check2 == -1) {
					System.out.println("여긴 아무것도 없다.");
				}
				act = 1;
			} else if (sel == 2 && act == 1) {
				inven.printMenu();
				act = 2;
			} else {
				System.out.println("Wrong Number!");
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("========================");
		}
	}
}
