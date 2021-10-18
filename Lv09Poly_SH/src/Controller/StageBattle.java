package Controller;

import java.util.Random;
import java.util.Vector;

import Models.Player;
import Models.Stage;
import Models.Unit;

public class StageBattle extends Stage {
	Random ran = new Random();
	UnitManager unitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monsterList = null;
	int monDead = 0;
	int playerDead = 0;

	@Override
	public void init() {
		unitManager.monsterList.clear();
		unitManager.monster_randomSet(4);
		playerList = null;
		playerList = unitManager.playerList;
		monsterList = null;
		monsterList = unitManager.monsterList;
		monDead = monsterList.size();
		playerDead = playerList.size();
	}

	void printCharacter() {
		System.out.println("<< Battle >>");
		System.out.println("<< Player >>");
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("<< Monster >>");
		for (int i = 0; i < monsterList.size(); i++) {
			monsterList.get(i).printData();
		}
	}

	void playerAttack(int index) {
		Player p = playerList.get(index);
		if (p.curhp <= 0) return;
		System.out.println("<< 메뉴선택 >>");
		System.out.println("[" + p.name + "]" + "1.어택 2.스킬");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			while (true) {
				int idx = ran.nextInt(monsterList.size()); // 랜덤으로 몬스터 공격
				if (monsterList.get(idx).curhp > 0) {
					p.attack(monsterList.get(idx));
				}
			}
		} else if (sel == 2) {
			int idx = ran.nextInt(monsterList.size()); // 랜덤으로 몬스터 공격
			if (monsterList.get(idx).curhp > 0) {
				p.skill();
			}
		}
	}

	void monsterAttack(int index) {
		Unit m = monsterList.get(index);
		if(m.curhp<=0) return;
		while(true) {
			int idx = ran.nextInt(playerList.size());
			if(playerList.get(idx).curhp>0) {
				m.attack(playerList.get(idx));
				break;
			}
		}
	}
	
	void checkLive() {
		int num = 0; // 죽은인원수
		for(int i=0;i<playerList.size();i++) {
			if(playerList.get(i).curhp<=0) {
				num++;
			}
		}
		playerDead = playerList.size()-num;
		
		num=0;
		for(int i=0;i<monsterList.size();i++) {
			if(monsterList.get(i).curhp<=0) {
				num++;
			}
		}
		monDead = monsterList.size()-num;
	}

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;
		
		while(run) {
			if(turn) {
				printCharacter();
				if(p_index<playerList.size()) {
					playerAttack(p_index);
					p_index++;
				}else {
					turn= !turn;
					p_index = 0;
				}
			}else if(!turn) {
				if(m_index<monsterList.size()) {
					monsterAttack(m_index);
					m_index++;
				}else {
					turn = !turn;
					m_index = 0;
				}
			}
			checkLive();
			if(monDead<=0 || playerDead<=0) {break;}
		}
		GameManager.nextStage = "Lobby";
		return false;
	}
}
