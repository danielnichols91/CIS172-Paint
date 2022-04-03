package cis172.Paint;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Picture extends JPanel{
	
	private ArrayList<Shape> shapes;
	
	public Picture() {
		shapes = new ArrayList<Shape>(); 
	}
	
	public void export() {
		// TODO: export image to a BMP, JPG, PNG, or other image format
	}
}
