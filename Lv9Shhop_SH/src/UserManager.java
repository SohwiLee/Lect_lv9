import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class UserManager {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	Vector<User> userList = new Vector<>(); // 전체 유저 리스트
	int userLog = -1; // 로그인기본값 -1

	public UserManager() {
//		init();
	}

	public void init() {
		String[] a = { "김", "박", "이", "최", "정", "오" };
		String[] b = { "철", "병", "만", "여", "아", "영" };
		String[] c = { "수", "욱", "수", "정", "름", "희" };
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
			System.out.println("로그인 성공!");
			System.out.println(userList.get(userLog).id + "님 환영합니다!");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		return false;
	}

	public void logout() {
		if (userLog == -1) {
			System.out.println("이미 로그아웃 상태입니다.");
		} else {
			System.out.println("로그아웃 완료");
		}
		userLog = -1;
	}

	public void joinMember() {
		System.out.print("ID:");
		String id = scan.next();
		boolean check=true;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).id.equals(id)) {
				check=false;
			}			
		}
		if(check) {
			User temp = new User(id, 0);
			userList.add(temp);
			System.out.println(temp.id + "님 가입완료되었습니다.");			
		}else {
			System.out.println("이미 존재하는 아이디입니다.");
		}
	}

	public void removeMember() {
		System.out.print("ID:");
		String id = scan.next();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).id.equals(id)) {
				userList.remove(i);
			}
		}
	}
	public void printUser() {
		for (int i = 0; i < userList.size(); i++) {
			userList.get(i).print();
		}
	}
}
