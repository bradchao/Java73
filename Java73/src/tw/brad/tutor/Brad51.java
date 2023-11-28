package tw.brad.tutor;

public class Brad51 {

	public static void main(String[] args) {
		Brad511 obj1 = new Brad511();
		Brad512 obj2 = new Brad512();
		obj1.setDaemon(true);
		obj2.setDaemon(true);
		obj1.start();
		obj2.start();
		System.out.println("main");
	}

}

class Brad511 extends Thread {
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("A:" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}
class Brad512 extends Thread {
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("B:" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}
