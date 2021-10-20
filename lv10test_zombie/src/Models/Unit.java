package Models;

public abstract class Unit {
	
	String name;
	int hp;
	int maxHp;
	int attack;
	int defence;
	int position;
	
	Unit(String name, int hp, int att, int def, int pos){
		this.name=name; this.hp=hp; this.maxHp=hp; this.attack=att; this.defence=def; this.position=pos;
	}
	
	public String getName() {return this.name;}
	public int getHp() {return this.hp;}
	public int getMax() {return this.maxHp;}
	public int getAtt() {return this.attack;}
	public int getDef() {return this.defence;}
	public int getPos() {return this.position;}
	
	public void setHp(int hp) { this.hp=hp;}
	public void setAtt(int att) {this.attack=att;}
	public void setDef(int def) {this.attack=def;}
	public void setPos(int pos) {this.position=pos;}
	
	public void attack(Unit target) {}
	
}
