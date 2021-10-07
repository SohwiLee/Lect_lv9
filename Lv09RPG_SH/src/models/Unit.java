package models;

public class Unit {
	public String name;
	public int level; public int hp; public int maxHp; public int att; public int def; int exp;
	public boolean party; Item weapon; Item armor; Item ring;
	
	public Unit(String n, int l, int h, int a, int d, int e) {
		this.name = n; this.level = l; this.maxHp = h; this.att = a;
		this.def = d; this.exp = e; this.hp = maxHp; this.party=false;
		this.weapon=null; this.armor = null; this.ring=null;
	}
	public Unit(String n, int l, int h, int a, int d, int e, boolean p) {
		this.name = n; this.level = l; this.maxHp = h; this.att = a;
		this.def = d; this.exp = e; this.hp = maxHp; this.party=p;
		this.weapon=null; this.armor = null; this.ring=null;
	}
	
	public void setItem(Item w, Item a, Item r) {
		this.weapon = w; this.armor = a; this.ring = r;
	}

	// 개인의 상태창
	public void printStatus() {
		// 기본정보
		System.out.println("이름 : " + this.name);
		System.out.println("레벨 : " + this.level);
		// 체공방
		if (ring != null) {
			System.out.println("체력 : " + hp + "+" + ring.power);
		} else {
			System.out.println("체력 : " + hp);
		}
		if (ring != null) {
			System.out.println("/" + maxHp + "+" + ring.power);
		} else {
			System.out.println("/" + maxHp);
		}
		if (weapon != null) {
			System.out.println("공격력 : " + att + "+" + weapon.power);
		} else {
			System.out.println("공격력 : " + att);
		}
		if (armor != null) {
			System.out.println("방어력 : " + def + "+" + armor.power);
		} else {
			System.out.println("방어력 : " + def);
		}
		// 파티여부
		System.out.println("파티중 : " + this.party);
	}

	// 장비창
	public void printEquippedItem() {
		if (weapon == null) {
			System.out.println("무기 : 없음");
		} else {
			System.out.println("무기 : " + weapon.name);
		}
		if (armor == null) {
			System.out.println("방어구 : 없음");
		} else {
			System.out.println("방어구 : " + armor.name);
		}
		if (ring == null) {
			System.out.println("장신구 : 없음");
		} else {
			System.out.println("장신구 : " + ring.name);
		}
	}

}
