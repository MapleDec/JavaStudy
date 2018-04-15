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
 * 聊天室服务端
 * @author SU
 *
 */
public class Server {
	/*
	 * 运行服务端的ServerSocket的主要作用是
	 * 1：向OS申请服务端口
	 * 2：监听服务端口，等待客户连接，一旦一个客户端连接后
	 *    就回创建一个Socket实例与该客户端进行交互
	 */
	private ServerSocket server;
	/*
	 * 共享集合，存放客户端输出流
	 */
	private List<PrintWriter> allOut;
	
	public Server() throws IOException{
		/*
		 * 初始化需要指定服务端口，
		 * 若该端口被其他应用程序占用则会抛出异常
		 */
		server = new ServerSocket(8088);
		
		allOut = new ArrayList<PrintWriter>();
	}
	/**
	 * 从共享集合中将给定输出流存入
	 * @param out
	 */
	public synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	/**
	 * 从共享集合中将给定输出流删除
	 */
	public synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	/**
	 * 将给定消息发出
	 */
	public synchronized void sendMessage(String message){
		for(PrintWriter out:allOut){
			out.println(message);
		}
	}
	
	public void start(){
		try {
			/*
			 * ServerSocket 的方法
			 * Socket accept()
			 * 用来监听申请的服务端口，该方法是一个阻塞方法，直到一个客户端通过该端口与服务端建立连接，
			 * 这里边会自动创建一个Socket并返回，通过该Socket可以与刚连接的客户端进行交互。
			 */
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了！");
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
			System.out.println("服务端启动失败！");
		}
	}
	/*
	 * 该线程的任务是与指定客户端进行交互
	 */
	class ClientHandler implements Runnable{
		//该线程通过该Socket与指定客户端交互
		private Socket socket;
		//客户端地址信息
		private String host;
		
		public ClientHandler(Socket socket){
			this.socket= socket;
			//获取客户端地址信息
			InetAddress address = socket.getInetAddress();
			//将Ip地址信息转换为字符串形式
			host = address.getHostAddress();
		}
		
		public void run(){
			PrintWriter pw = null;
			try {
				
				/*
				 * 服务器输出流，将消息通过该流发送给客户端
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
				pw = new PrintWriter(osw,true);
				//将该输出流存入到共享集合中
				addOut(pw);
				/*
				 * Socket 的方法：
				 * InputStream getInputStream()
				 * 输入流 读取远端发来数据
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in,"utf-8");
				BufferedReader br = new BufferedReader(isr);
				
				//通知所有客户端，该用户上线了
				sendMessage(host+"上线了！当前在线人数"+allOut.size());
				pw.println("请输入昵称");
				
				String message = null;
				/*
				 * 操作系统不同，当客户端断开连接时，这里
				 * br.readLine  的反应也不同：
				 * linux：会返回 null
				 * Windows： 会直接抛异常
				 */
				String nickname = br.readLine();
				host = nickname;
				while((message = br.readLine())!=null){
					//System.out.println(host+"："+message);
					//pw.println(host+"："+message);
					sendMessage(host+"："+message);
				}
			} catch (Exception e) {
				
			}finally{
				try {
					//处理客户端断开连接后的操作
					
					//将客户端的输出流从共享集合删除
					removeOut(pw);
					
					sendMessage(host+"--"+"下线了！当前在线人数"+allOut.size());
					
					System.out.println(host+"下线了");
					//将Socket关闭
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
