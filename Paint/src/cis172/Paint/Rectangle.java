package cis172.Paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Rectangle extends Shape {

	
	@Override
	public void draw(Graphics g) { // Will add the visible dragging function later
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		
	}

}
