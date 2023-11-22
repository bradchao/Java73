package tw.brad.tutor;

public class Brad22 {
	public static void main(String[] args) {
		Brad221 obj1 = new Brad221();
		Brad221 obj2 = new Brad222();
		Brad222 obj3 = new Brad222();
		Brad222 obj4 = (Brad222)obj2;
		obj4.m2();
		if (obj3 instanceof Brad221) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		//Brad222 obj5 = (Brad222)obj1;
	}
}
class Brad221 {
	void m1() {System.out.println("Brad221:m1()");}
}
class Brad222 extends Brad221 {
	void m1() {System.out.println("Brad222:m1()");}	
	void m2() {System.out.println("Brad222:m2()");}	
}
class Brad223 extends Brad221 {
	void m1() {System.out.println("Brad223:m1()");}	
	void m2() {System.out.println("Brad223:m2()");}	
	void m3() {System.out.println("Brad223:m3()");}	
}
