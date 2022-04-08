package cis172.Paint;

import java.awt.Graphics;


public class Rectangle extends Shape {

	
	@Override
	public void draw(Graphics g) { // Will add the visible dragging function later
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		
	}

}
