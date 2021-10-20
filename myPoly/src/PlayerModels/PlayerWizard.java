package PlayerModels;

public class PlayerWizard extends Player {

	PlayerWizard(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "마법사";
	}

	void Skill() {
		System.out.println("[메테오] - 적 전체공격, 1.2배의 데미지 부여");
	}

}
