package Models;

import java.util.Random;

public abstract class Unit {
	Random ran = new Random();
	private String name;
	private int hp;
	private int max;	
	private int att;
	private int def;
	private int pos;
	
	// ������
	Unit(String name, int hp, int max, int att, int def, int pos){
		this.name = name;
		this.hp = hp;
		this.max = max;
		this.att = att;
		this.def = def;
		this.pos = pos;
	}
	
	// getter setter
	public String getName() {return this.name;}
		
	public int getHp() {return this.hp;}
	public void setHp(int hp) {this.hp = hp;}
		
	public int getAtt() {return this.att;}
	public void setAtt(int att) {this.att = att;}
		
	public int getDef() {return this.def;}
	public void setDef(int def) {this.def = def;}
		
	public int getPos() {return this.pos;}
	public void setPos(int pos) {this.pos = pos;}

	public void print() {
		System.out.print("[�̸�] : "+name+"    [ü��] : "+hp);
		System.out.println(" [���ݷ�] : "+att+"  [����] : "+def+"  [��ġ] : "+pos+"��");
	}
	
	public void attack(Unit target) {
		int damage = (this.att - target.def)*(ran.nextInt(150)+50)/100;
		if(damage <=0) {damage=-1;}
		System.out.println(name+"�� ���� >> "+damage+"������!");
		target.setHp(target.getHp() - damage);
		if(target.getHp()<=0) {			
			System.out.println(target.name + " ����ü�� >> "+0);
		}else {			
			System.out.println(target.name + " ����ü�� : "+target.getHp());
		}
	}
		
}
