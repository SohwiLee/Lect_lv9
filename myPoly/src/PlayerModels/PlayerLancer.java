package PlayerModels;

public class PlayerLancer extends Player {

	PlayerLancer(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "â����";
	}

	void skill() {
		System.out.println("�÷���� - ���� ��Ÿ, 1.8�� ������ �ο�");
	}
}
