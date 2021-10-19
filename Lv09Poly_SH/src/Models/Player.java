package Models;

public class Player extends Unit {
	public Player(String name, int maxhp, int power) {
		super(name, maxhp, power);
	}

	public void skill(Unit target) {
		if (super.name.equals("전사")) {
			System.out.println("[도끼 던지기] - 단일대상 공격력의 1.5배 공격");
			WarriorSkill(target);
		} else if (super.name.equals("마법사")) {
			System.out.println("[메테오] - 전체공격, 적 전체에게 공격력 절반의 데미지를 입힌다.");
			WizardSkill(target);
		} else if (super.name.equals("힐러")) {
			System.out.println("[치유] - 아군 한 명의 남은 체력의 20% 회복");
			HealerSkill(target);
		}

	}

	public void WarriorSkill(Unit target) {
		target.curhp -= (this.power * 1.5);
		System.out.println(name + " >> " + target.name + " 공격! >> " + power * 1.5 + "의 데미지를 입혔다!");
		printInfo(target);
	}

	public void WizardSkill(Unit target) {
		target.curhp -= (this.power / 2);
		System.out.println(name + " >> " + target.name + " 공격! >> " + power * 0.5 + "의 데미지를 입혔다!");
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
		System.out.println(name + " >> " + target.name + " 치유 >> " + originHp * 0.2 + "의 체력을 회복시켰다!");
		printInfo(target);
	}

	public void printInfo(Unit target) {
		if (target.curhp <= 0) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.out.println(target.name + " 처치 완료!");
			target.curhp = 0;
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
}
