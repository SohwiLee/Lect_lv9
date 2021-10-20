package MobModels;

import Models.Unit;

public class UnitWolf extends Unit{
	UnitWolf(String name, int max, int pow, String state){
		super(name, max, pow, state);
		name = "늑대";
	}
	
	void skill() {
		System.out.println("적 전체에게 공격력 절반의 데미지를 입힌다.");
	}

}
