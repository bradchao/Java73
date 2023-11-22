package tw.brad.tutor;

import tw.brad.classes.*;

public class Brad21 {
	public static void main(String[] args) {
		Brad21a obj1 = new Brad21a();
		Brad21b obj2 = new Brad21b();
		obj1.m1();
		obj2.m1();
		test1(obj2);
	}
	
	static void test1(Brad211 obj) {
		obj.m1();
	}
}

class Brad21a implements Brad211{
	public void m1() {System.out.println("Brad21a:m1()");}
}
class Brad21b implements Brad211{
	public void m1() {System.out.println("Brad21b:m1()");}
}