import java.io.*;

public class FileIOTest{
	public static void main(String[] args){
		String fileTestpath = "C:\\Users\\pines\\Desktop\\JavaStudy\\IO\\FileIOTest.java";
		String fileInputStreamTestPath = "C:\\Users\\pines\\Desktop\\JavaStudy\\IO\\LoveWord.txt";
		String fileOutputStreamTestPath = "C:\\Users\\pines\\Desktop\\JavaStudy\\IO\\LoveWordCopy.txt";
		String fileOutputTestPath = "C:\\Users\\pines\\Desktop\\JavaStudy\\IO\\LoveWordFileOut.txt";
		 //testFileInputStream(fileTestpath);
		 testFileOutputStream(fileInputStreamTestPath,fileOutputStreamTestPath);
		 testFileReaderWriter(fileInputStreamTestPath,fileOutputTestPath);
	}
		 
	// Test FileInputStream class
	public static void testFileInputStream(String filePath){
		
		int b = 0;		
		FileInputStream inFile = null;
		try{
			/*inFile=new FileInputStream("C:\\Users\\pines\\Desktop\\JavaStudy\\IO\\FileIOTest.java");*/
			inFile=new FileInputStream(filePath);
		}catch(FileNotFoundException e){
			System.out.println("Not found file.");
			System.exit(-1);
		}
		
		try{
			long num = 0;
			while((b= inFile.read())!=-1){
				System.out.print((char)b);
				num++;				
			}
			
			inFile.close();
			System.out.println();
			System.out.println("Have read "+num+"charNode");			
		}catch(IOException e1){
			System.out.println("read file error");
			System.exit(-1);
		}
	}
	
	// Test FileOutputStream class
	public static void testFileOutputStream(String readFilePath, String writeFilePath){
		int b = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try{
			long num = 0;
			in = new FileInputStream(readFilePath);
			out = new FileOutputStream(writeFilePath);
			
			while((b=in.read())!=-1){
				out.write(b);
				num++;
			}
			
			in.close();
			out.flush();
			out.close();
			System.out.println("Have read "+num+" charNode");
		}catch(FileNotFoundException e2){
			System.out.println("Not found file.");
			System.exit(-1);
		}
		catch(IOException e1){
			System.out.println("File copy error.");
			System.exit(-1);
		}
		
		System.out.println("File copied.");
	}
	
	// Test FileReaderAndWriter class
	public static void testFileReaderWriter(String readFilePath, String writeFilePath){
		FileReader fileRead =null;
		FileWriter fileWriter= null;
		String wrWord = "I am not sing song as a bird.";
		int c = 0;
		try{
			fileRead = new FileReader(readFilePath);
			fileWriter = new FileWriter(writeFilePath);
			while((c=fileRead.read())!=-1){
				System.out.print((char)c);
			}
		fileRead.close();
		
		for()
		
		
	}catch(FileNotFoundException e){
		System.out.println("Not found specific file.");
	}catch(IOException e){
		System.out.println("Read File error.");
	}
	}
}
	
