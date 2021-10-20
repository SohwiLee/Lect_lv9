package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Models.Stage;

public class GameManager {
	Random ran = new Random();
	static Scanner scan = new Scanner(System.in);
	public static String nextStage;
	public static String curStage;
	Map<String, Stage> stageList = new HashMap<String, Stage>();

	GameManager() {
		stageList.put("Title", new StageTitle());
		stageList.put("Battle", new StageBattle());
		stageList.put("Lobby", new StageLobby());
		nextStage = "Title";
	}

	public boolean changeStage() {
		System.out.println("CUR:" + curStage + "/NEXT:" + nextStage);
		if (curStage.equals(nextStage)) {
			return true;
		}
		curStage = nextStage;

		Stage stage = stageList.get(curStage);
//		stage.init();
		boolean run = true;
		while (true) {
			run = stage.update();
			if (!run) {
				break;
			}
		}

		if (nextStage.equals("")) {
			return false;
		} else {
			return false;
		}

	}
}
