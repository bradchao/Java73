package tw.brad.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private BufferedImage ball0;
	
	public GamePanel() {
		setBackground(Color.YELLOW);
		
		try {
			ball0 = ImageIO.read(new File("dir1/ball0.png"));
		} catch (IOException e) {
			System.out.println(e);
			System.exit(0);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
	
		g2d.drawImage(ball0, 10, 10, null);
		
		
		
		
		
		
		
	}
}
