package cis172.Paint;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	
	// List the attributes needed to draw shapes
	private int x;
	private int y; 
	private int height;
	private int width; 
	private Color color;
	private int thickness;
	
	//Abstract method to be implemented later
	public abstract void draw(Graphics g); 
	
	// Getters and setters for private attributes
	public int getX() {;
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getThickness() {
		return thickness;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	



	
}
