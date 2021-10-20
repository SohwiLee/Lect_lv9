package Models;

import java.util.Random;

public abstract class Unit {
	String name;
	int hp;
	int maxHp;
	int attack;
	int defence;
	int position;

	Unit(String name, int hp, int att, int def, int pos) {
		this.name = name;
		this.hp = hp;
		this.maxHp = hp;
		this.attack = att;
		this.defence = def;
		this.position = pos;
	}

	public String getName() {return this.name;}
	public int getHp() {return this.hp;}
	public int getMax() {return this.maxHp;}
	public int getAtt() {return this.attack;}
	public int getDef() {return this.defence;}
	public int getPos() {return this.position;}
	public void setHp(int hp) {this.hp = hp;}
	public void setAtt(int att) {this.attack = att;}
	public void setDef(int def) {this.attack = def;}
	public void setPos(int pos) {this.position = pos;}
	
	public void printInfo() {
		System.out.println("[" + this.name + "] hp:" + this.hp + " att:" + this.attack + " def:" + this.defence);
	}

	public void attack(Unit target) {
		Random ran = new Random();
		int damage = (this.attack - target.defence) * ((ran.nextInt(200) + 100) / 100);
		if (damage <= 0) {
			damage = 1;
		}
		System.out.println(this.name + " Attack!!! >> " + target.name + "는 " + damage + "의 데미지를 입었다.");
		target.setHp(target.getHp() - damage);
		if (target.getHp() <= 0) {
			System.out.println(target.name + " 남은체력::" + 0);
			System.out.println(target.name + "가(이) 쓰러졌다!");
		} else {
			System.out.println(target.name + " 남은체력::" + target.getHp());
		}
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
