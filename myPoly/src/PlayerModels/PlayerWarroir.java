package PlayerModels;

public class PlayerWarroir extends Player {

	PlayerWarroir(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "����";
	}

	void skill() {
		System.out.println("[����������] �� ��ü����, 20%Ȯ���� 1�� ����ȿ�� �ο�");
	}

}
