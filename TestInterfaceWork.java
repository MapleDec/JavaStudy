public class TestInterfaceWork{
	public static void main(String[] args)
	{
		Pet stone = new Worker("FeiYa");
		stone.petType();
		//stone.eatFood();
		//stone.playToy();
		
		CareForPet leaf = new Peasant("DaHuang");		
		leaf.eatFood();
		leaf.playToy();

		Peasant tian = new Peasant("Tian");
		tian.petType();
		tian.eatFood();
		tian.playToy();
		tian.homeArea();
	}
}
interface Pet{
	void petType();
}

interface CareForPet{
	void eatFood();
	void playToy();
} 

abstract class Huam{
	public abstract void f();
	
}

class Worker extends Huam implements Pet,CareForPet{	
	private String nameWork;
	
	Worker(String nameWorker){
		this.nameWork=nameWorker;
	}
	public void f(){}
	
	public void petType(){
		System.out.println("Worker take care JinMao");
	}
		
	public void eatFood(){
		System.out.println("give sausage as food.");
	}
		
	public void playToy(){
		System.out.println("Worker play ball with their pet.");
	}
}

class Peasant extends Huam implements Pet,CareForPet{
	public String namePeasantnt;
	
	Peasant(String namePeasantnt){
		this.namePeasantnt=namePeasantnt;
	}
	public void f(){}
	
	public void petType(){
		System.out.println("Peasant take care Black dog.");
	}
		
	public void eatFood(){
		System.out.println("Peasant give rice as food.");
	}
		
	public void playToy(){
		System.out.println("Peasant play leaf with their pet.");
	}
	
	public void homeArea(){
		System.out.println("Pet live in hometown.");
	}
}
