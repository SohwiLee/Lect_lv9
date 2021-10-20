package MobModel;

import Models.Unit;

public class UnitBat extends Unit { // state추가?
	UnitBat(String name, int max, int pow) {
		super(name, max, pow);
		name = "박쥐";
	}

	void skill() {
		System.out.println("적에게 침묵 효과를 부여한다. 상대는 확정적으로 1턴 스킬을 사용할 수 없다.");
	}
}
