public class TestAccess
{
	public static void main(String args[])
	{	
		ChenShi youFei = new ChenShi("ChenYouFei","women",24);
		youFei.jiaXun();
		//System.out.println(youFei.age);	
		System.out.println("This parameter_"+youFei.sex+" is Public member.");
		
		System.out.println("----------------------------------");
		Airport boeing737 = new Airport();
		boeing737.walkMethod="fly";
		boeing737.zaiKe=300;
		boeing737.selfWeight=32.6f;
		boeing737.weightInfo();
		boeing737.info();	
		
		//test super, overwrite and inherit(s继承)
		// test no parameter constructor
		System.out.println("----------------------------------");
		Child hua = new Child();
		hua.familyName="Hua";
		hua.age=24;
		hua.bornPlace="Hancheng";
		hua.collageSchool="ShuYuan";
		hua.info();
		// test have parameter constructor
		System.out.println("----------------------------------");
		Child ming = new Child("Ming",25,"Ankang","NanFang");
		ming.info();		 
	}
}

// This is ChenShi family
 class ChenShi
{
	private String name;
	public String sex;
	private int age;
	
	public ChenShi(String name,String sex,int age){
		this.name= name;
		this.sex = sex;
		this.age=age;
	}

	public void setName(String name){
		 this.name=name;	
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		 this.age=age;	
	}
	
	public int getAge(){
		return age;
	}
	 
	public void jiaXun(){
		System.out.println("---------------------------");
		System.out.println("This is ChenShi Family");
		System.out.println("The girl name is "+this.name+", this test for Private Access. "+this.sex+" is Public Access.");
		System.out.println();
	}
	
	
}

class Transportation
{
	protected float selfWeight = 0.0f;
	
	public void info(){
		System.out.println("");
	}
	public void weightInfo(){
		System.out.println("The transport tool is "+this.selfWeight+" ton.");
	}	
}

class Airport extends Transportation{
	public String walkMethod;
	public int zaiKe=0;
	 
	public void setZaike(int zaike){
		this.zaiKe=zaiKe;
	}
	public int getZaiKe(){
		return zaiKe;
	}	
	@Override
	public void info(){
		System.out.println("This is Airplane");
	}	
}

class Father{
	public String familyName;
	public int age=0;
	private int value = 0;
	public String bornPlace;

	Father(){
		System.out.println("This call Father constructor.");		
	}
	Father(String _familyName, int _age, String _bornPlace){
		System.out.println("This is Father class Constructor.");
		this.familyName=_familyName;
		this.age=_age;
		this.bornPlace=_bornPlace;		  
	}
	
	public void info(){
		value = 100;
		System.out.println("The guys family name is: "+familyName+", "+age+" years old. "+bornPlace+" is his born-place.");
	}
}

class Child extends Father{
	public String collageSchool;
	private int value =200;
	
	Child(){
		System.out.println("This call Child constructor.");	
	}
	
	Child(String _familyName, int _age, String _bornPlace, String _collageSchool){
		super(_familyName, _age, _bornPlace);
		System.out.println("This is Child class Constructor.");
		this.familyName=_familyName;
		this.age=_age;
		this.bornPlace=_bornPlace;
		this.collageSchool=_collageSchool;		 	 
	}
	
	public void info(){
		//super.info();

		System.out.println(value);
		System.out.println("The guys family name is: "+familyName+", "+age+" years old. "+bornPlace+" is his born-place. He is graduated from "+collageSchool+"school.");
	}	
}
