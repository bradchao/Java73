package tw.brad.tutor;

public class Brad11 {

	public static void main(String[] args) {
		int[][] a = new int[3][4];
		// Array <-> Matrix
		int[][] b = new int[3][];
		b[0] = new int[2];
		b[1] = new int[3];
		b[2] = new int[4];
		
		for (int i=0; i<b.length; i++) {
			// b[i]
			for (int j=0; j<b[i].length; j++) {
				System.out.print(b[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("---");
		// for-each
		
		for (int[] v : b) {
			for (int vv : v) {
				System.out.print(vv + "  ");
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
