package PlayerModels;

public class PlayerWizard extends Player {

	PlayerWizard(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "������";
	}

	void Skill() {
		System.out.println("[���׿�] - �� ��ü����, 1.2���� ������ �ο�");
	}

}
