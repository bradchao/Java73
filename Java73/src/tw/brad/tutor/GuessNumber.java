package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	
	public GuessNumber() {
		// super();
		super("猜數字遊戲");
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		guess.addActionListener(this);
		
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		answer = createAnswer(3);
		//System.out.println(answer);
	}
	
	private String createAnswer(int d) {
		int num = 10;
		int[] poker = new int[num];
		for (int i=0; i< poker.length; i++) poker[i] = i;
		
		for (int i = num -1;  i > 0; i--) {	// num .... 1
			int rand = (int)(Math.random()*(i+1));
			// poker[rand] <-> poker[i];
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}	
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<d; i++)sb.append(poker[i]);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		new GuessNumber();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(createAnswer(4));
		String inputText = input.getText();
		String result = checkAB(inputText);	// ex. 1A2B
		log.append(String.format("%s => %s\n", inputText, result));
		input.setText("");
		
	}
	
	private String checkAB(String g) {
		int a, b ; a = b = 0;
		for (int i = 0; i< g.length(); i++) {
			if (g.charAt(i) == answer.charAt(i)) {
				a++;
			}else if (answer.indexOf(g.charAt(i)) >= 0) {
				b++;
			}
		}
		return String.format("%dA%dB", a, b);
	}
	
	
	
	

}
