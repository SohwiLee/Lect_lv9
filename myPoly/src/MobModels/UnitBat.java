package MobModels;

import Models.Unit;

public class UnitBat extends Unit { // state�߰�?
	UnitBat(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "����";
	}

	void skill() {
		System.out.println("������ ħ�� ȿ���� �ο��Ѵ�. ���� Ȯ�������� 1�� ��ų�� ����� �� ����.");
	}
}
