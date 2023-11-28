package tw.brad.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame{
	private JButton go;
	private JLabel[] runways;
	private Car[] cars;
	private int rank;
	
	public Racing() {
		
		setLayout(new GridLayout(9, 1));
		go = new JButton("Go!");
		add(go);
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		
		cars = new Car[8];
		runways = new JLabel[8];
		for (int i=0; i<runways.length; i++) {
			runways[i] = new JLabel((i+1) + ". ");
			add(runways[i]);
		}
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void go() {
		go.setEnabled(false);
		for (int i=0; i<cars.length; i++) {
			runways[i].setText((i+1) + ". ");
			cars[i] = new Car(i);
			cars[i].start();
		}
	}
	
	private class Car extends Thread {
		private int way;
		Car(int way){this.way = way;}
		
		@Override
		public void run() {
			for (int i=0; i< 100; i++) {
				if (i == 99) {
					runways[way].setText(runways[way].getText() + ">" + "WINNER");
					destroyCars();
				}else {
					runways[way].setText(runways[way].getText() + ">");
				}
				try {
					Thread.sleep(10 + (int)(Math.random()*100));
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
	
	private void destroyCars() {
		for (Car car : cars) {
			car.interrupt();
		}
		go.setEnabled(true);
	}
	
	
	public static void main(String[] args) {
		new Racing();

	}

}
