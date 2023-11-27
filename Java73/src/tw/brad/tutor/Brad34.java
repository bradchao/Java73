package tw.brad.tutor;

public class Brad34 {
	public static void main(String[] args) {
		int a = 10, b = 0;
		int[] c = {1,2,3,4};
		
		System.out.println("Brad");
		try {
			System.out.println(a / b);
			System.out.println("---");
			System.out.println(c[4]);
		}catch(RuntimeException e) {
			System.out.println("ERROR");
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("XXXXX");
//		}catch(ArithmeticException e) {
//			System.out.println("Ooop!");
		}
		System.out.println("Finish");
	}
}
