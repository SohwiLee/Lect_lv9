package Controller;

import java.util.Random;
import java.util.Vector;

import Models.Player;
import Models.Unit;

public class UnitManager {
	Random ran = new Random();
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monsterList = new Vector<>();
	String path = "Models."; // �����ʿ�
	String monsters[] = {"Unit_wolf","Unit_orc","Unit_bat"};
	
	UnitManager(){
		playerList.add(new Player("����", 1000, 60));
		playerList.add(new Player("������", 800, 70));
		playerList.add(new Player("����", 500, 45));
	}
	
	void monster_randomSet(int size) {
		for(int i=0;i<size;i++) {
			int num = ran.nextInt(monsters.length);
		}
		
	}
}
