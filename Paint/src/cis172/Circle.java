package cis172.Paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends Shape{

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(getColor()==null) {
			throw new NullPointerException("Current Color is null and has not been selected");
		}
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		
	}
	
	/**
	 * Draws filled circles specifically for the pen function.
	 * @param g
	 * @param r
	 */
	// Overloading draw specifically for pen function
	public void draw(Graphics g, String r) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}

}
