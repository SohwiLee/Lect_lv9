package controller;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.User;

public class UserManager {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	public Vector<User> userList = new Vector<>(); // ��ü ���� ����Ʈ
	public int userLog = -1; // �α��α⺻�� -1

	public UserManager() {
//		init();
	}

	public User getUser(int idx) {
		return this.userList.get(idx);
	}

	public void init() {
		String[] a = { "��", "��", "��", "��", "��", "��" };
		String[] b = { "ö", "��", "��", "��", "��", "��" };
		String[] c = { "��", "��", "��", "��", "��", "��" };
		for (int i = 0; i < 10; i++) {
			int r = ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r = ran.nextInt(c.length);
			name += c[r];
			User temp = new User(name, ran.nextInt(5000));
			userList.add(temp);
		}
	}

	public boolean login() {
		userLog = -1;
		System.out.print("ID:");
		String id = scan.next();
		for (int i = 0; i < userList.size(); i++) {
			if (id.equals(userList.get(i).id)) {
				userLog = i;
				break;
			}
		}
		if (userLog != -1) {
			System.out.println("�α��� ����!");
			System.out.println(userList.get(userLog).id + "�� ȯ���մϴ�!");
			return true;
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
			return false;
		}
	}

	public void logout() {
		if (userLog == -1) {
			System.out.println("�̹� �α׾ƿ� �����Դϴ�.");
		} else {
			System.out.println("�α׾ƿ� �Ϸ�");
		}
		userLog = -1;
	}

	public void joinMember() {
		System.out.print("ID:");
		String id = scan.next();
		boolean check = true;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).id.equals(id)) {
				check = false;
			}
		}
		if (check) {
			User temp = new User(id, 0);
			userList.add(temp);
			System.out.println(temp.id + "�� ���ԿϷ�Ǿ����ϴ�.");
		} else {
			System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
		}
	}

	public void removeMember() {
		printUser();
		System.out.print("ID:");
		String id = scan.next();
		boolean check = true;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).id.equals(id)) {
				check = false;
				userList.remove(i);
				System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
			}
		}
		if (check) {
			System.out.println("���� ���̵��Դϴ�.");
		}
	}

	public void printUser() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.print((i + 1) + ") ");
			userList.get(i).print();
		}
	}
}