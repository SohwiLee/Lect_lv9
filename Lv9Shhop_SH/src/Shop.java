import java.util.Scanner;

public class Shop {
	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();

	// 기본화면
	public boolean mainMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.가입 2.탈퇴 3.로그인 4.로그아웃 / 100.관리자 0.종료");
			System.out.print("메뉴선택 : ");
			String input = scan.next();

			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					um.joinMember();
				} else if (sel == 2) {
					um.removeMember();
				} else if (sel == 3) {
					if (um.login()) {
						loginMenu();
					}
				} else if (sel == 4) {
					um.logout();
				} else if (sel == 100) {
					managerMenu();
				} else if (sel == 0) {
					run = false;
				}
			} catch (Exception e) {
			}
		}
		return run;
	}

	// 로그인시
	private void loginMenu() {
		boolean run = true;
		while (true) {
			System.out.println("1.쇼핑 2.장바구니목록 3.뒤로가기");
			String input = scan.next();
			try {
				int sel = Integer.parseInt(input);
				if (sel == 1) {
					shopMenu();
				} else if (sel == 2) {
					cartMenu();
				} else if (sel == 3) {
					break;
				}
			} catch (Exception e) {
			}

		}

	}

	// 로그인-쇼핑
	private void shopMenu() {
		boolean run = true;
		while(run) {
			
		}

	}

	// 로그인-장바구니목록
	private void cartMenu() {
		// TODO Auto-generated method stub

	}

	// 관리자 메뉴
	private void managerMenu() {
		// TODO Auto-generated method stub

	}

	public void run() {
		boolean isRun = true;
		while (isRun) {
			isRun = mainMenu();
		}
	}

}
