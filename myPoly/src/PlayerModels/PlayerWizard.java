package PlayerModels;

import Models.Unit;

public class PlayerWizard extends Unit {

	PlayerWizard(String name, int max, int pow) {
		super(name, max, pow);
		name = "마법사";
	}

	void Skill() {
		System.out.println("[메테오] - 적 전체공격, 1.2배의 데미지 부여");
	}

}
