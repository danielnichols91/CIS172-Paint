package cis172.Paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shape{
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawLine(getX(), getY(), getWidth(), getHeight());

		
	}

}
