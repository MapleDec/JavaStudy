import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadPicture
{
	public static void downLoadPicture(String _urlString, String _fileName, String _filePath)
	{
		URL urlString = null;
		try
		{
			urlString = new URL(_urlString);
		} catch (MalformedURLException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		URLConnection urlFile = null;
		try
		{
			urlFile = urlString.openConnection();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InputStream inputNewFileStream = null;
		try
		{
			inputNewFileStream = urlFile.getInputStream();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int readLenth;
		byte[] byteCahe = new byte[1024];
		
		File outNewFile = new File(_filePath);
		if (!outNewFile.exists())
		{
			outNewFile.mkdirs();
		}
		OutputStream outNewFileStream = null;
		try
		{
			outNewFileStream = new FileOutputStream(outNewFile.getPath() + "\\" + _fileName);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		try
		{
			while ((readLenth = inputNewFileStream.read(byteCahe)) != -1)
			{
				outNewFileStream.write(byteCahe, 0, readLenth);
			}
			outNewFileStream.flush();
			outNewFileStream.close();

			inputNewFileStream.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		downLoadPicture("http://a0.att.hudong.com/31/35/300533991095135084358827466.jpg",
				"Map.jpg","C:\\Users\\pines\\Desktop\\JavaStudy\\TestFileOut");
		downLoadPicture("http://img.taopic.com/uploads/allimg/140812/240406-140Q20P05028.jpg", "JiGeng1.jpg",
				"C:\\Users\\pines\\Desktop\\JavaStudy\\TestFileOut");
	}

}
