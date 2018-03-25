// set a point and get its distance
public class TestPoint
{
	public static void main(String args[])
	{
		//when you need to calculate other point, change o's data
		Point o =  new Point(0,0,0);
		Point p =  new Point(4,7,3);		
		Point p1 =  new Point(1,2,2);		 
		System.out.println(Math.sqrt(p1.getDistanceOrigin(o)));
		System.out.println(Math.sqrt(p1.getDistanceOrigin(p)));
	}
}
 
class Point
{
	private int x;
	private int y;
	private int z;
	
	public Point(int _x, int _y, int _z)
	{
		x = _x ;
		y = _y;
		z = _z;		
	}
	
	public void setX(int _x)
	{
		x = _x;
	}
	
	public void setY(int _y)
	{
		y = _y;
	}
	
	public void setZ(int _z)
	{
		z = _z;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getZ()
	{
		return z;
	}
	
	public double getDistanceOrigin(Point p)
	{
		return  (x - p.x)*(x - p.x)+(y - p.y)*(y - p.y)+(z - p.z)*(z - p.z);		 
	}
	 
}

