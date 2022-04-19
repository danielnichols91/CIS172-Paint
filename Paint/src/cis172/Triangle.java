package cis172.Paint;

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
		int x3; 
		int y3;
		
		x3 = Math.abs(getWidth() - (getX() - getWidth()));
		y3 = Math.abs(getHeight() - getY());
			
		g.setColor(getColor());
		g2d.setStroke(new BasicStroke(getThickness()));
		g.drawPolygon(new int[] {getX(), getWidth(), x3}, new int[] {getY(), getHeight(), y3}, 3);
	}

}