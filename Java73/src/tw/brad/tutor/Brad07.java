package tw.brad.tutor;

public class Brad07 {

	public static void main(String[] args) {
		// loop
		int a = 0;
		for ( printBrad(); a < 10 ; printLine()) {
			System.out.println(a++);
		}
	}
	
	static void printBrad() {
		System.out.println("Brad");
	}
	static void printLine() {
		System.out.println("----");
	}

}
