package Models;

public class Player extends Unit{
	public Player(String name, int maxhp, int power){
		super(name, maxhp, power);
	}
	
	public void skill() {
		if(super.name.equals("����")) {
			System.out.println("���罺ų");
		} else if(super.name.equals("������")) {
			System.out.println("�����罺ų");
		} else if(super.name.equals("����")) {
			System.out.println("������ų");			
		}
		
	}
}
