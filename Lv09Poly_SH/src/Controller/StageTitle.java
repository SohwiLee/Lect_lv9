package Controller;

import Models.Stage;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("<< Text Rpg >>");
		System.out.println("시작을 원하면 [s]를 입력하세요.");
		String start = GameManager.scan.next();
		if (start.equals("s") || start.equals("ㄴ") || start.equals("S")) {
			GameManager.nextStage = "Lobby";
		}
		return false;
	}

	@Override
	public void init() {

	}

}
