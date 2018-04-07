public class TestArray{
	public static void main(String[] args){
	arraySingle();
	arrayDouble();
	
	System.out.println("Below complete array copy function by arraycopy Method:");	
	String[] s = {"Microsoft","Google","Sun","Mi","Huawei"};
	
	for(int i=0;i<s.length;i++){
		System.out.println(s[i]+" ");
		}	
	String[] sBak = new String[s.length];
	// copy ayyay
	System.arraycopy(s,0,sBak,0,s.length);	
	for(int i=0;i<sBak.length;i++){
		System.out.print(sBak[i]+" ");
		}
		
	int[] a =new int[3];
	for(int i=0;i<a.length;i++){
		a[i]=i;
	}
	int[] b;	
	}

	public static void arraySingle(){
		int[] a;
		
		try{
		a = new int[5];		
		for(int i = 0; i<5;i++){
			a[i]=i;
		}
		 
		Date[] b = {new Date(123,32,12),new Date(212,43,32),new Date(67,1,434)};		 
		
		System.out.println(a[4]);
		System.out.println(b[2]);		
		
		// there is a Exception
		//System.out.println(a[6]);		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void arrayDouble(){
		int a[][]=new int[3][3];
		a[0]=new int[3];
		a[1]=new int[3];
		a[2]=new int[3];
		
		int num=1;
		// w
		for(int i = 0; i<a.length;i++){
			for(int j =0;j<a[i].length;j++){
				a[i][j]=num;
				System.out.println("My place is: "+i+","+j);
				num++;
			}
		}
		
		System.out.print("This is double array: ");
		for(int i = 0; i<a.length;i++){
			for(int j =0;j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}
		}
		System.out.println();		 
	}

}
