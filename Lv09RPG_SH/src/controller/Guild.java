package controller;

import java.util.ArrayList;

import models.Unit;

public class Guild {

	public ArrayList<Unit> guildList = new ArrayList<>();
	final int PARTY_SIZE = 4;
	Unit[] partyList;

	public void setGuild() {
		Unit temp = new Unit("호랑이", 2, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("강아지", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("사슴", 3, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("두더지", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("돼지", 2, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("사자", 1, 120, 11, 7, 0);
		guildList.add(temp);
		// 순서대로 4명은 자동파티
		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).party = true;
		}
		setPartyList();

	}

	// 파티리스트
	public void setPartyList() {
		partyList = new Unit[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party) {
				partyList[n] = guildList.get(i);
				n++;
			}
		}
	}

	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("1.길드목록 2.길드추가 3.길드원삭제 4.파티조회 5.파티원교체 6.정렬 0.뒤로가기");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStatus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				printParty();
			} else if (sel == 5) {
				partyChange();
			} else if (sel == 6) {
				sorts();
				setPartyList();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}

	public void printAllUnitStatus() {
		System.out.println("GOLD : " + Player.money);
		System.out.println("길드원 >> ");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print((i + 1) + ") ");
			System.out.print(guildList.get(i).name + "	: ");
			System.out.print(" Lv." + guildList.get(i).level);
			System.out.print(", hp:" + guildList.get(i).hp);
			System.out.print("/" + guildList.get(i).maxHp);
			System.out.print(", 공:" + guildList.get(i).att);
			System.out.print(", 방:" + guildList.get(i).def);
			System.out.print(", 파티여부:" + guildList.get(i).party);
			System.out.println();
		}

	}

	public void printUnitItem(int i) {
		guildList.get(i).printEquippedItem();
	}

	public void printUnitStatus(int i) {
		guildList.get(i).printStatus();

	}

	public void buyUnit() {
		if (Player.money < 5000) {
			return;
		}
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];

		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;

		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("--------------------------");
		System.out.print("[" + name + "]");
		System.out.print(", 레벨:" + 1);
		System.out.print(", 체력:" + hp);
		System.out.print("/" + hp);
		System.out.print(", 공격력:" + att);
		System.out.println(", 방어력:" + def);
		System.out.println("길드원을 추가합니다.");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.money -= 5000;
	}

	public void removeUnit() {
		printAllUnitStatus();
		System.out.print("삭제할 번호 : ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).party) {
			System.out.println("파티중인 멤버입니다.");
		} else {
			System.out.println("--------------------------");
			System.out.print(guildList.get(sel - 1).name);
			System.out.println(" 길드원을 삭제합니다.");
			System.out.println("--------------------------");
			guildList.remove(sel - 1);
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	public void printParty() {
		System.out.println("----------[파티원]---------");
		int n = 0;
		for (int i = 0; i < partyList.length; i++) {
			System.out.print((n + 1) + ") " + partyList[i].name+":");
			System.out.print(" 레벨 : " + partyList[i].level);
			System.out.print(", 체력 : " + partyList[i].hp);
			System.out.print("/" + partyList[i].maxHp);
			System.out.print(", 공격력 : " + partyList[i].att);
			System.out.print(", 방어력 : " + partyList[i].def);
			System.out.println(", 파티 : " + partyList[i].party);
			n++;
		}
	}

	public void partyChange() {
		printParty();
		System.out.print("교체할 번호 : ");
		int partyNum = MainGame.scan.nextInt();
		printAllUnitStatus();
		System.out.print("참가할 번호 : ");
		int guildNum = MainGame.scan.nextInt();

		partyList[partyNum - 1].party = false;
		guildList.get(guildNum - 1).party = true;

		System.out.println("--------------------------");
		System.out.println("파티원을 교체합니다.");
		System.out.println(partyList[partyNum - 1].name + " >> " + guildList.get(guildNum - 1).name);
		System.out.println("--------------------------");

		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party) {
				partyList[n] = guildList.get(i);
				n++;
			}
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	public void sorts() {
		System.out.println("1.이름순 2.레벨순 3.hp순 4.공격력순 5.방어력순");
		int sel = MainGame.scan.nextInt();
		if (sel == 1) {
			sortName();
		} else if (sel == 2) {
			sortLevel();
		} else if (sel == 3) {
			sortMaxHp();
		} else if (sel == 4) {
			sortAtt();
		} else if (sel == 5) {
			sortDef();
		}
		System.out.println("정렬 완료");
		printAllUnitStatus();

	}

	// 좀 더 간단하게 만들 수 있을 것 같은데....
	public void sortName() {
		for (int i = 0; i < guildList.size(); i++) {
			Unit first = guildList.get(i);
			int idx = i;
			for (int j = i; j < guildList.size(); j++) {
				if (first.name.compareTo(guildList.get(j).name) > 0) {
					first = guildList.get(j);
					idx = j;
				}
			}

			Unit temp = this.guildList.get(i);
			this.guildList.set(i, guildList.get(idx));
			this.guildList.set(idx, temp);
		}
	}

	public void sortLevel() {
		for (int i = 0; i < guildList.size(); i++) {
			Unit first = guildList.get(i);
			int idx = i;
			for (int j = i; j < guildList.size(); j++) {
				if (first.level > guildList.get(j).level) {
					first = guildList.get(j);
					idx = j;
				} else if (first.level == guildList.get(j).level) {
					System.out.println(i + ", " + j);
				}
			}
			Unit temp = this.guildList.get(i);
			this.guildList.set(i, guildList.get(idx));
			this.guildList.set(idx, temp);
		}
	}

	public void sortMaxHp() {
		for (int i = 0; i < guildList.size(); i++) {
			Unit first = guildList.get(i);
			int idx = i;
			for (int j = i; j < guildList.size(); j++) {
				if (first.maxHp > guildList.get(j).maxHp) {
					first = guildList.get(j);
					idx = j;
				}
			}
			Unit temp = this.guildList.get(i);
			this.guildList.set(i, guildList.get(idx));
			this.guildList.set(idx, temp);
		}
	}

	public void sortAtt() {
		for (int i = 0; i < guildList.size(); i++) {
			Unit first = guildList.get(i);
			int idx = i;
			for (int j = i; j < guildList.size(); j++) {
				if (first.att > guildList.get(j).att) {
					first = guildList.get(j);
					idx = j;
				}
			}
			Unit temp = this.guildList.get(i);
			this.guildList.set(i, guildList.get(idx));
			this.guildList.set(idx, temp);
		}
	}

	public void sortDef() {
		for (int i = 0; i < guildList.size(); i++) {
			Unit first = guildList.get(i);
			int idx = i;
			for (int j = i; j < guildList.size(); j++) {
				if (first.def > guildList.get(j).def) {
					first = guildList.get(j);
					idx = j;
				}
			}
			Unit temp = this.guildList.get(i);
			this.guildList.set(i, guildList.get(idx));
			this.guildList.set(idx, temp);
		}
	}

}
