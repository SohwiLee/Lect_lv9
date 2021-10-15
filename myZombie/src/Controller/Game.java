package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Models.Hero;
import Models.TreasureBox;
import Models.Unit;
import Models.Zombie;
import Models.ZombieKing;

public class Game {
	public static Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	// 물약 종류 다양화 (100/50/20회복)
	// 층 오를때마다 보물상자 얻도록
	// 보물상자 속 : 포션, 폭탄?
	// 남은체력 - 안뜨게
	// 인벤토리도 만들기
	private static Game instance = new Game();
	private Game() {}
	public static Game getInstance() {return instance;}
	
	private Hero pl;
	private ArrayList<Unit> enemy = new ArrayList<>();
	private ArrayList<TreasureBox> box = new ArrayList<>();

	private void init() {
		pl = new Hero("용사", 100, 100, 5, 1, 1);
		box.add(new TreasureBox("포션", 20, 3));
		enemy.add(new Zombie("좀비1", 25, 25, 5, 1, 4));
		box.add(new TreasureBox("방어구", 0, 20, 6));
		enemy.add(new Zombie("좀비2", 40, 40, 5, 1, 7));
		box.add(new TreasureBox("포션", 20, 8));
		enemy.add(new Zombie("좀비3", 55, 55, 5, 1, 10));
		box.add(new TreasureBox("무기", 20, 0, 13));
		enemy.add(new Zombie("좀비4", 70, 70, 5, 1, 15));
		box.add(new TreasureBox("포션", 20, 16));
		box.add(new TreasureBox("포션", 50, 18));
		box.add(new TreasureBox("포션", 50, 19));
		enemy.add(new ZombieKing("좀비", 90, 90, 5, 1, 20, 50));
	}
	
	private int check() {
		for(int i=0;i<enemy.size();i++) { // 좀비 발견
			if(pl.getPos() == enemy.get(i).getPos()) {
				System.out.println("좀비 출현!");
				return 1;
			}
		}
		for(int j=0;j<box.size();j++) { // 보물상자 발견
			if(pl.getPos()==box.get(j).getPos()) {
				System.out.println("보물상자 발견!!");
				return 2;
			}
		}
		return -1;
	}
	
	private int die(Unit unit) {return 0;}
	private boolean openBox() {return false;}
	private boolean fight(Unit enemy) {return false;}
	
	private void map(int f) {
		System.out.println("NOW : "+ pl.getPos()+"층");
		System.out.print("1.올라간다. ");
		if(f==1) {
			System.out.print("2.체력회복 3.무기강화\n");
		}
	}
	
	public void run() {
		System.out.println("[Zombie Tower...]");
		init();
		int act = 1;
		while(true) {
			if(pl.getPos()>20) {
				System.out.println("탑을 정복했다!");
				break;
			}
			
			map(act);
		}
	}
}
