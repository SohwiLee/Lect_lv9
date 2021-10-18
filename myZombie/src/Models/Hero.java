package Models;

public class Hero extends Unit{
	private int cnt = 3; // ���� ���ళ��

	public Hero(String name, int hp, int max, int att, int def, int pos) {
		super(name, hp, max, att, def, pos);
	}

	// getter setter
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt=cnt;
	}

	public void drink() {
		if (cnt > 0) {
			System.out.println("ü���� 100 ȸ���Ǿ����ϴ�.");
			this.setHp(this.getHp() + 100);
			System.out.println("����ü�� : " + this.getHp());
			cnt--;
		} else {
			System.out.println("������ �����ϴ�.");
		}
	}

	public void attack(Unit target) {
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).shield > 0) {
				int damage = (this.getAtt() - target.getDef()) * (ran.nextInt(150) + 50) / 100;
				if (damage <= 0) {
					damage = 1;
				}
				System.out.println(getName() + "�� ����!" + damage + "�� ������!");

				((ZombieKing) target).setShield(((ZombieKing) target).getShield() - damage); // �ǵ� �μ���
				if (((ZombieKing) target).getShield() <= 0) {
					System.out.println(target.getName() + "�� �ǵ尡 �ڻ쳵��!");
					((ZombieKing) target).setShield(0);
				}

				System.out.println(target.getName() + "�� ����ü�� : " + target.getHp() + "(�ǵ�:"
						+ ((ZombieKing) target).getShield() + ")");

			} else {
				super.attack(target);
			}
		} else {
			super.attack(target);
		}
	}
}
