import java.util.Scanner;

public class Shop {
	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();

	// �⺻ȭ��
	public boolean mainMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.���� 2.Ż�� 3.�α��� 4.�α׾ƿ� / 100.������ 0.����");
			System.out.print("�޴����� : ");
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

	// �α��ν�
	private void loginMenu() {
		boolean run = true;
		while (true) {
			System.out.println("1.���� 2.��ٱ��ϸ�� 3.�ڷΰ���");
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

	// �α���-����
	private void shopMenu() {
		boolean run = true;
		while(run) {
			
		}

	}

	// �α���-��ٱ��ϸ��
	private void cartMenu() {
		// TODO Auto-generated method stub

	}

	// ������ �޴�
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
