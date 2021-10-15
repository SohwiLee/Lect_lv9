package Models;

public class Hero extends Unit{
	int cnt = 3; //potion
	
	public Hero(String n, int h, int max, int a, int d, int p) {
		super(n, h, max, a, d, p);
	}
	
	public void drink() {
		if(cnt >0) {}else {
			System.out.println("포션이 없습니다.");
		}
	}
	

}
