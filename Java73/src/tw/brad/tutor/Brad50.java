package tw.brad.tutor;

public class Brad50 {

	public static void main(String[] args) {
		Brad501 t1 = new Brad501("A");
		Brad501 t2 = new Brad501("B");
		Brad502 t3 = new Brad502("C");
		Thread t4 = new Thread(t3);
		t1.start(); t2.start();t4.start();
		System.out.println("main");
	}

}
class Brad501 extends Thread{
	String name;
	Brad501(String name){this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}

class Brad502 implements Runnable {
	String name;
	Brad502(String name){this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}



