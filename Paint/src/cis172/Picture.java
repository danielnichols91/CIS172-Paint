package cis172.Paint;

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
import java.lang.Math;

import cis172.Paint.Picture.ToolOpt;

public class Picture extends JPanel {

	// List all the options of tools that can be selected
	enum ToolOpt {
		RECTANGLE, CIRCLE, LINE, TRIANGLE, ERASER, PAINTCAN
	}

	// List the attributes needed for Picture
	private ArrayList<Shape> shapes;
	private static ToolOpt currentTool;
	private Color currentColor;
	private int currentWidth;

	public Picture() {
		// Give default values to attributes
		shapes = new ArrayList<Shape>();
		currentColor = Color.black;
		currentWidth = 5;
		currentTool = null;
		
		configMouseListener();
	}
	// Overload the constructor for Picture to set default values
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
					}
		
					
					d1.setX(e.getX());
					d1.setY(e.getY());

					shapes.add(d1);
					d1.setThickness(currentWidth);
					d1.setColor(currentColor);

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
					}
					repaint(); 

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
			}
			public void mouseMoved(MouseEvent e) {
				d1 = null; 
			}

		});
	}

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
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public static ToolOpt getCurrentTool() {
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