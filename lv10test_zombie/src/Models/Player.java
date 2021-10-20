package Models;

public class Player extends Unit {
	
	int poCnt = 0;
	int armCnt = 0;

	public Player(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
		// TODO Auto-generated constructor stub
	}
	
	public int getPoCnt() {return poCnt;}
	public void setPoCnt(int cnt) {this.poCnt=cnt;}
	public int getArmCnt() {return armCnt;}
	public void setArmCnt(int cnt) {this.armCnt=cnt;}
	
	public void drink() {}

}
