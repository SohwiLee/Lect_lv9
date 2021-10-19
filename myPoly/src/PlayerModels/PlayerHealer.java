package PlayerModels;

import Models.Unit;

public class PlayerHealer extends Unit {

	PlayerHealer(String name, int max, int pow) {
		super(name, max, pow);
		name="힐러";
	}
	

	void Skill() {
		System.out.println("[치유] 상대방 현재 hp의 20%회복");
	}
}
