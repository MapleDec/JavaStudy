import java.util.*;

public class TestSetInterface{
	public static void main(String[] args){
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
		
	}
}