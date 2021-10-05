import java.util.Scanner;

public class Shop {
	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();

	// �⺻ȭ��
	public void mainMenu() {
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
		while (run) {
			im.printCategory();
			System.out.print("ī�װ� ��ȣ (����:-1) : ");
			String input = scan.next();
			int categorySel = Integer.parseInt(input);
			if (categorySel == -1) {
				break;
			}
			im.printItemList(categorySel);
			System.out.print("������ ��ȣ : ");
			input = scan.next();
			int itemSel = Integer.parseInt(input);
			// ���� �� ��ٱ��Ͽ� ���
			im.addCart(um.userList.get(um.userLog).id, categorySel, itemSel);
		}

	}

	// �α���-��ٱ��ϸ��
	private void cartMenu() {
		// TODO Auto-generated method stub

	}

	// ������ �޴�
	private void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[���� �ý���]");
			System.out.println("1.������ 2.ī�װ� 3.��ٱ��� 4.���� 0.�ڷΰ���");
			String input = scan.next();
			int sel = Integer.parseInt(input);

			if (sel == 1) {
				itemMenu();
			} else if (sel == 2) {
				categoryMenu();
			} else if (sel == 3) {
			} else if (sel == 4) {
				userMenu();
			} else if (sel == 0) {
				run=false;
			}
		}

	}

	private void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.��ü������ 2.�������߰� 3.�����ۻ��� 0.�ڷΰ���");
			String input = scan.next();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				im.printItemList();
			} else if (sel == 2) {
			} else if (sel == 3) {
			} else if (sel == 4) {
			}
		}

	}

	private void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.��üī�װ� 2.ī�װ��߰� 3.ī�װ����� 0.�ڷΰ���");
			String input = scan.next();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
			} else if (sel == 2) {
				im.printCategory();
			} else if (sel == 3) {
			} else if (sel == 4) {
			}
		}

	}

	private void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.��ü���� 2.�����߰� 3.�������� 0.�ڷΰ���");
			String input = scan.next();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				um.printUser();
			} else if (sel == 2) {
				um.joinMember();
			} else if (sel == 3) {
				um.removeMember();
			} else if (sel == 4) {
				run=false;
			}
		}

	}

}
