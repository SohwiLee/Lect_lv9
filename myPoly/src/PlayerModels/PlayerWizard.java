package PlayerModels;

import Models.Unit;

public class PlayerWizard extends Unit {

	PlayerWizard(String name, int max, int pow) {
		super(name, max, pow);
		name = "������";
	}

	void Skill() {
		System.out.println("[���׿�] - �� ��ü����, 1.2���� ������ �ο�");
	}

}
