package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import tw.brad.classes.MyTable;

public class JDBC16 extends JFrame {
	private MyTable myTable;
	
	public JDBC16() {
		
		setLayout(new BorderLayout());

		myTable = new MyTable();
		JScrollPane jsp = new JScrollPane(myTable);
		add(jsp, BorderLayout.CENTER);
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JDBC16();

	}

}
