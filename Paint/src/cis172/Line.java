package cis172;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shape{
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(getColor()==null) {
			throw new NullPointerException("Current Color is null and has not been selected");
		}
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawLine(getX(), getY(), getWidth(), getHeight());

		
	}

}
