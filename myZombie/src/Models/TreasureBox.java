package Models;

public class TreasureBox {
	private String item;
	private int att;
	private int def;
	private int heal;
	private int pos;
	
	//potion
	 public TreasureBox(String item, int heal, int pos) {
		 this.item=item;
		 this.heal=heal;
		 this.pos=pos;
	 }
	 //arms
	 public TreasureBox(String item, int att, int def, int pos) {
		 this.item=item;
		 this.att=att;
		 this.pos=pos;
	 }
	
	public String getItem() {return this.item;}
	
	public int getAtt() {return this.att;}
	public int getDef() {return this.def;}	
	public int getHeal() {return this.heal;}
	
	public int getPos() {return this.pos;}
	public void setPos(int pos) {this.pos=pos;}

}
