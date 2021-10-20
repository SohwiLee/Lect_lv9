package PlayerModels;

public class PlayerHealer extends Player {

	PlayerHealer(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name="힐러";
	}
	

	void Skill() {
		System.out.println("[치유] 상대방 현재 hp의 20%회복");
	}
}
