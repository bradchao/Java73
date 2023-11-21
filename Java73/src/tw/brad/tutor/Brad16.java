package tw.brad.tutor;

import tw.brad.classes.Scooter;

public class Brad16 {

	public static void main(String[] args) {
		String s1 = new String();
		byte[] b1 = {97, 98, 99, 100};
		String s2 = new String(b1);
		String s3 = new String(b1, 1, 2);
		Scooter s4 = new Scooter();
		System.out.println(s4);
		System.out.println(b1);
		System.out.println(s4);
	}

}
