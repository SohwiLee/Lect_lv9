package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Models.Hero;
import Models.Item;
import Models.Unit;
import Models.Zombie;
import Models.ZombieKing;

public class Game {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	// singleton pattern
	private static Game instance = new Game();

	private Game() {
	}

	public static Game getInstance() {
		return instance;
	};

	public static Hero p;
	private ArrayList<Unit> enemy = new ArrayList<>();
	private ArrayList<Item> box = new ArrayList<>();
	private Inventory inven = new Inventory();

	private void init() {
		p = new Hero("용사", 100, 100, 5, 1, 1);
		box.add(new Item(3, "무기강화", 20, 2));
		enemy.add(new Zombie("좀비1", 25, 25, 5, 1, 5));
		box.add(new Item(2, "방어구강화", 10, 6));
		enemy.add(new Zombie("좀비2", 40, 40, 5, 1, 7));
		box.add(new Item(1, "포션", 20, 8));
		enemy.add(new Zombie("좀비3", 55, 55, 5, 1, 10));
		box.add(new Item(3, "무기강화", 20, 13));
		enemy.add(new Zombie("좀비4", 70, 70, 5, 1, 15));
		box.add(new Item(1, "포션", 20, 16));
		box.add(new Item(1, "포션", 50, 18));
		box.add(new Item(2, "방어구강화", 20, 19));
		enemy.add(new ZombieKing("좀비", 90, 90, 5, 1, 20, 50));
	}

	private int chkZombie() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getPos() == enemy.get(i).getPos()) {
				System.out.println("좀비가 나타났다!");
				return i;
			}
		}
		return -1;
	}

	private int chkTreasure() {
		for (int j = 0; j < box.size(); j++) { // 보물상자 발견
			if (p.getPos() == box.get(j).getPos()) {
				System.out.print("보물상자 발견!! >> ");
				if (box.get(j).getCode() == 1) {
					System.out.println("포션을 얻었다!");
					p.setCnt(p.getCnt() + 1);
				} else if (box.get(j).getCode() == 2) {
					System.out.println("방어구를 얻었다!");
				} else if (box.get(j).getCode() == 3) {
					System.out.println("무기를 얻었다!");
				}
				return j;
			}
		}
		return -1;
	}

	private int die(Unit unit) {
		if (p.getHp() <= 0) { // 용사 체력 모두 깎임
			return 1;
		} else if (unit.getHp() <= 0) { // 좀비 체력 모두 깎임
			return 2;
		} else {
			return 0;
		}
	}

	private boolean fight(Unit enemy) {
		while (true) {
			p.print();
			System.out.println("--------- VS ---------");
			enemy.print();
			System.out.println("=================");
			System.out.println("1.공격  2.물약(" + p.getCnt() + "개)");

			int sel = scan.nextInt();

			if (sel == 1) { // 공격
				p.attack(enemy);
			} else if (sel == 2) { // 물약
				p.drink();
			}

			if (die(enemy) != 0) {
				break;
			}
			System.out.println("==== " + enemy.getName() + " turn ====");
			enemy.attack(p);
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
		}
		if (die(enemy) == 1) {
			System.out.println("사망했다...");
			System.out.println("GAME OVER");
			return false;
		} else {
			System.out.println("승리했다!");
			return true;
		}
	}

	private void map(int a) {
		System.out.println("현재 : " + p.getPos() + "층");
		System.out.print("1.올라간다. ");
		if (a == 1) {
			System.out.println("2.인벤토리 사용");
		}
		System.out.println("-----------------");
	}

	public void run() {
		init();
		inven.init();
		int act = 1;
		while (true) {
			if (p.getPos() >= 20) {
				System.out.println("생존에 성공!");
				break;
			}
			map(act);
			int sel = scan.nextInt();
			if (sel == 1) {
				p.setPos(p.getPos() + 1);
				int check = chkZombie();
				int check2 = chkTreasure();
				if (check != -1) { // fight
					boolean a = fight(enemy.get(check));
					if (a == false) {
						break;
					}
					check = -1;
				}
				if (check2 != -1) {
					inven.itemList.add(
							new Item(box.get(check2).getCode(), box.get(check2).getItem(), box.get(check2).getPower()));
				}
				if (check == -1 || check2 == -1) {
					System.out.println("아무일도 일어나지 않았다.");
				}

				act = 1;
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}

			} else if (sel == 2 && act == 1) {
				inven.Menu();
				act = 2;
			}
		}
	}
}
