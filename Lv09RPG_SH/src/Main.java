import java.util.Random;
import java.util.Scanner;

class MainGame {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();

	public MainGame() {
		Player player = new Player();
		Shop shop = new Shop();
		FileData fileData = new FileData();

		while (true) {
			System.out.println("=============== [���θ޴�] ================");
			System.out.println("1.������ 2.���� 3.�κ��丮 4.���� 5.�ε� 0.����");
			int sel = scan.nextInt();
			if (sel == 1) {
			} else if (sel == 2) {
			} else if (sel == 3) {
			} else if (sel == 4) {
			} else if (sel == 5) {
			} else if (sel == 0) {
				System.out.println("������ �����մϴ�.");
				break;
			}
		}
		MainGame.scan.close();
	}

}

public class Main {
	public static void main(String[] args) {

		new MainGame();
	}

}
