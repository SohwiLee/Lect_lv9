package Controller;

import Models.Stage;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("<< Text Rpg >>");
		System.out.println("������ ���ϸ� [s]�� �Է��ϼ���.");
		String start = GameManager.scan.next();
		if (start.equals("s") || start.equals("��") || start.equals("S")) {
			GameManager.nextStage = "Lobby";
		}
		return false;
	}

	@Override
	public void init() {

	}

}
