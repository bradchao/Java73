package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad61 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://as2.ftcdn.net/v2/jpg/01/12/94/55/1000_F_112945567_lh2SHNBs1LiiM39NVqs6HhNkWfhbZ4yB.jpg");
			URLConnection conn = url.openConnection();
			
			try(BufferedInputStream bin = 
				new BufferedInputStream(
				conn.getInputStream());
				FileOutputStream fout = 
				new FileOutputStream("dir2/brad.jpg")
				){
				
				int len; byte[] buf = new byte[4*1024*1024];
				while ( (len = bin.read(buf)) != -1) {
					fout.write(buf, 0, len);
				}
				
				fout.flush();
				System.out.println("OK");
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
