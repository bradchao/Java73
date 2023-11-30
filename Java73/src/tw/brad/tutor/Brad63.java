package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad63 {

	public static void main(String[] args) {		
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			URLConnection conn = url.openConnection();
			try(BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream()))){
				String line; StringBuffer sb = new StringBuffer();
				while ( (line = reader.readLine()) != null) {
					sb.append(line);
				}
				parseJSON(sb.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());
		for (Object row : root) {
			JSONObject data = (JSONObject)row;
			String name = data.getString("Name");
			System.out.println(name);
		}
	}
	
	

}
