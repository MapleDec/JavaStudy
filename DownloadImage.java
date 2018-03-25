 import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;

public class DownloadImage
{

	public static void main(String[] args)
	{
		DownloadImage("http://a0.att.hudong.com/31/35/300533991095135084358827466.jpg", "JiGeng.jpg",
				"C:\\Users\\pines\\Desktop\\CodeDev\\123");
		DownloadImage("http://img.taopic.com/uploads/allimg/140812/240406-140Q20P05028.jpg", "JiGeng1.jpg",
				"C:\\Users\\pines\\Desktop\\CodeDev\\123");
	}

	public static void DownloadImage(String urlString, String fileNme, String savePath)
	{

		// 构造URL
		URL url = null;
		try
		{
			url = new URL(urlString);
		} catch (MalformedURLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 打开连接
		URLConnection con = null;
		try
		{
			con = url.openConnection();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置请求超时为5s
		//con.setConnectTimeout(5 * 1000);
		// 输入流
		InputStream inString = null;
		try
		{
			inString = con.getInputStream();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] byteString = new byte[1024];
		// 读取到的数据长度
		int fileIolentth;
		// 输出的文件流
		File saveDownloadImage = new File(savePath);
		if (!saveDownloadImage.exists())
		{
			saveDownloadImage.mkdirs();
		}
		OutputStream outString = null;
		try
		{
			outString = new FileOutputStream(saveDownloadImage.getPath() + "\\" + fileNme);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 开始读取
		try
		{
			while ((fileIolentth = inString.read(byteString)) != -1)
			{
				try
				{
					outString.write(byteString, 0, fileIolentth);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			outString.close();
			inString.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭所有链接

	}
 
}
