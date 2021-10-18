package Models;

public class ZombieKing extends Unit{
	int shield;

	public ZombieKing(String name, int hp, int max, int att, int def, int pos, int shield) {
		super(name, hp, max, att, def, pos);
		this.shield = shield;
	}
	
	// getter setter
	public int getShield() {return shield;}
	public void setShield(int shield) {this.shield = shield;}

}
