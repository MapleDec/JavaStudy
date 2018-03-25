public class JavaBasicPrac
{
	public static void main(String args[])
	{
		System.out.println("Hello World.");
		
		getMax(45,120);
		testVar();
		testOperator();
		testSelectAndForWhile();		 
		System.out.println("\n5 factorial is "+factorialCacu(5));	
		System.out.println("\nFor Fibonacci Series, 10th number is "+fibonacciSeries(10));	
		System.out.println("\nFor Fibonacci Series about not invoke recursion, 10th number is "+fibonacciNotRecursion(10));	
		System.out.println("\nFor Fibonacci Series about not invoke recursion, 10th number is "+fibonacciNotRecursion(10));	
	}
	
	//get the max number, invoke method
	public static void getMax(int a, int b)	
	{
		if(a-b>0)
		{
			System.out.println("\nThe max number is "+a);			 
		}
		else 
		{
			if(a-b<0)
			{
				System.out.println("\nThe max number is "+b);				 
			}
			else 
				System.out.println("\n"+a+"="+b+".");				 
		}		  
	}
	// test variable
	public static void testVar()
	{
		int a01 = 12, a02= 23;
		int a03 = 17;
		float b01 = 7.8f;
		float b02 = (float)8.97;
		double c01 = 32e5;
		double c02 = 24e-4;
		
		System.out.println("Output int data: "+a01+"\t"+a02+"\t"+a03+"\t.");
		System.out.println("Output float data: "+b01+"\t"+b02+"\t.");
		System.out.println("Output double data: "+c01+"\t"+c02+"\t.");
	}
	
	// test operator
	public static void testOperator()
	{
		int a = 33, b = 25;
		int c = 0;
		String ming = "Jun";
		String xing = "Y";
		
		c = a++;
		System.out.println("\n++: "+c);
		c = a--;
		System.out.println("--: "+c);
		c = a&b;
		System.out.println("&: "+c);
		c = a|b;
		System.out.println("|: "+c);
		c = ~a;
		System.out.println("~: "+c);
		c = a^b;
		System.out.println("^: "+c);
		//c = a&&b;
		//System.out.println("&&: "+c);
		//c = a||b;
		//System.out.println("||: "+c);
		a *=3;
		System.out.println("a: "+a);
		b /=5; 
		System.out.println("b: "+b);
		System.out.println("My name is: "+ming+xing);		 
	}
	
	// test if, switch, for, while,
	public static void testSelectAndForWhile()
	{
		System.out.println("\nPlease input now year number:");		
		//int nowYear = System.r
		int nowYear = 2100;		
		if(nowYear%400==0)
		{
			System.out.println(nowYear+"is leap year.");
		}
		else
		{
			if(nowYear%4==0)
			{
				System.out.println(nowYear+"is leap year.");
			}
			else
			{
				System.out.println(nowYear+"is not leap year.");
			}
		}
		
		int money = 3;		
		switch(money)
		{
			case 3:
				System.out.println(money+": Poor poor people! Keep Fight!");
				money += 2;
			case 5:
				System.out.println(money+": Poor people! Keep Fight!");
				money += 3;
			case 8:
				money += 3;
				System.out.println(money+": General people! Keep Fight");
			case 15:
				money += 4;
				System.out.println(money+": Good people! Keep Fight\n");
				break;
			default:
				System.out.println("Error info.");				 				
		}
		
		/*		
		int arrayA[] = {23,43,32,54,22,11,5,20,98,66};
		int temp = 0;
		int m = 0;
		for(int i = 0;i<arrayA.length;i++)
		{
			for(int j = i+1;j<=arrayA.length;j++)
			{
				if(arrayA[i]>arrayA[i+1])
				{
					temp = arrayA[i];
					arrayA[i] = arrayA[i+1];
					arrayA[i+1] = temp;
				}
			}
		}
		for(int k = 0;k<arrayA.length;k++)
		{
			System.out.print(arrayA[k]+"\t");
		}
		*/
		
		int a[] =
		{ 12, 3, 23, 623, 23, 29, 76, 211, 434 };
		int temp = 0;		
		for (int i = 0; i < a.length; i++)
		{			
			for (int j = i + 1; j < a.length; j++)
			{
				if (a[i] > a[i + 1])
				{
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;	
				}
			}					
		}
		System.out.println();
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+"\t");
		}
		
		System.out.println("\n\nWork Or Away:");
		int nowTime = 4;
		while(nowTime<=18)
		{
			System.out.println(nowTime+": This is work time.");
			nowTime++;
		}
		if(nowTime>18)
		System.out.println("This is work away time.");
	
		int result = 0;
		int number = 1;
		do
		{
			result = number + result;
			number++;
		}while(number<=100);
		System.out.println("\n result value is: "+result);		
	}
	
	// recursion: JieCheng
	public static double factorialCacu(int i)
	{
		if(i==1)
			return i;
		else
			return i*factorialCacu(i-1);
	}

	// recursion: Fibonacci series
	public static int fibonacciSeries(int n)
	{
		if(n==1||n==2)
			return 1;
		else
			return fibonacciSeries(n-1)+fibonacciSeries(n-2);
	}
	
	// NotRecursion: Fibonacci series
	public static long fibonacciNotRecursion(int n)
	{
		if(n<1)
		{
			System.out.println("Error parameter. The parameters here should be larger than 1.");
			return -1;
		}
		
		if(n==1||n==2)
		{
			return 1;
		}
		
		long f1 = 1L;
		long f2 = 2L;
		long f = 0;
		
		for(int i = 0; i<=n-3; i++)
		{
			f = f1 + f2;
			
			f1 = f2;
			f2 = f;
		}
		return f;		
	} 
	
	
}
