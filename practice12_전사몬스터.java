package practice;

class Sword{
	private String SwordName;
	private int damage;
	
	public Sword() {
		SwordName="�⺻ Į";
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
		WarriorName="�ɹ�����";
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
		System.out.printf("%s�� %s�� %s�� ����. ������:%d\n!",
				WarriorName,mon.getMonsterName(),getSwordName(),getdamage());
	}
	public void ShowStatus() {
		System.out.printf("������ ����\n");
		System.out.printf("�̸�:%s\n",WarriorName);
		System.out.printf("ü��:%d\n",HP);
	}
}
class Monster{
	private String MonsterName;
	private int HP;
	private int damage;
	
	public Monster() {
		MonsterName="�⺻����";
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
		System.out.printf("%s�� %s�� ����! ������:%d\n",MonsterName,war.getWarriorName(),damage);		
	}
	public void ShowStatus() {
		System.out.printf("���� ����\n");
		System.out.printf("�̸�:%s\n",MonsterName);
		System.out.printf("ü��:%d\n",HP);
	}
	
}


public class practice12_������� {

	public static void main(String[] args) {
		
		Warrior war = new Warrior(); //�ϴ� �⺻���̸�, �����ϰ� ������ (�� �̸�,������,���� �̸�,ü��) �Է�
		Monster mon = new Monster(); //�⺻��, ������ϸ� (�����̸�, ����ü��,������) �Է�
		
		war.ShowStatus();
		mon.ShowStatus();
		war.Attack(mon);
		mon.Attack(war);
		war.ShowStatus();
		mon.ShowStatus();
		

	}

}
