package tw.brad.tutor;

import tw.brad.classes.Brad211;
import tw.brad.classes.Brad21c;

public class Brad23 {
	public static void main(String[] args) {
		Brad231 obj1 = new Brad231();
		Brad211 obj2 = new Brad231();
		Brad21c obj3 = new Brad231();
		obj3.m2(2);
	}
}
class Brad231 implements Brad211, Brad21c {
	public void m1() {}
	public void m2() {}
	public void m2(int a) {}
}
