package controller;

import java.util.Scanner;

import models.User;

public class Shop {
	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();

	// 기본화면
	public void mainMenu() {
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
		while (run) {
			im.printCategory();
			System.out.print("카테고리 번호 (종료:-1) : ");
			String input = scan.next();
			int caIdx = Integer.parseInt(input) - 1;
			if (caIdx == -2) {
				break;
			} else if (caIdx >= 0 && caIdx < im.category.size()) {
				im.printItemList(caIdx);
				System.out.print("아이템 번호 : ");
				input = scan.next();
				int itemIdx = Integer.parseInt(input) - 1;
				// 각각 아이템리스트 크기 구하기
				if (itemIdx >= 0 && itemIdx < im.itemListSize(caIdx)) {
					im.addCart(um.userList.get(um.userLog).id, caIdx, itemIdx);
				} else {
					System.out.println("없는 아이템 번호입니다.");
				}
				// 쇼핑 후 장바구니에 담기
			} else {
				System.out.println("없는 카테고리입니다.");
			}
		}

	}

	// 로그인-장바구니목록
	private void cartMenu() {
		String id = um.getUser(um.userLog).id;
		User getUser = new User(id);
		im.printJang(getUser);
	}

	// 관리자 전체메뉴
	private void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[관리 시스템]");
			System.out.println("1.아이템 2.카테고리 3.장바구니 4.유저 0.뒤로가기");
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

	private void jangMenu() { // ������ ��ٱ��� - ��ü ���⳻��
		im.printJang();
	}

	// 관리자-아이템
	private void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.전체아이템 2.아이템추가 3.아이템삭제 0.뒤로가기");
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

	// 관리자-카테고리
	private void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.전체카테고리 2.카테고리추가 3.카테고리삭제 0.뒤로가기");
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

	// 관리자-유저
	private void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("1.전체유저 2.유저추가 3.유저삭제 0.뒤로가기");
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
