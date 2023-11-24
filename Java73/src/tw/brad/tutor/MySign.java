package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.classes.MyPanel;
import tw.brad.classes.MyPanelV2;

public class MySign extends JFrame {
	private MyPanel myPanel;
	private JButton clear, undo, redo, color;
	
	public MySign() {
		super("簽名App");
		
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		top.add(clear);
		undo = new JButton("Undo");
		top.add(undo);
		redo = new JButton("Redo");
		top.add(redo);
		color = new JButton("Color");
		top.add(color);
		
		add(top, BorderLayout.NORTH);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setupListener();
	}
	
	private void setupListener() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.redo();
			}
		});
		
		color.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Change Color", Color.BLUE);
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
