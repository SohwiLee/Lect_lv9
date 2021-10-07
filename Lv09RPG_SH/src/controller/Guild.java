package controller;

import java.util.ArrayList;

import models.Unit;

public class Guild {

	public ArrayList<Unit> guildList = new ArrayList<>();
	final int PARTY_SIZE = 4;

	public void setGuild() {
		// TODO Auto-generated method stub

	}

	public void guildMenu() {
		// TODO Auto-generated method stub

	}

	public Unit getGuildUnit(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printAllUnitStatus() {
		System.out.println("GOLD : " + Player.money);
		System.out.println("길드원 >> ");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print((i + 1) + ") ");
			System.out.print(guildList.get(i).name);
			System.out.print(" Lv." + guildList.get(i).level);
			System.out.print(" hp:" + guildList.get(i).hp);
			System.out.print("/" + guildList.get(i).maxHp);
			System.out.print(" 공:" + guildList.get(i).att);
			System.out.print(" 방:" + guildList.get(i).def);
			System.out.print(" 파티여부:" + guildList.get(i).party);
			System.out.println();
		}

	}

	public void printUnitItem(int i) {
		guildList.get(i).printEquippedItem();
	}

	public void printUnitStatus(int i) {
		guildList.get(i).printStatus();

	}

}
