package tw.brad.tutor;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Brad31 {

	public static void main(String[] args) {
		TreeSet<Integer> lottery1 = new TreeSet<>();
		while (lottery1.size() < 6) {
			lottery1.add((int)(Math.random()*38)+1);
		}
		System.out.printf("1: %s\n2: %d\n", lottery1, (int)(Math.random()*8)+1);
		System.out.println("---");
		for (Integer num : lottery1) {
			System.out.println(num);
		}
	}

}
