package cis172;

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
	
	/**
	 * Draws whatever shape the user has chosen.
	 * @param g
	 */
	//Abstract method to be implemented later
	public abstract void draw(Graphics g);
	
	/**
	 * Returns the x value of a shape.
	 * @return x
	 */
	// Getters and setters for private attributes
	public int getX() {;
		return x;
	}

	/**
	 * Sets the x value of a shape.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Returns the y value of a shape.
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the y value of a shape.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Returns the height of a shape.
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height of a shape.
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Returns the width of a shape.
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of a shape.
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Returns the color of a shape.
	 * @return color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Sets the color of a shape.
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Returns the stroke thickness of a shape.
	 * @return thickness
	 */
	public int getThickness() {
		return thickness;
	}
	
	/**
	 * Sets the stroke thickness of a shape.
	 * @param thickness
	 */
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	



	
}
