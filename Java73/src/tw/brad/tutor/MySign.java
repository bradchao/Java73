package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.classes.BradClock;
import tw.brad.classes.MyPanel;
import tw.brad.classes.MyPanelV2;

public class MySign extends JFrame {
	private MyPanel myPanel;
	private JButton clear, undo, redo, color, saveObj, loadObj, save;
	private BradClock clock;
	
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
		
		saveObj = new JButton("saveObj");
		top.add(saveObj);
		loadObj = new JButton("loadObj");
		top.add(loadObj);
		
		save = new JButton("save");
		top.add(save);
		
		clock = new BradClock();
		top.add(clock);
		
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
		
//		color.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Color color = JColorChooser.showDialog(null, "Change Color", myPanel.getColor());
//				if (color != null) {
//					myPanel.setColor(color);
//				}
//			}
//		});
		
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					File saveFile = jfc.getSelectedFile();
					
					try {
						myPanel.saveObj(saveFile);
						System.out.println("Save success");
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
				
			}
		});
		loadObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File loadFile = jfc.getSelectedFile();
					try {
						myPanel.loadObj(loadFile);
						System.out.println("Load success");
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					@Override
					public void run() {
						myPanel.saveJPEG();
					}
				}.start();
				
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}
