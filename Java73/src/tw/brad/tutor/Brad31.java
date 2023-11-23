package tw.brad.tutor;

import java.util.HashSet;

public class Brad31 {

	public static void main(String[] args) {
		HashSet<Integer> lottery1 = new HashSet<>();
		while (lottery1.size() < 6) {
			lottery1.add((int)(Math.random()*38)+1);
		}
		System.out.printf("1: %s\n2: %d", lottery1, (int)(Math.random()*8)+1);
	}

}
