package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Models.Stage;

public class GameManager {
	Random ran = new Random();
	static Scanner scan = new Scanner(System.in);

	static String nextStage = "";
	String curStage = "";

	Map<String, Stage> stageList = new HashMap<String, Stage>();

	GameManager() {
		stageList.put("Title", new StageTitle());
//		stageList.put("Battle", new StageBattle());
		stageList.put("Lobby", new StageLobby());
		nextStage = "Title";
	}

	public boolean changeStage() {
		return false;
	}

}
