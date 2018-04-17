import java.util.*;

public class TestCollection{
	public static void main(String[] args){
		// Collection cTest01 = new ArrayList();
		Collection cTest01 = new HashSet();
		cTest01.add("Maple");
		cTest01.add(new Name("Yang","24"));
		cTest01.add(new Integer(124));
		cTest01.add(new Integer(125));
		System.out.println("All object: "+cTest01);
		// 125 will be remove
		cTest01.remove(new Integer(125));
		// above Name object is not equality with this object			
		System.out.println("remove Yang 124: "+cTest01.remove(new Name("Yang","24")));
		System.out.println(cTest01.size());
		System.out.println(cTest01);
		
		// enhance for usage
		Collection cTest02 = new ArrayList();
		cTest02.add("I ");
		cTest02.add("Love ");
		cTest02.add("You.");
		System.out.println("enhance for usage output: ");
		for(Object o :cTest02){
			System.out.print(o+" ");
		}
		
		// achieve Comparable interface
		List sTestList = new LinkedList();
		sTestList.add(new Name("Maple","Yang"));
		sTestList.add(new Name("WenBo","Mu"));
		sTestList.add(new Name("Jiawei","Wu"));
		System.out.println("Default sort is: "+sTestList);
		Collections.sort(sTestList);
		System.out.println("After sort by use compare interface is: "+sTestList);
		 
	}
}

class Name implements Comparable{
	private String fName,lName;
	public Name(String fName,String lName){
		this.fName=fName;
		this.lName=lName;
	}
	
	public String getFName(String fName){ return fName;}
	public String getLName(String lName){ return lName;}
	
	public String toString(){return fName+" "+lName;}
	// overwrite equals method
	public boolean equals(Object obj){
		if(obj instanceof Name){
			Name name = (Name) obj;
			return (fName.equals(name.fName)&&lName.equals(name.lName));
		}
		else
		return super.equals(obj);		
	}
	
	public int hashCode(){ return fName.hashCode();}
	
	// overwrite compare interface
	public int compareTo(Object o){
		Name n = (Name)o;
		int lastCmp = lName.compareTo(n.lName);
		return (lastCmp!=0 ? lastCmp:fName.compareTo(n.fName));
	}
}
