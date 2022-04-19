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
	
	public void addPoint(int x, int y) {
		Circle s = new Circle();
		
		s.setX(x);
		s.setY(y);
		s.setWidth(getThickness());
		s.setHeight(getThickness());
		s.setColor(getColor());
		
		traces.add(s);
	}
	
	public Pen() {
		traces = new ArrayList<Circle>();
		
	}
	

}
