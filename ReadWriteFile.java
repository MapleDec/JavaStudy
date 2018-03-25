import java.io.File; 
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.BufferReader;
import java.io.BufferWriter;
import java.io.InputStreaReader;

public class ReadWriteFile{
	public static void main(String[] args){
		ReadWriteFile testReadFils = new ReadWriteFile();	
System.out.println(testReadFils.readFile("D:\123.txt"));		
	}
	 
	public static String readFile(String filePath){
		
		String strData="";
		
		InputStream inFile = new FileInputStrea(filePath);
		
		String line;
		
		while((line= inFile.readFile())!=null)
		{
			strData = line;
		}
		
		return strData;
	}
}
