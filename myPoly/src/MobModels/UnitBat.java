package MobModel;

import Models.Unit;

public class UnitBat extends Unit { // state�߰�?
	UnitBat(String name, int max, int pow) {
		super(name, max, pow);
		name = "����";
	}

	void skill() {
		System.out.println("������ ħ�� ȿ���� �ο��Ѵ�. ���� Ȯ�������� 1�� ��ų�� ����� �� ����.");
	}
}
