package PlayerModels;

public class PlayerHealer extends Player {

	PlayerHealer(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name="����";
	}
	

	void Skill() {
		System.out.println("[ġ��] ���� ���� hp�� 20%ȸ��");
	}
}
