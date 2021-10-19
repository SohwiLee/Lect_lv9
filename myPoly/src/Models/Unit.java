package Models;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "����";

	Unit() {
	}

	Unit(String name, int max, int pow) {
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = pow;
	}

	void init(int max, int pow) {
		this.maxhp = max;
		this.curhp = max;
		this.power = pow;
	}

	void init(String name, int max, int pow) {
		this.name = name;
		this.maxhp = max;
		this.curhp = max;
		this.power = pow;
	}

	void attack(Unit target) { // �⺻����
		target.curhp -= power;
		System.out.println("[" + this.name + "]" + target.name + "���� " + this.power + "�� �������� ������!");
		if (target.curhp <= 0) {
			target.curhp = 0;
			System.out.println(target.name + "�� ���������ϴ�!");
		}
	}

	void printData() {
		System.out.println("[" + this.name + "] " + this.curhp + "/" + this.maxhp + " pow:" + this.power);
	}

}
