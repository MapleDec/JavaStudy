public class Leaf
{
	int i =0;
	Leaf(int i){ this.i = i;}
	
	Leaf increateMent()
	{
		i++;
		return this;
	}	
	
	void print(){System.out.println("i="+i);}
	
	public static void main(String args[])
	{
		Leaf leaf = new Leaf(100);
		leaf.increateMent().increateMent().print();
		
	}
}

