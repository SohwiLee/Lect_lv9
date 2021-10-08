package controller;

import java.util.ArrayList;

import models.Unit;

public class Guild {

	public ArrayList<Unit> guildList = new ArrayList<>();
	final int PARTY_SIZE = 4;
	Unit[] partyList;

	public void setGuild() {
		Unit temp = new Unit("호랑이", 1, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("강아지", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("사슴", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("두더지", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("돼지", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("사자", 1, 120, 11, 7, 0);
		guildList.add(temp);
		// 순서대로 4명은 자동파티
		for (int i = 0; i < PARTY_SIZE; i++) {
			guildList.get(i).party = true;
		}
		// 파티리스트
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
			System.out.println("1.길드목록 2.길드추가 3.길드원삭제 4.파티원교체 5.정렬 0.뒤로가기");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStatus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 5) {
				sort();
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
		System.out.println("[" + name + "]");
		System.out.println("레벨:" + 1);
		System.out.print("체력:" + hp);
		System.out.println("/" + hp);
		System.out.println("공격력:" + att);
		System.out.println("방어력:" + def);
		System.out.println("길드원을 추가합니다.");
		System.out.println("--------------------------");

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
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.println((i + 1) + ") " + partyList[i].name);
			System.out.print("	레벨 : " + partyList[i].level);
			System.out.print(", 체력 : " + partyList[i].hp);
			System.out.println("/" + partyList[i].maxHp);
			System.out.print("	공격력 : " + partyList[i].att);
			System.out.print(", 방어력 : " + partyList[i].def);
			System.out.println(", 파티 : " + guildList.get(i).party);
		}
		System.out.println("--------------------------");
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

	public void sort() {
		Unit first = guildList.get(0);
		for (int i = 0; i < guildList.size(); i++) {
			for (int j = 0; j < i; j++) {

			}
		}
	}

}
