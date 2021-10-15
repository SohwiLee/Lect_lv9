package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Models.Hero;
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

	private Hero p;
	private ArrayList<Unit> enemy = new ArrayList<>();

	private void init() {
		p = new Hero("용사", 100, 5, 1, 1);
		enemy.add(new Zombie("그냥좀비", 25, 5, 1, 3));
		enemy.add(new Zombie("힘쌘좀비", 45, 10, 2, 6));
		enemy.add(new Zombie("정예좀비", 65, 15, 3, 9));
		enemy.add(new ZombieKing("좀비왕", 100, 20, 4, 12, 50));
	}

	private int chk() {
		for (int i = 0; i < enemy.size(); i++) {
			if (p.getPos() == enemy.get(i).getPos()) {
				System.out.println("좀비가 나타났다!");
				return i;
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
			System.out.println("---- VS ----");
			enemy.print();
			System.out.println("============");
			System.out.println("1.공격  2.물약(" + p.getCnt() + "개)");

			int sel = scan.nextInt();

			if (sel == 1) { // 공격
			} else if (sel == 2) { // 물약
				p.drink();
			}
			
			if(die(enemy)!=0) { break;}
			System.out.println("============");
			
		}
		return false;
	}

	public void run() {
	}
}
