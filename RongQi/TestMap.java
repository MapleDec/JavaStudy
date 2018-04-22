import java.util.*;

public class TestMap{
	
	//public static final Integer ONE = new Integer(1);
	// ==
	public static final int ONE = 1;
	public static void main(String[] args){
		Map m1 = new HashMap();
		// Map<String, Integer> m1 = new HashMap<String,Integer>();
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
		
		// Add test args: count word frequency
		Map m = new HashMap();
		for(int i = 0 ;i<args.length;i++){
			//Integer fre = (Integer)m.get(args[i]);
			// == Auto package and resolve
			int fre = (Integer)m.get(args[i])==null? 0:(Integer)m.get(args[i]);
			
			// give object to m according fre value
			//m.put(args[i],(fre==null? ONE: 	new Integer(fre.intValue()+1)));
			// ==
			m.put(args[i],(fre==0 ? ONE:fre+1));
		}
		System.out.println("distinct word detected: "+ m.size());
		System.out.println(m);

		// usage:Generic/fun object
		List<String> s = new ArrayList<String>();
		s.add("33");
		s.add("44");
		for(int i = 0; i<s.size();i++){
			String ss= s.get(i);
			System.out.println(ss);			
		}
		
		Collection<String> t = new HashSet<String>();
		t.add("aa");
		t.add("bb");
		t.add("cc");
		for(Iterator<String> it = t.iterator();it.hasNext();){
			String tt = it.next();
			System.out.println(tt);
		}
	}
}
