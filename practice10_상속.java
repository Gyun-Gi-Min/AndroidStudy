package practice;



class MyPerson{
	private String name;
	private int age;
	private double height;
	
	public MyPerson() {
		System.out.println("MyPerson디폴트 생성자 호출");
		name="디폴트";
		age = 20;
		height=182.5;
	}
	public MyPerson(String name,int age, double height) {
		System.out.println("MyPerson의 String ,int, double 생성자 호출");
		this.name=name;
		this.age=age;
		this.height=height;}
	
	public void Introduce() {
		System.out.printf("이름:%s\n",name);
		System.out.printf("나이:%d\n",age);
		System.out.printf("키 :%.1f\n",height);
	}
}
class MyEmployee extends MyPerson{
	
	private int salary;
	private String position;
	
	public MyEmployee() {
		super(); //부모의 디폴트 생성자 호출
		System.out.println("MyEmployee 디폴트 생성자 호출~");
		salary=300;
		position="사원";}
	
	public MyEmployee(String name, int age, double height,int salary, String position) 
	{
		super(name,age,height);
		System.out.println("MyEmployee String,int,double,int,Sting 생성자 호출");
		this.salary=salary;
		this.position=position;}
	
	public void Introduce() {
		super.Introduce();
		System.out.printf("연봉:%d\n",salary);
		System.out.printf("직급:%s\n",position);
	}
	}



public class practice10_상속 {

	public static void  main(String[] args) {
		
		MyEmployee emp = new MyEmployee("민호씨",20,185.2,6000,"대리");
		emp.Introduce();
	}

}
