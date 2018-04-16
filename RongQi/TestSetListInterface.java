//Collection, set , list == special interface,only exist this package
import java.util.*;
 
public class TestSetListInterface{
	public static void main(String[] args){
		System.out.println("-----------This is set interface usage:");
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		
		s1.add("Xian");
		s1.add("27");
		s1.add("fire");
		s1.add("27");
		System.out.println("Here should has one 27: "+s1);
		s2.add("27");
		s2.add("Xian");
		s2.add("hoo");
		
		Set su = new HashSet(s1);
		su.retainAll(s2);
		
		Set sn = new HashSet(s2);
		sn.addAll(s1);
		
		System.out.println("Jiao ji: "+su);
		System.out.println("Bing ji: "+sn);
		System.out.println("-----------This is List interface usage:");
		setInterfaceTest();
		
	}
	
	public static void setInterfaceTest(){
		// LinkedList interface
		List se1=new LinkedList();
		for(int i = 0 ; i<9;i++){
			se1.add("a"+i);
		}
		System.out.println("Initial list is: "+se1);
		se1.set(2,"Maple") ;
		se1.remove(8);
		se1.add(7,"Yang");
		System.out.println("After modified list is: "+se1);		 
		System.out.println("get 2nd element is: "+(String)se1.get(2));
		System.out.println("get a5 place is: "+se1.indexOf("a5"));
		
		// Collections class usage
		Collections.shuffle(se1);
		System.out.println("Random sort is: "+se1);
		Collections.reverse(se1);
		System.out.println("Reverse sort is: "+se1);
		Collections.sort(se1);
		System.out.println("Normal sort is: "+se1);
		System.out.println(Collections.binarySearch(se1,"a4"));
	}
}

