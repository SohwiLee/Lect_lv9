package Models;

public class Unit {

	public int curhp;
	int maxhp;
	int power;
	public String name;
	String state = "�̻����";

	Unit() {};

	Unit(String name, int maxhp, int power) {
		this.name = name;
		this.maxhp = maxhp;
		this.curhp = maxhp;
		this.power = power;
	}

	public void init(int maxhp, int power) {
		this.maxhp = maxhp;
		this.curhp = maxhp;
		this.power = power;
	}

	public void init(String name, int maxhp, int power) {
		this.name = name;
		this.maxhp = maxhp;
		this.curhp = maxhp;
		this.power = power;
	}
	
	public void attack(Unit target) {
		target.curhp -= power;
		System.out.println(name+" >> "+ target.name +" ����! >> "+ power+"�� �������� ������!");
		if(target.curhp<=0) {
			System.out.println(target.name+ " óġ �Ϸ�!");
			target.curhp=0;
		}
	}
	
	public void printData() {
		System.out.println("["+name+"] HP:"+ curhp+"/"+maxhp+" Pow:"+power);
	}

}
