import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PictureApp {

	public static void main(String[] args) throws IOException {
		URL url=new URL("https://c.ecimg.tw/items/DHBA0V1900AXUEU/000001_1614650538.jpg");
		
		URLConnection uc=url.openConnection();
		
		System.out.println("圖片大小為 : "+uc.getContentLength());
		
		InputStream in=uc.getInputStream();
		
		byte[] bt=new byte[1024];
		
		OutputStream out=new FileOutputStream("C:/OCP/demo.jpg");
		int size=0;
		
		while((size=(in.read(bt, 0, 1024)))>0) {
			out.write(bt, 0, size);
		}
		
		out.close();
		in.close();
		System.out.println("下載完成");
	}

}
