public class TestString{
	public static void main(String[] args){
		String testArgs="afjsaA2ddfADGINSB214295ALOmlsdroie";		
		
		frequentlyUsedStringMethod(testArgs);				
	}
	
	private static void frequentlyUsedStringMethod(String testStr){
		// date switch
		int number = 2322234;
		String testNum=null;
		System.out.println("Int number(2322234) change to \"String\" is: "+testNum.valueOf(number));
		
		System.out.println("String content is: "+testStr.length());
		System.out.println("String *.length= "+testStr.length());
		System.out.println("String *.toLowerCase: "+testStr.toLowerCase());
		System.out.println("String *.toUpperCase: "+testStr.toUpperCase());
		
		String[] testStrSplit=testStr.split("A");
		System.out.print("String *.split: ");
		for(int i=0;i<testStrSplit.length;i++){
			System.out.print(testStrSplit[i]+", ");
			if(i==(testStrSplit.length-1))
				System.out.println();
		}
		
		// return number for specific character/string 
		int existNumber =testStrSplit.length-1;		System.out.println("Specific character exist number is: "+existNumber);
		// get type case character 
		int lCount=0;
		int	uCount=0;
		int	oCount=0;
		
		for(int i=0;i<testStr.length();i++){
			char charTestStr = testStr.charAt(i);
			if(charTestStr>='a'&&charTestStr<='z'){
				lCount++;
			}
			else{
				if(charTestStr>='A'&&charTestStr<='Z'){
				uCount++;
				}
			else
				oCount++;
			}
		}
		System.out.println("Character Lowe/Upper/Number exist number is: "+lCount+" "+uCount+" "+oCount);
		
		getSpecificStrNumber(testStr,"A");
		
	}
	
	// specificStr: input string
	// findStr: need to find str
	private static void getSpecificStrNumber(String specificStr, String findStr){
		int count =0;
		int index=-1;
				
		while((index=specificStr.indexOf(findStr))!= -1){
			specificStr=specificStr.substring(index+findStr.length());
			//specificStr=specificStr.substring(findStr.length());
			//System.out.println(specificStr);
			count++;
		}
		System.out.println(findStr+" exist number is "+count+" in specificStr string");
		
		
	}
		
}
