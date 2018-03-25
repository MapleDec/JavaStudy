class ClassBirthday
{
	private int day;
	private int month;
	private int year;
	
	public ClassBirthday(int y, int m, int d)
	{
		year = y;
		month = m;
		day = d;
	}
		
	public void setYear( int y)
	{
		year = y;
	}
	
	public void setMonth( int m)
	{
		month = m;
	}
	
	public void setDay( int d)
	{
		day = d;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}

	public void display()
	{
		System.out.println(year+"-"+month+"-"+day);
	}
}

public class TestClassBirthday
{
	public static void main(String args[])
	{
		ClassBirthday ming = new ClassBirthday(2016,12,21);
		ClassBirthday hua = new ClassBirthday(2016,12,17);		
		TestClassBirthday test = new TestClassBirthday();		
		int date = 9;
		
		test.change1(date);
		test.change2(ming);
		//test.change3(hua);
		
		System.out.println("date"+date);
		ming.display();
		hua.display();		 
	}
	
	private void change1(int i)
	{
		i = 1234;
	}
	
	private void change2(ClassBirthday b)
	{
		b = new ClassBirthday(2018,01,15);
	}
	
	//private void change3(ClassBirthday b)
	//{
		//b.setDay(27);
	//}
	
}