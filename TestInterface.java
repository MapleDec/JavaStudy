public class TestInterface{
	public static void main(String[] args){
		Singer singMing= new Student("Li");
		singMing.sing();
		singMing.sleep();
		
		// this contain Duotai, decide call method according new Object
		Singer singHua= new Teacher("Colorliya");		
		singHua.sing();
		singHua.sleep();
		// due to singHua is Sing (doesn't contain teachPression())
		//singHua.teachPression();
		
		Painter paintYuan = (Painter)singHua;
		paintYuan.paintTools();
		
		Teacher fangYan = new Teacher("fangYan");
		fangYan.teachPression("Math");
		fangYan.paintTools();
		
		f(map);
		 
	}
	
	
}

interface Runner{
	public static final int id = 1;

	public void start();
	public void run();
	public void stop();
}

interface Singer{
	void sing();
	void sleep();
}

interface Painter{
	void paintTools();
}

class Student implements Singer{	
	private String name;
	Student(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void study(){
		System.out.println("Ming is Studying");
	}
	
	public void sing(){
		System.out.println("Ming is sing: when you love me");
	}
	
	public void sleep(){
		System.out.println("Ming go to the bed sleep.");
	}	
}

class Teacher implements Singer,Painter{
	private String name;
	Teacher(String name){
		this.name=name;
	}
	
	public String getTeacherName(){
		return name;
	}
	
	public void sing(){
		System.out.println("Teacher sing: when you love me");
	}
	
	public void sleep(){
		System.out.println("Teacher go to the bed sleep.");
	}
	
	public void paintTools(){
		System.out.println("Teacher is painting beautiful girl by hand.");
	}	
	
	public void teachPression(String prefessionName){
		System.out.println("Teach "+prefessionName+" 2 years.");
	}
	
	void f(Singer s){
		s.sing();
	}
}
