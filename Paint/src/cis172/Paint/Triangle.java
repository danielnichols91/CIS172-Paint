package cis172.Paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Shape{

	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		int x3; 
		int y3;
		
		if (getX() > getWidth()) {
			x3 = getWidth() - (getX() - getWidth());
		} else {
			x3 = getX() - (getWidth() - getX());
		}
		
		if (getY() > getHeight()) {
			y3 = getY();
		} else {
			y3 = getHeight();
		}
		
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawPolygon(new int[] {getX(), getWidth(), x3}, new int[] {getY(), getHeight(), y3}, 3);
	}

}
