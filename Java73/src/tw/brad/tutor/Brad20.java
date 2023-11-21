package tw.brad.tutor;

public class Brad20 {
	public static void main(String[] args) {
		Brad201 obj1 = new Brad201(2);
		System.out.println(obj1.toString());
		Brad202 obj2 = new Brad202();
		
	}
}

class Brad201 {
	Brad201(int a){
		System.out.println("Brad201()");
	}
}
class Brad202 extends Brad201 {
	Brad202(){
		super(3);
		System.out.println("Brad202()");
	}
}
