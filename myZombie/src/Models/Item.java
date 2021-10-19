package Models;

public class Item {
	private int itemCode;
	private String item;
	private int power;
	private int pos;
	
	//potion
	public Item(int code, String item, int power) {
		this.itemCode=code;
		this.item=item;
		this.power=power;
	}
	 public Item(int code, String item, int power, int pos) {
		 this.itemCode=code;
		 this.item=item;
		 this.power=power;
		 this.pos=pos;
	 }

	public int getCode() {return this.itemCode;}
	public String getItem() {return this.item;}
	
	public int getPower() {return this.power;}
	
	public int getPos() {return this.pos;}
	public void setPos(int pos) {this.pos=pos;}
	
	
}
