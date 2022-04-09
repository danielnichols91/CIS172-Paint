package cis172.Paint;

import java.awt.Graphics;

public class Line extends Shape{
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(getX(), getY(), getWidth(), getHeight());

		
	}

}
