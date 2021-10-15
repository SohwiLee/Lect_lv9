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
	// ���� ���� �پ�ȭ (100/50/20ȸ��)
	// �� ���������� �������� �򵵷�
	// �������� �� : ����, ��ź?
	// ����ü�� - �ȶ߰�
	// �κ��丮�� �����
	private static Game instance = new Game();
	private Game() {}
	public static Game getInstance() {return instance;}
	
	private Hero pl;
	private ArrayList<Unit> enemy = new ArrayList<>();
	private ArrayList<TreasureBox> box = new ArrayList<>();

	private void init() {
		pl = new Hero("���", 100, 100, 5, 1, 1);
		box.add(new TreasureBox("����", 20, 3));
		enemy.add(new Zombie("����1", 25, 25, 5, 1, 4));
		box.add(new TreasureBox("��", 0, 20, 6));
		enemy.add(new Zombie("����2", 40, 40, 5, 1, 7));
		box.add(new TreasureBox("����", 20, 8));
		enemy.add(new Zombie("����3", 55, 55, 5, 1, 10));
		box.add(new TreasureBox("����", 20, 0, 13));
		enemy.add(new Zombie("����4", 70, 70, 5, 1, 15));
		box.add(new TreasureBox("����", 20, 16));
		box.add(new TreasureBox("����", 50, 18));
		box.add(new TreasureBox("����", 50, 19));
		enemy.add(new ZombieKing("����", 90, 90, 5, 1, 20, 50));
	}
	
	private int check() {
		for(int i=0;i<enemy.size();i++) { // ���� �߰�
			if(pl.getPos() == enemy.get(i).getPos()) {
				System.out.println("���� ����!");
				return 1;
			}
		}
		for(int j=0;j<box.size();j++) { // �������� �߰�
			if(pl.getPos()==box.get(j).getPos()) {
				System.out.println("�������� �߰�!!");
				return 2;
			}
		}
		return -1;
	}
	
	private int die(Unit unit) {return 0;}
	private boolean openBox() {return false;}
	private boolean fight(Unit enemy) {return false;}
	
	private void map(int f) {
		System.out.println("NOW : "+ pl.getPos()+"��");
		System.out.print("1.�ö󰣴�. ");
		if(f==1) {
			System.out.print("2.ü��ȸ�� 3.���Ⱝȭ\n");
		}
	}
	
	public void run() {
		System.out.println("[Zombie Tower...]");
		init();
		int act = 1;
		while(true) {
			if(pl.getPos()>20) {
				System.out.println("ž�� �����ߴ�!");
				break;
			}
			
			map(act);
		}
	}
}
