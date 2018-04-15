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
 * �����ҿͻ���
 * @author SU
 *
 */
public class Client {
	private Socket socket;
	/**
	 * ���췽����������ʼ���ͻ���
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client() throws UnknownHostException, IOException{
		/*
		 * ��ʼ��Socket
		 * ������������
		 * ����1��Զ�˼���� IP
		 * ����2��Զ�˼���� ����˿�
		 * ʵ����Socket�Ĺ��̾������ӵĹ���
		 * ��Զ�˼����û����Ӧ���׳��쳣
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
		
			
			System.out.println("�������ӷ����........");
			socket = new Socket(host,port);
			System.out.println("�����˽������ӣ�");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * �ͻ��˿�ʼ�����ķ���
	 */
	public void start(){
		try {
			//������ȡ�������Ϣ�߳�
			serverHandler hander = new serverHandler();
			Thread t = new Thread(hander);
			t.start();
			Scanner console = new Scanner(System.in);
			/*
			 * Socket �ķ�����
			 * OutputStream getOutputStream()
			 * ���ڻ�ȡһ���������ͨ���������д�����ֽڻᷢ�͵�Զ�˼����
			 * ��Զ�˼��������ͨ����������ȡ
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
			System.out.println("�ͻ�������ʧ��");
		}
	}
	/*
	 * ���̵߳������Ƕ�ȡ��������������Ϣ�������������̨
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
