package tw.brad.classes;

public class TWId {
	private String id;
	
	public static boolean isReightID(String id) {
		// 1. length = 10
		// 2. 1 => A-Z
		// 3. 2 => 1 or 2
		// 4. 3 - 10 => 0 ~ 9
		String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
		boolean isRight = false;
//		if (id.length() == 10) {
//			if (letters.indexOf(id.charAt(0)) >= 0) {
//				if (id.charAt(1) == '1' || id.charAt(1) == '2') {
//					
//				}
//			}
//		}
		
		if (id.matches("[A-Z][12][0-9]{8}")) {
			int a12 = letters.indexOf(id.charAt(0)) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			
			String s1 = id.substring(1,2);
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(id.substring(2, 3));
			int n3 = Integer.parseInt(id.substring(3, 4));
			int n4 = Integer.parseInt(id.substring(4, 5));
			int n5 = Integer.parseInt(id.substring(5, 6));
			int n6 = Integer.parseInt(id.substring(6, 7));
			int n7 = Integer.parseInt(id.substring(7, 8));
			int n8 = Integer.parseInt(id.substring(8, 9));
			int n9 = Integer.parseInt(id.substring(9, 10));
			
			
		}
		
		
		return isRight;
	}
	
}
