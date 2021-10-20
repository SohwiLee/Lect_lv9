package Controller;

import Models.Stage;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("====== Play RPG ======");
		System.out.println("'s' to start");
		String start = GameManager.scan.next();
		if (start.equals("s") || start.equals("S") || start.equals("¤¤")) {
			GameManager.nextStage = "Lobby";
		}
		return false;
	}

	@Override
	public void init() {

	}

}
