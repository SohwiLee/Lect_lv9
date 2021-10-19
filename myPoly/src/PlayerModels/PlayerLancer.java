package PlayerModels;

import Models.Unit;

public class PlayerLancer extends Unit {

	PlayerLancer(String name, int max, int pow) {
		super(name, max, pow);
		name = "창술사";
	}

	void skill() {
		System.out.println("올려찌르기 - 상대방 강타, 1.8배 데미지 부여");
	}
}
