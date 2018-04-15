public class TestStringBuffer{
	public static void main(String[] args){
		String s1 = "I miss u.";
		String s2 ="Will you not connect me if i don't find you?";
		String s = null;
		s=s1+s2;
		System.out.println(s);
		
		//File file = new File();
		
		String strTest="12,4;43,2,55;54;2,78";		
		String[] sFir=strTest.split(";");
		for(int i1 =0;i1<sFir.length;i1++){
			String[] sSec = sFir[i1].split(",");
			for(int j = 0;j<sSec.length;j++){
				System.out.println(sSec[j]);
		} }
		
		
		//
		StringBuffer ssStr = new StringBuffer(s);
		ssStr.append('/').append("Xiao");
		System.out.println(ssStr);
		for(int i=0;i<10;i++){
			ssStr.append(i);			
		}
		
		ssStr.delete(7,12);
		ssStr.insert(0,"aa");
		System.out.println(ssStr);
		
		//data package
		Integer i2 = new Integer(123);
		Double d = new Double("43.1232");
				
		int j=i2.intValue()+d.intValue();
		float f =i2.floatValue()+d.floatValue();
		
		double pi = Double.parseDouble("3.1415926");
		double r = Double.valueOf("2.0").doubleValue();
		double ssa = pi*r*r;
		
		System.out.println(j);
		System.out.println(f);
		System.out.println(i2+"  "+d);
		System.out.println(ssa);
		
		System.out.println(Integer.toHexString(123)+"H");
		System.out.println(Integer.toBinaryString(123)+"B");
		
	}	 
}
