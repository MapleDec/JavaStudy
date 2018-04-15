package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * �����ҷ����
 * @author SU
 *
 */
public class Server {
	/*
	 * ���з���˵�ServerSocket����Ҫ������
	 * 1����OS�������˿�
	 * 2����������˿ڣ��ȴ��ͻ����ӣ�һ��һ���ͻ������Ӻ�
	 *    �ͻش���һ��Socketʵ����ÿͻ��˽��н���
	 */
	private ServerSocket server;
	/*
	 * �����ϣ���ſͻ��������
	 */
	private List<PrintWriter> allOut;
	
	public Server() throws IOException{
		/*
		 * ��ʼ����Ҫָ������˿ڣ�
		 * ���ö˿ڱ�����Ӧ�ó���ռ������׳��쳣
		 */
		server = new ServerSocket(8088);
		
		allOut = new ArrayList<PrintWriter>();
	}
	/**
	 * �ӹ������н��������������
	 * @param out
	 */
	public synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	/**
	 * �ӹ������н����������ɾ��
	 */
	public synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	/**
	 * ��������Ϣ����
	 */
	public synchronized void sendMessage(String message){
		for(PrintWriter out:allOut){
			out.println(message);
		}
	}
	
	public void start(){
		try {
			/*
			 * ServerSocket �ķ���
			 * Socket accept()
			 * ������������ķ���˿ڣ��÷�����һ������������ֱ��һ���ͻ���ͨ���ö˿������˽������ӣ�
			 * ����߻��Զ�����һ��Socket�����أ�ͨ����Socket����������ӵĿͻ��˽��н�����
			 */
			while(true){
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();
				System.out.println("һ���ͻ��������ˣ�");
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���������ʧ�ܣ�");
		}
	}
	/*
	 * ���̵߳���������ָ���ͻ��˽��н���
	 */
	class ClientHandler implements Runnable{
		//���߳�ͨ����Socket��ָ���ͻ��˽���
		private Socket socket;
		//�ͻ��˵�ַ��Ϣ
		private String host;
		
		public ClientHandler(Socket socket){
			this.socket= socket;
			//��ȡ�ͻ��˵�ַ��Ϣ
			InetAddress address = socket.getInetAddress();
			//��Ip��ַ��Ϣת��Ϊ�ַ�����ʽ
			host = address.getHostAddress();
		}
		
		public void run(){
			PrintWriter pw = null;
			try {
				
				/*
				 * �����������������Ϣͨ���������͸��ͻ���
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
				pw = new PrintWriter(osw,true);
				//������������뵽��������
				addOut(pw);
				/*
				 * Socket �ķ�����
				 * InputStream getInputStream()
				 * ������ ��ȡԶ�˷�������
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"utf-8");
				BufferedReader br = new BufferedReader(isr);
				
				//֪ͨ���пͻ��ˣ����û�������
				sendMessage(host+"�����ˣ���ǰ��������"+allOut.size());
				pw.println("�������ǳ�");
				
				String message = null;
				/*
				 * ����ϵͳ��ͬ�����ͻ��˶Ͽ�����ʱ������
				 * br.readLine  �ķ�ӦҲ��ͬ��
				 * linux���᷵�� null
				 * Windows�� ��ֱ�����쳣
				 */
				String nickname = br.readLine();
				host = nickname;
				while((message = br.readLine())!=null){
					//System.out.println(host+"��"+message);
					//pw.println(host+"��"+message);
					sendMessage(host+"��"+message);
				}
			} catch (Exception e) {
				
			}finally{
				try {
					//����ͻ��˶Ͽ����Ӻ�Ĳ���
					
					//���ͻ��˵�������ӹ�����ɾ��
					removeOut(pw);
					
					sendMessage(host+"--"+"�����ˣ���ǰ��������"+allOut.size());
					
					System.out.println(host+"������");
					//��Socket�ر�
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
