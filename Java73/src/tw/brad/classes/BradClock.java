package tw.brad.classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class BradClock extends JLabel {
	private Timer timer;
	
	public BradClock() {
		//setText("10:10:20");
		timer = new Timer();
		timer.schedule(new ClockTask(), 0, 100);
	}

	private class ClockTask extends TimerTask {
		@Override
		public void run() {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			setText(sdf.format(now));
		}
	}
}
