package tw.brad.tutor;

public class Brad50 {

	public static void main(String[] args) {
		Brad501 t1 = new Brad501();
		Brad501 t2 = new Brad501();
		t1.start(); t2.start();
		System.out.println("main");
	}

}
class Brad501 extends Thread{
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println(i);
		}
	}
}
