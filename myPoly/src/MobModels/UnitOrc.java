package MobModels;

import Models.Unit;

public class UnitOrc extends Unit {
	UnitOrc(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "��ũ";
	}
	
	void skill() {
		System.out.println("�� �� ���� 2���� �������� ������ 40% Ȯ���� 1�� ������Ų��.");
	}
}
