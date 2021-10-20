package Controller;

import Models.Stage;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("====== Lobby ======");
		System.out.println("1.전투 2.종료");
		int sel = GameManager.scan.nextInt();
		if (sel == 1) {
			GameManager.nextStage="Battle";
		} else if (sel == 2) {
			System.out.println("종료합니다.");
			GameManager.nextStage="";
		} else {
			System.out.println("Wrong Number!");
			GameManager.nextStage="";
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
