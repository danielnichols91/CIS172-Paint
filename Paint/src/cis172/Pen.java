package cis172.Paint;

import java.awt.BasicStroke;

import java.awt.Graphics;
import java.util.ArrayList;

public class Pen extends Shape {
	
	private ArrayList<Circle> traces; 

	@Override
	public void draw(Graphics g) {	
		for (Circle i : traces) {
			i.draw(g, "look mom, I'm overloading!");
		}
		
	}
	
	/**
	 * Adds a new circle for each movement when using the pen tool.
	 * @param x
	 * @param y
	 */
	public void addPoint(int x, int y) {
		Circle s = new Circle();
		
		s.setX(x);
		s.setY(y);
		s.setWidth(getThickness());
		s.setHeight(getThickness());
		s.setColor(getColor());
		
		traces.add(s);
	}
	
	/**
	 * Creates a Pen class that instantiates traces.
	 */
	public Pen() {
		traces = new ArrayList<Circle>();
		
	}
	

}
