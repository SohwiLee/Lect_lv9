package MobModels;

import Models.Unit;

public class UnitWolf extends Unit{
	UnitWolf(String name, int max, int pow, String state){
		super(name, max, pow, state);
		name = "����";
	}
	
	void skill() {
		System.out.println("�� ��ü���� ���ݷ� ������ �������� ������.");
	}

}
