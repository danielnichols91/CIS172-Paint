package cis172.Paint;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import cis172.Paint.Picture.ToolOpt;

public class Picture extends JPanel {
	
	// List all the options of tools that can be selected
	enum ToolOpt {
		RECTANGLE,
		CIRCLE,
		LINE,
		TRIANGLE,
		ERASER,
		PAINTCAN
	}
	
	// List the attributes needed for Picture
	private ArrayList<Shape> shapes;
	private ToolOpt currentTool;
	private Color currentColor;
	private int currentWidth;
	
	public Picture() {
		// Give default values to attributes
		shapes = new ArrayList<Shape>();
		currentColor = Color.black;
		currentWidth=10;
		currentTool = null; 
		
		if (currentTool == ToolOpt.RECTANGLE) { 
			Rectangle r1 = new Rectangle();
			
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					r1.setX(e.getX());
					r1.setY(e.getY());
					
				}
				
				public void mouseReleased(MouseEvent e) {
					r1.setWidth(e.getX() - r1.getX());
					r1.setHeight(e.getY() - r1.getY());
					
					shapes.add(r1);
					r1.draw(getGraphics());
					
				}
				
			});
			
			
		} else if (currentTool == ToolOpt.CIRCLE) { 
			Circle c1 = new Circle();
			
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					c1.setX(e.getX());
					c1.setY(e.getY());
					
				}
				
				public void mouseReleased(MouseEvent e) {
					c1.setWidth(e.getX() - c1.getX());
					c1.setHeight(e.getY() - c1.getY());
					
					shapes.add(c1);
					c1.draw(getGraphics());
					
				}
				
			});
			
			
		}
		
	}
	
	public void export() {
		// TODO: export image to a BMP, JPG, PNG, or other image format
	}

	// Getters and setters for private variables
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public ToolOpt getCurrentTool() {
		return currentTool;
	}

	public void setCurrentTool(ToolOpt currentTool) {
		this.currentTool = currentTool;
	}

	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}
	
	public int getCurrentWidth() {
		return currentWidth;
	}
	
	public void setCurrentWidth(int currentWidth) {
		this.currentWidth = currentWidth; 
	}
	
	
	
}
