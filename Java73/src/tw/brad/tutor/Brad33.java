package tw.brad.tutor;

import java.util.HashMap;

public class Brad33 {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Brad");
		map.put("gender", false);
		map.put("age", 18);
		map.put("weight", 79.6);
		
		System.out.println(map.get("name"));
		

	}

}
