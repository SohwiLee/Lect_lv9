package PlayerModels;

public class PlayerLancer extends Player {

	PlayerLancer(String name, int max, int pow, String state) {
		super(name, max, pow, state);
		name = "창술사";
	}

	void skill() {
		System.out.println("올려찌르기 - 상대방 강타, 1.8배 데미지 부여");
	}
}
