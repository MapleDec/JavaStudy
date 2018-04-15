public class TestEnum{
	public enum Mcolor{
		red,
		orange,
		yellow,
		green
	}
	
	public static void main(String[] args){
		Mcolor m =Mcolor.red;
		switch(m){
			case red:
				System.out.println("red");
				break;
			case orange:
				System.out.println("orange");
				break;
			case yellow:
				System.out.println("yellow");
				break;
			case green:
				System.out.println("green");
				break;
			default:
				System.out.println("Error imput");
				break;
		}
		System.out.println(m);
	}
}