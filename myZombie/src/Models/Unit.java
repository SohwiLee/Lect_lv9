package Models;

import Controller.Game;

interface attack{
	void attack(Unit target);
}

public class Unit implements attack{
	private String name;
	private final int MAXHP;
	private int hp;
	private int att;
	private int def;
	private int pos;
	
	public Unit(String n, int h, int max, int a, int d, int p) {
		this.name=n; this.hp=h; this.att=a; this.def=d; this.pos=p; this.MAXHP=max;
	}
	
	// getter setter
	public String getName() {return this.name;}
	
	public int getHp() {return this.hp;}
	public void setHp(int h) {this.hp=h;}
	
	public int getMaxHp() {return this.MAXHP;}
	
	public int getAtt() {return this.att;}
	public void setAtt(int a) {this.att=a;}
	
	public int getDef() {return this.def;}
	public void setDef(int d) {this.def=d;}
	
	public int getPos() {return this.pos;}
	public void setPos(int p) {this.pos=p;}
	
	public void print() {
		System.out.println("<<"+this.name+">> - ["+this.hp+"/"+this.MAXHP+"]");
		System.out.println("공격력["+this.att+"] 방어력[" +this.def+"]");
	}

	@Override
	public void attack(Unit target) {
		int damage = (this.att - target.def)*Game.ran.nextInt(150)+50/100;
		System.out.println("Attack!! > -"+damage+"!!");
		target.setHp(target.getHp()-damage);
		System.out.println("HP:"+target.getHp()+"/"+target.MAXHP);
	}


}
