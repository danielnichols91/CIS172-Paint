package cis172;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import cis172.Picture.ToolOpt;

import java.lang.Math;

public class Picture extends JPanel {

	// List all the options of tools that can be selected
	public enum ToolOpt {
		RECTANGLE, CIRCLE, LINE, TRIANGLE, PEN, ERASER, PAINTCAN
	}

	// List the attributes needed for Picture
	private ArrayList<Shape> shapes;
	private static ToolOpt currentTool;
	private Color currentColor;
	private int currentWidth;

	/**
	 * Creates a new Picture in Frame.
	 */
	public Picture() {
		// Give default values to attributes
		shapes = new ArrayList<Shape>();
		currentColor = Color.black;
		currentWidth = 5;
		currentTool = null;
		
		configMouseListener();
	}
	
	/**
	 * Overloads the constructor for Picture to set default values
	 * @param color
	 * @param width
	 */
	public Picture(Color color, int width) {
		// Give default values to attributes
				shapes = new ArrayList<Shape>();
				currentColor = color;
				currentWidth = width;
				currentTool = null;
				
				configMouseListener();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(int index = 0; index < shapes.size(); index++) {
			shapes.get(index).draw(g);
		}
	}

	public void configMouseListener() {
		
		addMouseListener(new MouseAdapter( ) {
			public void mouseClicked(MouseEvent e) {
				if (currentTool == ToolOpt.PAINTCAN) {
					setBackground(currentColor);
				}
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			private Shape d1 = null;

			public void mouseDragged(MouseEvent e) {

				if (d1 == null) {
					if(currentTool == ToolOpt.RECTANGLE) {
						d1 = new Rectangle();
						// Use instanceof to assert the values of d1 are shapes
						assert(d1 instanceof Shape);
					} else if (currentTool == ToolOpt.CIRCLE) {
						d1 = new Circle();
						assert(d1 instanceof Shape);
					} else if (currentTool == ToolOpt.TRIANGLE) {
						d1 = new Triangle();
						assert(d1 instanceof Shape);
					} else if (currentTool == ToolOpt.LINE) {
						d1 = new Line();
						assert(d1 instanceof Shape);
					} else if (currentTool == ToolOpt.PEN || currentTool == ToolOpt.ERASER) {
						d1 = new Pen();
						assert(d1 instanceof Shape);
					}
		
					
					d1.setX(e.getX());
					d1.setY(e.getY());

					shapes.add(d1);
					d1.setThickness(currentWidth);
					
					if (currentTool == ToolOpt.ERASER) {
						d1.setColor(getBackground());
					} else {
						d1.setColor(currentColor);
					}

				} else {
					if (currentTool == ToolOpt.RECTANGLE || currentTool == ToolOpt.CIRCLE) {
						d1.setWidth(Math.abs(d1.getX() - e.getX()));
						d1.setHeight(Math.abs(d1.getY() - e.getY()));
					} else if (currentTool == ToolOpt.LINE) {
						d1.setWidth(e.getX());
						d1.setHeight(e.getY());
					} else if (currentTool == ToolOpt.TRIANGLE) {
						d1.setWidth(e.getX());
						d1.setHeight(e.getY());
					} else if (currentTool == ToolOpt.PEN || currentTool == ToolOpt.ERASER) {
						((Pen) d1).addPoint(e.getX(), e.getY());
					} 
					
					repaint(); 

				}
		
			}
			public void mouseMoved(MouseEvent e) {
				d1 = null; 
			}

		});
	}

	/**
	 * Saves and exports a file of Picture.
	 */
	public void export() {
		// Define a fileChooser, a file to save the image to, and an output stream
		JFileChooser fileChooser = new JFileChooser();
		File fileToSaveTo = null;
		BufferedOutputStream out = null;
		// Set the default directory 
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		// Check if a file was chosen
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			fileToSaveTo = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + fileToSaveTo.getAbsolutePath());
			try {
				fileToSaveTo.createNewFile(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Create a buffferedImage and a 2D graphics
		BufferedImage image = new BufferedImage(getWidth(), getHeight() , BufferedImage.TYPE_INT_RGB);
		Graphics2D graphic = image.createGraphics();
		// Paint the graphic based on the panel
		paint(graphic);
		try {
			out = new BufferedOutputStream(new FileOutputStream(fileToSaveTo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			// Write an image into the selected file
			ImageIO.write(image, "png", out);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Getters and setters for private variables
	/**
	 * Returns Shapes held in Picture.
	 * @return shapes
	 */
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	/**
	 * Returns currentTool.
	 * @return currentTool
	 */
	public static ToolOpt getCurrentTool() {
		return currentTool;
	}

	/**
	 * Sets currentTool.
	 * @param currentTool
	 */
	public void setCurrentTool(ToolOpt currentTool) {
		this.currentTool = currentTool;
	}

	/**
	 * Returns currentColor.
	 * @return currentColor
	 */
	public Color getCurrentColor() {
		return currentColor;
	}

	/**
	 * Sets currentColor.
	 * @param currentColor
	 */
	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	/**
	 * Returns current width of stroke.
	 * @return currentWidth
	 */
	public int getCurrentWidth() {
		return currentWidth;
	}

	/**
	 * Sets current width of stroke.
	 * @param currentWidth
	 */
	public void setCurrentWidth(int currentWidth) {
		this.currentWidth = currentWidth;
	}

}