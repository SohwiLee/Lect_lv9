package PlayerModels;

import Models.Unit;

public class PlayerHealer extends Unit {

	PlayerHealer(String name, int max, int pow) {
		super(name, max, pow);
		name="����";
	}
	

	void Skill() {
		System.out.println("[ġ��] ���� ���� hp�� 20%ȸ��");
	}
}
