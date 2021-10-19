package Models;

public class Player extends Unit {
	public Player(String name, int maxhp, int power) {
		super(name, maxhp, power);
	}

	public void skill(Unit target) {
		if (super.name.equals("����")) {
			System.out.println("[���� ������] - ���ϴ�� ���ݷ��� 1.5�� ����");
			WarriorSkill(target);
		} else if (super.name.equals("������")) {
			System.out.println("[���׿�] - ��ü����, �� ��ü���� ���ݷ� ������ �������� ������.");
			WizardSkill(target);
		} else if (super.name.equals("����")) {
			System.out.println("[ġ��] - �Ʊ� �� ���� ���� ü���� 20% ȸ��");
			HealerSkill(target);
		}

	}

	public void WarriorSkill(Unit target) {
		target.curhp -= (this.power * 1.5);
		System.out.println(name + " >> " + target.name + " ����! >> " + power * 1.5 + "�� �������� ������!");
		printInfo(target);
	}

	public void WizardSkill(Unit target) {
		target.curhp -= (this.power / 2);
		System.out.println(name + " >> " + target.name + " ����! >> " + power * 0.5 + "�� �������� ������!");
		printInfo(target);
	}

	public void HealerSkill(Unit target) {
		int originHp = target.curhp;
		if (target.curhp < target.maxhp) {
			if (target.curhp >= target.maxhp) {
				target.curhp = target.maxhp;
			} else {
				target.curhp += (target.curhp * 0.2);
			}
		}
		System.out.println(name + " >> " + target.name + " ġ�� >> " + originHp * 0.2 + "�� ü���� ȸ�����״�!");
		printInfo(target);
	}

	public void printInfo(Unit target) {
		if (target.curhp <= 0) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.out.println(target.name + " óġ �Ϸ�!");
			target.curhp = 0;
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
}
