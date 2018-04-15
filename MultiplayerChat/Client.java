package chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**
 * 聊天室客户端
 * @author SU
 *
 */
public class Client {
	private Socket socket;
	/**
	 * 构造方法，用来初始化客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client() throws UnknownHostException, IOException{
		/*
		 * 初始化Socket
		 * 传入两个参数
		 * 参数1：远端计算机 IP
		 * 参数2：远端计算机 服务端口
		 * 实例化Socket的过程就是连接的过程
		 * 若远端计算机没有响应会抛出异常
		 */
		String host = null;
		int port = 0 ;
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("config.xml"));
			String hostPath = "/config/serverhost";
			String portPath = "/config/serverport";
			
			List<Element> hostList = doc.selectNodes(hostPath);
			for(Element ele : hostList){
				host = ele.getText();
			}
			
			List<Element> portList = doc.selectNodes(portPath);
			for(Element ele : portList){
				port =Integer.parseInt( ele.getText());
			}
		
			
			System.out.println("正在连接服务端........");
			socket = new Socket(host,port);
			System.out.println("与服务端建立连接！");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		try {
			//启动读取服务端消息线程
			serverHandler hander = new serverHandler();
			Thread t = new Thread(hander);
			t.start();
			Scanner console = new Scanner(System.in);
			/*
			 * Socket 的方法：
			 * OutputStream getOutputStream()
			 * 用于获取一个输出流，通过该输出流写出的字节会发送到远端计算机
			 * 而远端计算机可以通过输入流读取
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
			PrintWriter pw = new PrintWriter(osw,true);
			
			String message = null;
			while(true){
				message = console.nextLine();
				pw.println(message);
			}
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端运行失败");
		}
	}
	/*
	 * 该线程的任务是读取服务器发来的信息，并输出到控制台
	 */
	class serverHandler implements Runnable{
		public void run(){
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"utf-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while((message=br.readLine())!=null){
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
