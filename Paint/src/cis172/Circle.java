package cis172.Paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape{

	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		
	}

}
