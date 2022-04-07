package cis172.Paint;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.JPanel;

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
