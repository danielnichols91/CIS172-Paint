package cis172.Paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Image; 
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import cis172.Paint.Picture.ToolOpt;

public class ToolBar extends JPanel implements ActionListener{

	private Picture picture;
	
	// Define all of the components for the toolBar
	private ToolBarButton circleBtn;
	private ToolBarButton triangleBtn;
	private ToolBarButton rectangleBtn;
	private ToolBarButton lineBtn;
	private ToolBarButton penBtn;
	private ToolBarButton eraserBtn;
	private ToolBarButton exportBtn;
	private JComboBox thicknessMenu;
	private ToolBarButton paintCanBtn;
	private ToolBarButton selectColorBtn;
	private JPanel currentColorDisplay;
	
	/**
	 * Creates a new toolbar.
	 * @param picture
	 */
	public ToolBar(Picture picture) {
		this.picture = picture; 
		
		// Format the circle button 
		circleBtn = new ToolBarButton();
		circleBtn.addActionListener(this);
		ImageIcon circleIcon = new ImageIcon("circleIcon.png"); 
		circleBtn.setToolTipText("Click and drag to draw a circle");
		// Resize the image to fit the button
		Image circleImg = circleIcon.getImage();  
	    Image resizedImage = circleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    circleIcon= new ImageIcon(resizedImage);
		circleBtn.setIcon(circleIcon);
		
		// Format the triangle button
		triangleBtn = new ToolBarButton();
		triangleBtn.addActionListener(this);
		ImageIcon triangleIcon = new ImageIcon("triangleIcon.png"); 
		triangleBtn.setToolTipText("Click and drag to draw a triangle");
		// Resize the image to fit the button
		Image triangleImg = triangleIcon.getImage();  
	    resizedImage = triangleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    triangleIcon= new ImageIcon(resizedImage);
		triangleBtn.setIcon(triangleIcon);
		
		// Format the rectangle button
		rectangleBtn = new ToolBarButton();
		rectangleBtn.addActionListener(this);
		rectangleBtn.setToolTipText("Click and drag to draw a rectangle");
		ImageIcon rectangleIcon = new ImageIcon("rectangleIcon.png");
		// Resize the image to fit the button
		Image rectangleImg = rectangleIcon.getImage();  
	    resizedImage = rectangleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    rectangleIcon= new ImageIcon(resizedImage);
		rectangleBtn.setIcon(rectangleIcon);
		
		// Format the line button
		lineBtn = new ToolBarButton();
		lineBtn.addActionListener(this);
		lineBtn.setToolTipText("Click and drag to draw a line");
		ImageIcon lineIcon = new ImageIcon("lineIcon.png");
		// Resize the image to fit the button
		Image lineImg = lineIcon.getImage();  
	    resizedImage = lineImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    lineIcon= new ImageIcon(resizedImage);
		lineBtn.setIcon(lineIcon);
		
		// Format the pen button
		penBtn = new ToolBarButton();
		penBtn.setPreferredSize(new Dimension(50,50));
		penBtn.addActionListener(this);
		penBtn.setToolTipText("Click and drag to use pen");
		ImageIcon penIcon = new ImageIcon("penIcon.png");
		// Resize the image to fit the button
		Image penImg = penIcon.getImage();  
	    resizedImage = penImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    penIcon= new ImageIcon(resizedImage);
		penBtn.setIcon(penIcon);
		penBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		penBtn.setBorderPainted(false);
		
		// Format the eraser button
		eraserBtn = new ToolBarButton();
		eraserBtn.addActionListener(this);
		eraserBtn.setToolTipText("Click and drag to erase");
		ImageIcon eraserIcon = new ImageIcon("eraserIcon.png");
		// Resize the image to fit the button
		Image eraserImg = eraserIcon.getImage();  
	    resizedImage = eraserImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    eraserIcon= new ImageIcon(resizedImage);
		eraserBtn.setIcon(eraserIcon);
		
		// Format the export button
		exportBtn = new ToolBarButton();
		exportBtn.addActionListener(this);
		exportBtn.setToolTipText("Export your picture");
		ImageIcon exportIcon = new ImageIcon("exportIcon.png");
		// Resize the image to fit the button
		Image exportImg = exportIcon.getImage();  
	    resizedImage = exportImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    exportIcon= new ImageIcon(resizedImage);
		exportBtn.setIcon(exportIcon);
		
		// Format the thickness Menu and add options
		String[] thicknesses = {"5 px", "10 px", "15 px", "20 px", "25 px"};
		thicknessMenu = new JComboBox(thicknesses);
		thicknessMenu.addActionListener(this);
		thicknessMenu.setToolTipText("Select weight/thickness");
		
		// Format the paintCan Button 
		paintCanBtn = new ToolBarButton();
		paintCanBtn.addActionListener(this);
		paintCanBtn.setToolTipText("Click to paint the backgroud with selected color");
		ImageIcon paintCanIcon = new ImageIcon("paintCanIcon.png");
		// Resize the image to fit the button
		Image paintCanImg = paintCanIcon.getImage();  
	    resizedImage = paintCanImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    paintCanIcon= new ImageIcon(resizedImage);
		paintCanBtn.setIcon(paintCanIcon);
		
		// Format the selectColor Button 
		selectColorBtn = new ToolBarButton();
		selectColorBtn.addActionListener(this);
		currentColorDisplay = new JPanel();
		currentColorDisplay.setSize(new Dimension(40,40));
		currentColorDisplay.setBackground(picture.getCurrentColor());
		selectColorBtn.add(currentColorDisplay);
		selectColorBtn.setToolTipText("Click select a color to use");
		
		// Add all of the buttons and other J Components to the toolBar
		this.add(circleBtn);
		this.add(triangleBtn);
		this.add(rectangleBtn);
		this.add(lineBtn);
		this.add(penBtn);
		this.add(eraserBtn);
		this.add(thicknessMenu);
		this.add(paintCanBtn);
		this.add(selectColorBtn);
		this.add(exportBtn);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==thicknessMenu) {
			// Changes the current thickness which will be used for every shape and the eraser
			if(thicknessMenu.getSelectedIndex()==0) {
				picture.setCurrentWidth(5);
			}
			else if(thicknessMenu.getSelectedIndex()==1) {
				picture.setCurrentWidth(10);
			}
			else if(thicknessMenu.getSelectedIndex()==2) {
				picture.setCurrentWidth(15);
			}
			else if(thicknessMenu.getSelectedIndex()==3) {
				picture.setCurrentWidth(20);
			}
			else if(thicknessMenu.getSelectedIndex()==4) {
				picture.setCurrentWidth(25);
			}
			
		}
		else if (e.getSource()==selectColorBtn) {
			// Gets Color from user input and sets the currentColor equal to that color
			Color color = JColorChooser.showDialog(this,
                    "Select a color", picture.getCurrentColor());
			picture.setCurrentColor(color);
			currentColorDisplay.setBackground(color);
		} else {
			
			// Deselect all tools
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			penBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
			
			if(e.getSource()==circleBtn) {
				// Set the currentTool to CIRCLE
				picture.setCurrentTool(ToolOpt.CIRCLE);
				// Highlight the border of the selected tool 
				circleBtn.setBorderPainted(true);
			}
			else if (e.getSource()== rectangleBtn) {
				// Set the currentTool to RECTANGLE
				picture.setCurrentTool(ToolOpt.RECTANGLE);
				// Highlight the border of the selected tool 
				rectangleBtn.setBorderPainted(true);
			}
			else if (e.getSource()== triangleBtn) {
				// Set the currentTool to TRIANGLE
				picture.setCurrentTool(ToolOpt.TRIANGLE);
				// Highlight the border of the selected tool 
				triangleBtn.setBorderPainted(true);
			}
			else if (e.getSource()== lineBtn) {
				// Set the currentTool to LINE
				picture.setCurrentTool(ToolOpt.LINE);
				// Highlight the border of the selected tool 
				lineBtn.setBorderPainted(true);
			}
			else if (e.getSource()== eraserBtn) {
				// Set the currentTool to ERASER
				picture.setCurrentTool(ToolOpt.ERASER);
				// Highlight the border of the selected tool 
				eraserBtn.setBorderPainted(true);
			}
			else if (e.getSource()== exportBtn) {
				// Call the export function in the Picture class 
				picture.export();
			}
			else if (e.getSource()== paintCanBtn) {
				// Set the currentTool to PAINTCAN
				picture.setCurrentTool(ToolOpt.PAINTCAN);
				// Highlight the border of the selected tool 
				paintCanBtn.setBorderPainted(true);
			}
			else if (e.getSource()== penBtn) {
				// Set the currentTool to PEN
				picture.setCurrentTool(ToolOpt.PEN);
				// Highlight the border of the selected tool
				penBtn.setBorderPainted(true);
			}
		}
	}
	
	
}
