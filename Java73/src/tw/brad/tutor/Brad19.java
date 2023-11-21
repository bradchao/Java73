package tw.brad.tutor;

import tw.brad.classes.TWId;

public class Brad19 {

	public static void main(String[] args) {
		TWId myId = TWId.createTWId("A123456789");
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId(7);
		TWId id4 = new TWId(true, 25);
		
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		

	}

}
