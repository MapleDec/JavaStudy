public class TestArray{
	public static void main(String[] args){
	 arraySingle();
		 
	}	
	
public  static void arraySingle(){
		int[] a;
		
		try{
		a = new int[5];
		
		for(int i = 0; i<5;i++){
			a[i]=i;
		}
		 
		Date[] b = {new Date(123,32,12),new Date(212,43,32),new Date(67,1,434)};		 
		 
		System.out.println(b[2]);		
		System.out.println(a[4]);
		// there is a Exception
		//System.out.println(a[6]);
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		  
	}
}

class Date{
	int days;
	int monh;
	int year;
	Date(int yea,int mon, int day)
	{
		year = yea;
		monh=mon;
		days=day;
	}
}
