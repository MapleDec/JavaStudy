/*test instanceof, equals,*/

public class TestEquals{
	public static void main(String[] args){
		BlackDog xiaoHei = new BlackDog("Move","BlueBlack",2);		
		OrangeCat jiaFei = new OrangeCat("Move","orange",3);		
		System.out.println(xiaoHei instanceof Animal);
		System.out.println(jiaFei instanceof Animal);
		
		OrangeCat feiBo = new OrangeCat("FeiBo","yellow",4);
		OrangeCat feiBo1 = new OrangeCat("FeiBo1","yellow",4);		
		System.out.println(feiBo1.equals(feiBo));
		 
	}	
}	

class Animal{
	public String flageAnimal="CanMove";	
	Animal(String _flageAnimal){
	 this.flageAnimal=_flageAnimal;
	}	
}	

class BlackDog extends Animal{
	private String dogHairColor;
	private int dogAgeLive;
	
	BlackDog(String _flageAnimal,String hairColor,int ageLive){
		super(_flageAnimal);
		this.dogHairColor=hairColor;
		this.dogAgeLive=ageLive;
		System.out.println("There generated a black dog.");
	}		
}

class OrangeCat extends Animal{
	private String catHairColor;
	private int catAgeLive;
	
	OrangeCat(String _flageAnimal,String hairColor, int ageLive){
		super(_flageAnimal);
		this.catHairColor = hairColor;
		this.catAgeLive= ageLive;	
		System.out.println("There generated a Orange Cat.");		
	}	
	
	public boolean equals(Object obj){
		if(obj ==null) return false;
		else{
			if(obj instanceof OrangeCat){
				OrangeCat c = (OrangeCat)obj;
			if(c.flageAnimal==this.flageAnimal&&c.catHairColor==this.catHairColor&&c.catAgeLive==this.catAgeLive)
				return true;
			}
		}
		return false;		
	}
}