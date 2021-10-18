package Models;

public class Unit_orc extends Unit{
	Unit_orc(){
		name = "오크";
	}
	
	void skill() {
		System.out.println("집중공격!! [한 명에게 2배의 데미지+기절효과]");
	}
}
