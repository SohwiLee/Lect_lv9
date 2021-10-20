package Controller;

import java.util.ArrayList;
import java.util.Random;

import Models.Stage;
import Models.Unit;
import PlayerModels.Player;

public class StageBattle extends Stage {
	Random ran = new Random();
	UnitManager unitManager = new UnitManager();
	ArrayList<Player> playerList = null;
	ArrayList<Unit> monsterList = null;
	int deadPl = 0;
	int deadMon = 0;

	@Override
	public void init() {
//		unitManager.monster_List.clear();
		unitManager.monsterRandomSet(unitManager.Party_SIZE);
//		playerList = null;
		playerList = unitManager.player_List;
//		monsterList = null;
		monsterList = unitManager.monster_List;
		deadPl = playerList.size();
		deadMon = monsterList.size();
	}
	
	void printCharacter() {
		System.out.println("============= Battle =============");
		System.out.println("<< Player >>");
		for(int i=0;i<playerList.size();i++) {
//			player
		}
		System.out.println("<< Monster >>");
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}


}
