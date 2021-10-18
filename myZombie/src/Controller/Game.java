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
		p = new Hero("���", 100, 100, 5, 1, 1);
		box.add(new Item(3, "���Ⱝȭ", 20, 2));
		enemy.add(new Zombie("����1", 25, 25, 5, 1, 5));
		box.add(new Item(2, "����ȭ", 10, 6));
		enemy.add(new Zombie("����2", 40, 40, 5, 1, 7));
		box.add(new Item(1, "����", 20, 8));
		enemy.add(new Zombie("����3", 55, 55, 5, 1, 10));
		box.add(new Item(3, "���Ⱝȭ", 20, 13));
		enemy.add(new Zombie("����4", 70, 70, 5, 1, 15));
		box.add(new Item(1, "����", 20, 16));
		box.add(new Item(1, "����", 50, 18));
		box.add(new Item(2, "����ȭ", 20, 19));
		enemy.add(new ZombieKing("����", 90, 90, 5, 1, 20, 50));
	}

	private int chkZombie() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getPos() == enemy.get(i).getPos()) {
				System.out.println("���� ��Ÿ����!");
				return i;
			}
		}
		return -1;
	}

	private int chkTreasure() {
		for (int j = 0; j < box.size(); j++) { // �������� �߰�
			if (p.getPos() == box.get(j).getPos()) {
				System.out.print("�������� �߰�!! >> ");
				if (box.get(j).getCode() == 1) {
					System.out.println("������ �����!");
					p.setCnt(p.getCnt() + 1);
				} else if (box.get(j).getCode() == 2) {
					System.out.println("���� �����!");
				} else if (box.get(j).getCode() == 3) {
					System.out.println("���⸦ �����!");
				}
				return j;
			}
		}
		return -1;
	}

	private int die(Unit unit) {
		if (p.getHp() <= 0) { // ��� ü�� ��� ����
			return 1;
		} else if (unit.getHp() <= 0) { // ���� ü�� ��� ����
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
			System.out.println("1.����  2.����(" + p.getCnt() + "��)");

			int sel = scan.nextInt();

			if (sel == 1) { // ����
				p.attack(enemy);
			} else if (sel == 2) { // ����
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
			System.out.println("����ߴ�...");
			System.out.println("GAME OVER");
			return false;
		} else {
			System.out.println("�¸��ߴ�!");
			return true;
		}
	}

	private void map(int a) {
		System.out.println("���� : " + p.getPos() + "��");
		System.out.print("1.�ö󰣴�. ");
		if (a == 1) {
			System.out.println("2.�κ��丮 ���");
		}
		System.out.println("-----------------");
	}

	public void run() {
		init();
		inven.init();
		int act = 1;
		while (true) {
			if (p.getPos() >= 20) {
				System.out.println("������ ����!");
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
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�.");
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
