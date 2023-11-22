package tw.brad.tutor;

import tw.brad.classes.Brad211;

public class Brad24 {
	public static void main(String[] args) {
		Brad241 obj1 = new Brad242();
		Brad241 obj2 = new Brad241() {
			@Override
			void m2() {
				
			}
		};
		Brad211 obj3= new Brad211() {
			@Override
			public void m1() {
				
			}
		};
	}
}
abstract class Brad241 {
	void m1() {}
	abstract void m2();
}
class Brad242 extends Brad241 {
	void m2() {}
}
class Brad243 extends Brad241 {
	void m2() {}
}
