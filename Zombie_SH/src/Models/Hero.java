package Models;

public class Hero extends Unit {
	private int cnt = 3; // 최초 물약개수

	public Hero(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
	}

	// getter setter
	public int getCnt() {
		return cnt;
	}
	
	public void drink() {
		if (cnt > 0) {
			System.out.println("체력이 100 회복되었습니다.");
			this.setHp(this.getHp() + 100);
			System.out.println("남은체력 : " + this.getHp());
			cnt--;
		} else {
			System.out.println("물약이 없습니다.");
		}
	}

	public void attack(Unit target) {
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).shield > 0) {
				int damage = (this.getAtt() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
				if (damage <= 0) {
					damage = 1;
				}
				System.out.println(getName() + "의 공격!" + damage + "의 데미지!");

				((ZombieKing) target).setShield(((ZombieKing) target).getShield() - damage); // 실드 부수기
				if (((ZombieKing) target).getShield() <= 0) {
					System.out.println(target.getName() + "의 실드가 박살났다!");
					((ZombieKing) target).setShield(0);
				}

				System.out.println(target.getName() + "의 남은체력 : " + target.getHp() + "(실드:"
						+ ((ZombieKing) target).getShield() + ")");

			} else {
				super.attack(target);
			}
		} else {
			super.attack(target);
		}
	}

}
