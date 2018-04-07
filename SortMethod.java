public class SortMethod{
	public static void main(String[] args){
		int[] a = new int[args.length];		
		for(int i =0; i<args.length;i++){
			//a[i]=args[i].equals();
			a[i]=Integer.parseInt(args[i]);			 
		}
		System.out.print("Input array is:");
		for(int i =0; i<args.length;i++){			
			System.out.print(args[i]+" ");		 
			}	
		System.out.println();
		sortSelect(a);
		
	}
	
	private static void sortSelect(int[] args){		
		try{
			for(int i =0;i<args.length-1;i++){
				for(int j=i+1;j<args.length;j++){
					if(args[i]>args[j]){
					args[i]	=args[i]-args[j];
					args[j]=args[i]+args[j];
					args[i]=args[j]-args[i];
					}
				}
			}
			System.out.print("Output select sort array is:");
			for(int i =0; i<args.length;i++){
				System.out.print(args[i]+" ");
			}		
		}
		catch(Exception e){			
			e.getMessage();						
		}
	}
	
	private static void sortMaoPao(String[] args){
		for(int i =0;i<args.length;i++){
			//note
			for(int j=0;j<args.length-1-i;j++){
				if(args[i]>args[j]){
					args[i]	=args[i]-args[j];
					args[j]=args[i]+args[j];
					args[i]=args[j]-args[i];
				}
			}
		}
		System.out.print("Output select sort array is:");
		for(int i =0; i<args.length;i++){
			System.out.print(args[i]+" ");		 
		}	
	}
}

