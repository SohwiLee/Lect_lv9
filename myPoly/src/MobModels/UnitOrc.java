package MobModel;

import Models.Unit;

public class UnitOrc extends Unit {
	UnitOrc(String name, int max, int pow) {
		super(name, max, pow);
		name = "��ũ";
	}
	
	void skill() {
		System.out.println("�� �� ���� 2���� �������� ������ 40% Ȯ���� 1�� ������Ų��.");
	}
}
