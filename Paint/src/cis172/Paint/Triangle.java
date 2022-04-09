package cis172.Paint;

import java.awt.Graphics;

public class Triangle extends Shape{

	
	@Override
	public void draw(Graphics g) {
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
		
		g.drawPolygon(new int[] {getX(), getWidth(), x3}, new int[] {getY(), getHeight(), y3}, 3);
	}

}
