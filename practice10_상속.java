package practice;



class MyPerson{
	private String name;
	private int age;
	private double height;
	
	public MyPerson() {
		System.out.println("MyPerson����Ʈ ������ ȣ��");
		name="����Ʈ";
		age = 20;
		height=182.5;
	}
	public MyPerson(String name,int age, double height) {
		System.out.println("MyPerson�� String ,int, double ������ ȣ��");
		this.name=name;
		this.age=age;
		this.height=height;}
	
	public void Introduce() {
		System.out.printf("�̸�:%s\n",name);
		System.out.printf("����:%d\n",age);
		System.out.printf("Ű :%.1f\n",height);
	}
}
class MyEmployee extends MyPerson{
	
	private int salary;
	private String position;
	
	public MyEmployee() {
		super(); //�θ��� ����Ʈ ������ ȣ��
		System.out.println("MyEmployee ����Ʈ ������ ȣ��~");
		salary=300;
		position="���";}
	
	public MyEmployee(String name, int age, double height,int salary, String position) 
	{
		super(name,age,height);
		System.out.println("MyEmployee String,int,double,int,Sting ������ ȣ��");
		this.salary=salary;
		this.position=position;}
	
	public void Introduce() {
		super.Introduce();
		System.out.printf("����:%d\n",salary);
		System.out.printf("����:%s\n",position);
	}
	}



public class practice10_��� {

	public static void  main(String[] args) {
		
		MyEmployee emp = new MyEmployee("��ȣ��",20,185.2,6000,"�븮");
		emp.Introduce();
	}

}
