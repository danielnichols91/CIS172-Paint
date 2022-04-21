package cis172;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Triangle extends Shape{

	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if(getColor()==null) {
			throw new NullPointerException("Current Color is null and has not been selected");
		}
		
		int y1;
		int y2;
		int y3;
		
		if (getY() > getHeight()) {
			y1 = getHeight();
			y2 = y3 = getY();
		} else {
			y1 = getY();
			y2 = y3 = getHeight();
		}
			
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawPolygon(new int[] {getX(), getWidth(), Math.abs(getWidth() - ((getWidth() - getX()) * 2))}, new int[] {y1, y2, y3}, 3);
	}

}