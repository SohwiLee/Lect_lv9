
public class Item {
	String name;
	int price;
	String category;

	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public void print() {
		System.out.println(name+ "	" + price + "	" + category);
	}

}
