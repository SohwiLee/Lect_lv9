package MobModel;

import Models.Unit;

public class UnitWolf extends Unit{
	UnitWolf(String name, int max, int pow){
		super(name, max, pow);
		name = "����";
	}
	
	void skill() {
		System.out.println("�� ��ü���� ���ݷ� ������ �������� ������.");
	}

}
