package practice;

class Sword{
	private String SwordName;
	private int damage;
	
	public Sword() {
		SwordName="기본 칼";
		damage=10;
	}
	public Sword(String SwordName,int damage) {
		this.SwordName=SwordName;
		this.damage=damage;
	}
	public String getSwordName() {
		return SwordName;
	}
	public int getdamage() {
		return damage;
	}
	
}

class Warrior extends Sword{
	private String WarriorName;
	private int HP;
	
	public Warrior() {
		super();
		WarriorName="쪼무래기";
		HP=150;
	}
	public Warrior(String SwordName,int damage,String WarriorName,int HP) {
		super(SwordName,damage);
		this.WarriorName=WarriorName;
		this.HP=HP;
	}
	public void setHP(int HP) {
		this.HP=HP;
	}
	
	public String getWarriorName() {
		return WarriorName;
	}
	public int getHP() {
		return HP;
	}
	public void Attack(Monster mon) {
		mon.setHP(mon.getHP()-getdamage());
		System.out.printf("%s가 %s를 %s로 공격. 데미지:%d\n!",
				WarriorName,mon.getMonsterName(),getSwordName(),getdamage());
	}
	public void ShowStatus() {
		System.out.printf("전사의 상태\n");
		System.out.printf("이름:%s\n",WarriorName);
		System.out.printf("체력:%d\n",HP);
	}
}
class Monster{
	private String MonsterName;
	private int HP;
	private int damage;
	
	public Monster() {
		MonsterName="기본몬스터";
		HP=50;
		damage=5;
	}
	public void setHP(int HP) {
		this.HP=HP;
	}
	public int getHP() {
		return HP;
	}
	public String getMonsterName() {
		return MonsterName;
	}
	public void Attack(Warrior war) {
		war.setHP(war.getHP()-damage);
		System.out.printf("%s가 %s를 공격! 데미지:%d\n",MonsterName,war.getWarriorName(),damage);		
	}
	public void ShowStatus() {
		System.out.printf("몬스터 상태\n");
		System.out.printf("이름:%s\n",MonsterName);
		System.out.printf("체력:%d\n",HP);
	}
	
}


public class practice12_전사몬스터 {

	public static void main(String[] args) {
		
		Warrior war = new Warrior(); //일단 기본값이며, 변경하고 싶으면 (검 이름,데미지,전사 이름,체력) 입력
		Monster mon = new Monster(); //기본값, 변경원하면 (몬스터이름, 몬스터체력,데미지) 입력
		
		war.ShowStatus();
		mon.ShowStatus();
		war.Attack(mon);
		mon.Attack(war);
		war.ShowStatus();
		mon.ShowStatus();
		

	}

}
