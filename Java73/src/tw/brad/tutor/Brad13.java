package tw.brad.tutor;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Brad13 extends JFrame {
	private JButton b1, b2, b3;
	
	public Brad13() {
		
		b1 = new JButton("Open");
		b2 = new JButton("File");
		b3 = new JButton("Close");
		setLayout(new FlowLayout());
		add(b1); add(b2); add(b3);
		
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Brad13();
	}

}
