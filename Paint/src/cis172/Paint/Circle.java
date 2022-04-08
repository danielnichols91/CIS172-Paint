package cis172.Paint;

import java.awt.Graphics;

public class Circle extends Shape{

	
	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		
	}

}
