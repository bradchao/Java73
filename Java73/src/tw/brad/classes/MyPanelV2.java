package tw.brad.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyPanelV2 extends JPanel {
	private LinkedList<Line> lines, recycle;
	private Color color;
	
	public MyPanelV2() {
		setBackground(Color.YELLOW);
		
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		color = Color.BLUE;
		
		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		
		g2d.setStroke(new BasicStroke(4));
		
		for (Line line: lines) {
			g2d.setColor(line.color);
			
			for (int i=1; i<line.points.size(); i++) {
				Point p0 = line.points.get(i-1);
				Point p1 = line.points.get(i);
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
	}
	
	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Line line = new Line(e.getX(), e.getY(), color);
			lines.add(line);			
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			lines.getLast().addPoint(e.getX(), e.getY());;
			repaint();
		}
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size() > 0) {
			recycle.add(lines.removeLast());
			repaint();
		}
	}
	
	public void redo() {
		if (recycle.size() > 0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}	
	
	
	
	
}


class Point {
	int x, y;
}

class Line {
	LinkedList<Point> points;
	Color color;
	Line(int x, int y, Color color){
		this.color = color;

		points = new LinkedList<Point>();
		addPoint(x, y);
	}
	void addPoint(int x, int y) {
		Point point = new Point();
		point.x = x; point.y = y;
		points.add(point);
	}
}












