package PlayerModels;

import Models.Unit;

public class PlayerWarroir extends Unit {

	PlayerWarroir(String name, int max, int pow) {
		super(name, max, pow);
		name = "����";
	}

	void skill() {
		System.out.println("[����������] �� ��ü����, 20%Ȯ���� 1�� ����ȿ�� �ο�");
	}

}
