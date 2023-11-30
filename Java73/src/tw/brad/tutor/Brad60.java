package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Brad60 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://www.ispan.com.tw");
			URLConnection conn = url.openConnection();
			try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream()))){
				String line;
				while ( (line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
