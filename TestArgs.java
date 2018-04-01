public class TestArgs{
	public static void main(String[] args)throws ArrayIndexOutOfBoundsException{
		System.out.println("This is default caclu");
		//if(args.length<3){
		//System.out.println("Usage: java \"n1\" \"op\"  \"n2\"");
		// exception exist
		//System.exit(-1);
		//}
		if(args.length<3){
			//System.out.println("Usage: java \"n1\" \"op\"  \"n2\"");
		// exception exist
		//System.exit(-1);					
		}
		else{
			if(args.length==3){
				System.out.println("Here will run caclu method.");
				singleCaclu(args);
			}
			else{
				System.out.println("Here input "+args.length+"number.");
				getNumberAndSort(args);
			}		
		}		 
	}
	 
	// single parameters caclu
	public static void singleCaclu(String[] args){
		
		double d1 = Double.parseDouble(args[0]);
		double d2 = Double.parseDouble(args[2]);
		double d=0;
	
		if(args[1].equals("+"))
			d=d1+d2;
		else
		if(args[1].equals("-"))
			d=d1-d2;
		else
			if(args[1].equals("X"))
				d=d1*d2;
			else
				if(args[1].equals("/"))
					d=d1/d2;
				else{
					System.out.println("Error operation");
					System.exit(-1);
				}	 
		System.out.println(d);
	}

	// input more number and sort it
	public static void getNumberAndSort(String[] args){
		int[] a;
		a = new int[args.length];		
		for(int i =0; i<args.length;i++){
			//a[i]=args[i].equals();
			a[i]=Integer.parseInt(args[i]);			 
		}
		 printArray(a);
		 System.out.println();		 
		// sort
		sortIntArray(a);
		// output
		printArray(a);
	}
	
	// sort
	private static void sortIntArray(int [] args){
		int temp =0;
		for(int i=0;i<args.length;i++){
			// note: "j" value should be big than "i"
			for(int j=i+1;j<args.length;j++){
				if(args[i]>args[j]){
					/*temp = args[i];
					args[i]=args[j];
					args[j]=temp;
					*/
					args[i]=args[i]-args[j];
					args[j]=args[i]+args[j];
					args[i]=args[j]-args[i];
				}
			}
		}
	}
	
	// output array by smallest to biggest
	private static void printArray(int[] a){	 
		for(int i =0; i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	}
	
}	