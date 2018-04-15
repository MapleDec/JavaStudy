import java.io.*;

public class FileList{
	public static void main(String[] args){
		File f = new File("C:/Users/pines/Desktop/CodeDev");
		System.out.println(f.getName());
		listTree(f,1);
	}
	
	// digui 
	public static void listTree(File f,int level){
		// achieve tab+2
		String preStr="";
		for(int i = 0;i<level;i++){
			preStr +="    ";
		}
		// eg a array file object
		File[] childs = f.listFiles();
		for(int i =0; i<childs.length;i++){
			System.out.println(preStr+childs[i].getName());
			// if this element is folder
			if(childs[i].isDirectory()){
				listTree(childs[i],level+1);
			}
		}
	}
}