package PlayerModels;

import Models.Unit;

public class PlayerLancer extends Unit {

	PlayerLancer(String name, int max, int pow) {
		super(name, max, pow);
		name = "â����";
	}

	void skill() {
		System.out.println("�÷���� - ���� ��Ÿ, 1.8�� ������ �ο�");
	}
}
