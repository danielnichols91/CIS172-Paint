package cis172.Paint;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Picture extends JPanel{
	
	enum ToolOpt {
		RECTANGLE,
		CIRCLE,
		LINE,
		TRIANGLE,
		ERASER,
		PAINTCAN
	}
	
	private ArrayList<Shape> shapes;
	private ToolOpt currentTool;
	
	public Picture() {
		shapes = new ArrayList<Shape>(); 
	}
	
	public void export() {
		// TODO: export image to a BMP, JPG, PNG, or other image format
	}
}
