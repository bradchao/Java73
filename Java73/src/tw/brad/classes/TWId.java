package tw.brad.classes;

public class TWId {
	private String id;
	
	public static boolean isReightID(String id) {
		// 1. length = 10
		// 2. 1 => A-Z
		// 3. 2 => 1 or 2
		// 4. 3 - 10 => 0 ~ 9
		return true;
	}
	
}
