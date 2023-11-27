package tw.brad.tutor;

public class Brad35 {

	public static void main(String[] args) {
		Bird bird = new Bird();
		try {
			bird.setLeg(5);
		}catch(Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("----");
		test1(bird);
	}
	
	static void test1(Bird bird){
		try {
			test2(bird);
			System.out.println("test1():OK");
		}catch(Exception e) {
			System.out.println("test1():XX");
			return;
		}finally {
			System.out.println("finally");
		}
		System.out.println("test1():finish");
	}
	static void test2(Bird bird) throws Exception {
		bird.setLeg(2);
	}

}

class Bird {
	int leg;
	void setLeg(int num) throws Exception {
		if (num >= 0 && num <= 2) {
			leg = num;
		}else {
			throw new Exception();
		}
	}
}
