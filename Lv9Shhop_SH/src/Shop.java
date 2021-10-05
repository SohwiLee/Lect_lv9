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
			int categorySel = Integer.parseInt(input) - 1;
			if (categorySel == -2) {
				break;
			} else if (categorySel >= 0 && categorySel < im.category.size()) {
				im.printItemList(categorySel);
				System.out.print("������ ��ȣ : ");
				input = scan.next();
				int itemSel = Integer.parseInt(input) - 1;
				// ���� �����۸���Ʈ ũ�� ���ϱ�
				if(itemSel>0 && itemSel < im.itemListSize(categorySel)) {
					im.addCart(um.userList.get(um.userLog).id, categorySel, itemSel);					
				} else {
					System.out.println("���� ������ ��ȣ�Դϴ�.");
				}
				// ���� �� ��ٱ��Ͽ� ���
			} else {
				System.out.println("���� ī�װ��Դϴ�.");
			}
		}

	}

	// �α���-��ٱ��ϸ��
	private void cartMenu() {
		String id = um.getUser(um.userLog).id;
		User getUser = new User(id);
		im.printJang(getUser);
	}

	// ������ ��ü�޴�
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
				jangMenu();
			} else if (sel == 4) {
				userMenu();
			} else if (sel == 0) {
				run = false;
			}
		}

	}

	private void jangMenu() {
		im.printJang();
	}

	// ������-������
	private void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.��ü������ 2.�������߰� 3.�����ۻ��� 0.�ڷΰ���");
			String input = scan.next();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				im.printItemList();
			} else if (sel == 2) {
				im.addItem();
			} else if (sel == 3) {
				im.removeItem();
			} else if (sel == 0) {
				run = false;
			}
		}

	}

	// ������-ī�װ�
	private void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.��üī�װ� 2.ī�װ��߰� 3.ī�װ����� 0.�ڷΰ���");
			String input = scan.next();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				im.printCategory();
			} else if (sel == 2) {
				im.addCategory();
			} else if (sel == 3) {
				im.removeCategory();
			} else if (sel == 0) {
				run = false;
			}
		}

	}

	// ������-����
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
			} else if (sel == 0) {
				run = false;
			}
		}

	}

}
