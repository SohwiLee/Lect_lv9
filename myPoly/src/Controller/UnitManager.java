package Controller;

import java.util.ArrayList;
import java.util.Random;

import Models.Unit;
import PlayerModels.Player;

public class UnitManager {
	Random ran = new Random();
	final int Party_SIZE = 4;
	ArrayList<Player> player_List = new ArrayList<>();
	ArrayList<Unit> monster_List = new ArrayList<>();
	String mPath = "MobModels.";
	String pPath = "PlayerModels.";
	String[] monsters = { "UnitWolf", "UnitBat", "UnitOrc" };
	String[] players = { "PlayerWarrior", "PlayerLancer", "PlayerWizard", "PlayerHealer" };

	// Player Set
	void playerSet() { 
		for (int i = 0; i < Party_SIZE; i++) {
			try {
				Class<?> clazz = Class.forName(pPath + players[i]);
				Object obj = clazz.newInstance();
				Unit temp = (Unit) obj;
				int hp = 800;
				int pow = 45;
				temp.init(hp, pow);
				player_List.add((Player) temp);
				hp -= 120;
				pow += 15;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Monster Set
	void monsterRandomSet(int size) {
		for (int i = 0; i < size; i++) {
			int rNum = ran.nextInt(monsters.length);
			try {
				Class<?> clazz = Class.forName(mPath + monsters[rNum]);
				Object obj = clazz.newInstance();
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(200) + 100;
				int pow = ran.nextInt(20) + 10;
				temp.init(hp, pow);
				monster_List.add(temp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
