// overload method using
public class TestOverLoad
{
	void max(int a, int b)
	{
		System.out.print("int: ");
		System.out.println( a > b ? a : b);
	}
	
	void max(float a, float b)
	{
		System.out.print("float: ");
		System.out.println( a > b ? a : b);
	}
	
	void max(long a, long b)
	{
		System.out.print("long: ");
		System.out.println( a > b ? a : b);
	}
	
	public static void main(String[] args)
	{
		TestOverLoad num = new TestOverLoad();
		num.max(7,10);
		num.max(8.3f,3.4f);
		num.max(124231223, 343293323);
	}
}