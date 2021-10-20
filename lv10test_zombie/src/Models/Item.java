package Models;

public class Item {
	int code; // 1���� 2���� 3��
	String name;
	int power;
	int position;
	
	public Item(int code, String name, int power, int position) {
		this.code = code; this.name = name; this.power = power; this.position = position;
	}
	public Item(int code, String name, int power) {
		this.code = code; this.name = name; this.power = power;		
	}
	
	public String getName() {return this.name;}
	public int getCode() {return this.code;}
	public int getPow() {return this.power;}
	public int getPos() {return this.position;}

}
