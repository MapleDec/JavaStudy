import java.util.*;

public class TestMap{
	public static void main(String[] args){
		Map m1 = new HashMap();
		Map m2 = new TreeMap();
		/* == 
		m1.put("One",new Integer(1));
		m1.put("Two",new Integer(2));
		m1.put("Three",new Integer(3));
		*/
		m1.put("One", 1);
		m1.put("Two", 2);
		m1.put("Three", 3);
		
		m2.put("A",new Integer(1));
		m2.put("B",new Integer(2));
		
		System.out.println("m2 size: "+ m1.size());
		System.out.println(m1.containsKey("One"));
		//System.out.println(m1.containsValue(1));
		System.out.println("m2 size: "+m2.size());
		
		if(m1.containsKey("Two")){
			int i =((Integer)m1.get("Two")).intValue();
			// int i =(Integer) m1.get("Two")
			System.out.println(i);
		}
		
		Map m3 = new HashMap(m1);
		m3.putAll(m2);
		System.out.println(m3);
	}
}
