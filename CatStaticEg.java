public class CatStaticEg
{
	private static int IDOrig=0;	
	private String name;
	int id;
	
	CatStaticEg(String name)
	{
		this.name=name;
		id = IDOrig++;
	}
	
	void info(){System.out.println("Cat "+this.id+" name is "+this.name);}
	
	public static void main(String args[])
	{
		CatStaticEg cucu = new CatStaticEg("cucu");
			CatStaticEg pipi = new CatStaticEg("pipi");
			cucu.info();
			pipi.info();
	}	 
}