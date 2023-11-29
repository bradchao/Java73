package tw.brad.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad52 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		
		MyTask task = new MyTask();
		timer.schedule(task, 3*1000, 1000);
		
		StopTask stop = new StopTask(timer);
		timer.schedule(stop, 7*1000);
		
		System.out.println("main");
	}

}

class MyTask extends TimerTask {
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}

class StopTask extends TimerTask {
	private Timer timer;
	StopTask(Timer timer){this.timer = timer;}
	@Override
	public void run() {
		timer.cancel();
		timer.purge();
		timer = null;
	}
}


