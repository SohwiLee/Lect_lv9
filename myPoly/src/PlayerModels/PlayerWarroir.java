package PlayerModels;

import Models.Unit;

public class PlayerWarroir extends Unit {

	PlayerWarroir(String name, int max, int pow) {
		super(name, max, pow);
		name = "전사";
	}

	void skill() {
		System.out.println("[도끼던지기] 적 전체공격, 20%확률로 1턴 기절효과 부여");
	}

}
