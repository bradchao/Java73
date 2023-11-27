package tw.brad.tutor;

public class Brad34 {
	public static void main(String[] args) {
		int a = 10, b = 3;
		int[] c = {1,2,3,4};
		
		System.out.println("Brad");
		try {
			System.out.println(a / b);
			System.out.println("---");
			System.out.println(c[4]);
		}catch(ArithmeticException e) {
			System.out.println("Ooop!");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("XXXXX");
		}
		System.out.println("Finish");
	}
}
