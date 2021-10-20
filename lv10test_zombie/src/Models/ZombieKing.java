package Models;

public class ZombieKing extends Unit{

	int shield;
	ZombieKing(String name, int hp, int att, int def, int pos, int shield) {
		super(name, hp, att, def, pos);
		this.shield = shield;
		// TODO Auto-generated constructor stub
	}
	
	public int getShield() {return this.shield;}
	public void setShield(int shield) {this.shield=shield;}

}
