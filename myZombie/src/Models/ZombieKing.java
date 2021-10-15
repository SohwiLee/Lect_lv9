package Models;

public class ZombieKing extends Unit{

	int shield; 
	
	public ZombieKing(String n, int h, int max, int a, int d, int p, int shield) {
		super(n, h, max, a, d, p);
		this.shield = shield;
	}
	
	public int getShield() {return this.shield;}
	public void setShield(int shield) {this.shield=shield;}
	

}
