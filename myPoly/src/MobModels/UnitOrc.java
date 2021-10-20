package MobModels;

import Models.Unit;

public class UnitOrc extends Unit {
	UnitOrc(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "오크";
	}
	
	void skill() {
		System.out.println("적 한 명에게 2배의 데미지를 입히며 40% 확률로 1턴 기절시킨다.");
	}
}
