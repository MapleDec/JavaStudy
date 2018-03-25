abstract class Animal{
	private String name;
	
	Animal(String name){
		this.name=name;
	}
public abstract void enjoy();	
	/*public void enjoy(){ System.out.println("Animal ");}*/
}

class Cat extends Animal{
	private String eysColor;
	
	Cat(String name, String eysColor){
		super(name);
		this.eysColor=eysColor;
		}
	public void enjoy(){ System.out.println("Cat voice miao miao...");}
}

class Dog extends Animal{
	private String hairColor;
	
	Dog(String name,String hairColor){
		super(name);
		this.hairColor=hairColor;
	}
	public void enjoy(){ System.out.println("Dog voice wang wang...");}
}

class Bird extends Animal{

	Bird(){
		super("bird");	 
	}
	public void enjoy(){ System.out.println("Bird voice jiu jiu...");}
}


class PetCommander{
	private String commanderName;
	
	private Animal pet;
	
	PetCommander(String commanderName,Animal pet){
		this.commanderName=commanderName;
		this.pet=pet;
	}
	public void myPetEnjoy(){ pet.enjoy();}
}

public class TestDuoTai{
	public static void main(String args[]){
		Cat maoQiu = new Cat("MaoQiu","blue");
		Dog stone = new Dog("Stone","yellow");
		Bird fei = new Bird();
		PetCommander ming = new PetCommander("Ming",maoQiu);
		PetCommander hua = new PetCommander("Hua",stone);
		PetCommander duJuan = new PetCommander("DuJuan",fei);
		ming.myPetEnjoy();
		hua.myPetEnjoy();
		duJuan.myPetEnjoy();
		
	}
}