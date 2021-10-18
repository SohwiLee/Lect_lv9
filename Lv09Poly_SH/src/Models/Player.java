package Models;

public class Player extends Unit{
	public Player(String name, int maxhp, int power){
		super(name, maxhp, power);
	}
	
	public void skill() {
		if(super.name.equals("전사")) {
			System.out.println("전사스킬");
		} else if(super.name.equals("마법사")) {
			System.out.println("마법사스킬");
		} else if(super.name.equals("힐러")) {
			System.out.println("힐러스킬");			
		}
		
	}
}
