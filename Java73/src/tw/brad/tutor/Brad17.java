package tw.brad.tutor;

public class Brad17 {

	public static void main(String[] args) {
		String s1 = "Brad";
		System.out.println("Brad".charAt(2));
		String s2 = "Brad";
		String s3 = new String("Brad");
		String s4 = new String("Brad");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		System.out.println("---");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s4.equals(s3));

	}

}
