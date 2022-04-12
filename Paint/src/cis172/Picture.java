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
		currentWidth= 5;
		currentTool = null; 
	}
	
	
	public void chooseTool() {
		
		DrawingShape d1 = null;
		
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(currentTool == ToolOpt.PAINTCAN) {
					setBackground(currentColor);
				}
			}
			
			
//			public void mousePressed(MouseEvent e) {
//				if(currentTool == ToolOpt.RECTANGLE) {
//					d1.setX(e.getX());
//					d1.setY(e.getY());
//				}
//				else if(currentTool == ToolOpt.CIRCLE) {
//					c1.setX(e.getX());
//					c1.setY(e.getY());
//				}
//				else if(currentTool == ToolOpt.LINE) {
//					l1.setX(e.getX());
//					l1.setY(e.getY());
//				}
//				else if(currentTool == ToolOpt.TRIANGLE) {
//					t1.setX(e.getX());
//					t1.setY(e.getY());
//				}
//				
//			}
			
			public void mouseDragged(MouseEvent e) {
				
				if (d1 == null) {
					d1.setX(e.getX());
					d1.setY(e.getY());
					
					shapes.add(d1);
					d1.setThickness(currentWidth);
					d1.setColor(currentColor);
					
				} else {
					if(currentTool == ToolOpt.RECTANGLE) {
						if (d1.getX() > e.getX()) {
							d1.setWidth(d1.getX() - e.getX());
							d1.setX(e.getX());
						} else {
							d1.setWidth(e.getX() - d1.getX());
						}
					
						if (d1.getY() > e.getY()) {
							d1.setHeight(d1.getY() - e.getY());
							d1.setY(e.getY());
						} else {
							d1.setHeight(e.getY() - d1.getY());
						}
					} else if(currentTool == ToolOpt.CIRCLE ) {
						if (d1.getX() > e.getX()) {
							d1.setWidth(d1.getX() - e.getX());
							d1.setX(e.getX());
						} else {
							d1.setWidth(e.getX() - d1.getX());
						}
						
						if (d1.getY() > e.getY()) {
							d1.setHeight(d1.getY() - e.getY());
							d1.setY(e.getY());
						} else {
							d1.setHeight(e.getY() - d1.getY());
						}
					} else if(currentTool == ToolOpt.LINE ) {
						d1.setWidth(e.getX());
						d1.setHeight(e.getY());
					} else if(currentTool == ToolOpt.TRIANGLE ) {
						d1.setWidth(e.getX());
						d1.setHeight(e.getY());
					}
					
				
				}
				
			
//			public void mouseReleased(MouseEvent e) {
//				if(currentTool == ToolOpt.RECTANGLE) {
//					if (r1.getX() > e.getX()) {
//						r1.setWidth(r1.getX() - e.getX());
//						r1.setX(e.getX());
//					} else {
//						r1.setWidth(e.getX() - r1.getX());
//					}
//				
//					if (r1.getY() > e.getY()) {
//						r1.setHeight(r1.getY() - e.getY());
//						r1.setY(e.getY());
//					} else {
//						r1.setHeight(e.getY() - r1.getY());
//					}
//				
//					shapes.add(r1);
//					r1.setThickness(currentWidth);
//					r1.setColor(currentColor);
//					r1.draw(getGraphics());
//				} else if(currentTool == ToolOpt.CIRCLE ) {
//					if (c1.getX() > e.getX()) {
//						c1.setWidth(c1.getX() - e.getX());
//						c1.setX(e.getX());
//					} else {
//						c1.setWidth(e.getX() - c1.getX());
//					}
//					
//					if (c1.getY() > e.getY()) {
//						c1.setHeight(c1.getY() - e.getY());
//						c1.setY(e.getY());
//					} else {
//						c1.setHeight(e.getY() - c1.getY());
//					}
//					
//
//
//					c1.draw(getGraphics());
//				} else if(currentTool == ToolOpt.LINE ) {
//					l1.setWidth(e.getX());
//					l1.setHeight(e.getY());
//					
//					shapes.add(l1);
//					l1.setThickness(currentWidth);
//					l1.setColor(currentColor);
//					l1.draw(getGraphics());
//				} else if(currentTool == ToolOpt.TRIANGLE ) {
//					t1.setWidth(e.getX());
//					t1.setHeight(e.getY());
//					
//					shapes.add(t1);
//					t1.setThickness(currentWidth);
//					t1.setColor(currentColor);
//					t1.draw(getGraphics());
//				} 
//			}
//			
//		});	
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
