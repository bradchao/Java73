package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	
	public GuessNumber() {
		// super();
		super("猜數字遊戲");
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GuessNumber();

	}

}
