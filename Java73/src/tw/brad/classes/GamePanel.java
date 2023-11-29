package tw.brad.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private BufferedImage ball0;
	private int ballX, ballY, viewW, viewH, dx, dy, ballW, ballH;
	private Timer timer;
	
	public GamePanel() {
		setBackground(Color.YELLOW);
		
		try {
			ball0 = ImageIO.read(new File("dir1/ball0.png"));
			ballW = ball0.getWidth(); ballH = ball0.getHeight();
			ballX = ballY = 10;
			dx = dy = 2;
		} catch (IOException e) {
			System.out.println(e);
			System.exit(0);
		}
		
		
		
		timer = new Timer();
		timer.schedule(new BallTask(), 1*1000, 10);
		timer.schedule(new RefreshTask(), 0, 16);
	}
	
	private class RefreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	
	private class BallTask extends TimerTask {
		@Override
		public void run() {
			if (ballX <= 0 || ballX + ballW >= viewW) {
				dx *= -1;
			}
			if (ballY <= 0 || ballY + ballH >= viewH) {
				dy *= -1;
			}			
			ballX += dx;
			ballY += dy;
			//repaint();
			
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		viewW = getWidth(); viewH = getHeight();
		
		Graphics2D g2d = (Graphics2D)g;
		
	
		g2d.drawImage(ball0, ballX, ballY, null);
	}
}
