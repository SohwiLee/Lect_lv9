package Models;

public class Hero extends Unit{
	private int cnt = 3; // 최초 물약개수

	public Hero(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
	}
	
	// getter setter
	public int getCnt() {return cnt;}
	
	public void drink() {
		if(cnt>0) {
			System.out.println("체력이 100 회복되었습니다.");
			this.setHp(this.getHp()+100);
			System.out.println("남은체력 : "+this.getHp());
			cnt--;
		}else {
			System.out.println("물약이 없습니다.");
		}
	}
	
	public void attack() {}

}
