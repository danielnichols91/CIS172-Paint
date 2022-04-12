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

	// Define all of the components for the toolBar
	private JButton circleBtn;
	private JButton triangleBtn;
	private JButton rectangleBtn;
	private JButton lineBtn;
	private JButton eraserBtn;
	private JButton exportBtn;
	private JComboBox thicknessMenu;
	private JButton paintCanBtn;
	private JButton selectColorBtn;
	private JPanel currentColorDisplay;
	
	public ToolBar() {
		// Format the circle button 
		circleBtn = new JButton();
		circleBtn.setPreferredSize(new Dimension(50,50));
		circleBtn.addActionListener(this);
		ImageIcon circleIcon = new ImageIcon("circleIcon.png"); 
		circleBtn.setToolTipText("Click and drag to draw a circle");
		// Resize the image to fit the button
		Image circleImg = circleIcon.getImage();  
	    Image resizedImage = circleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    circleIcon= new ImageIcon(resizedImage);
		circleBtn.setIcon(circleIcon);
		circleBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		circleBtn.setBorderPainted(false);
		
		// Format the triangle button
		triangleBtn = new JButton();
		triangleBtn.setPreferredSize(new Dimension(50,50));
		triangleBtn.addActionListener(this);
		ImageIcon triangleIcon = new ImageIcon("triangleIcon.png"); 
		triangleBtn.setToolTipText("Click and drag to draw a triangle");
		// Resize the image to fit the button
		Image triangleImg = triangleIcon.getImage();  
	    resizedImage = triangleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    triangleIcon= new ImageIcon(resizedImage);
		triangleBtn.setIcon(triangleIcon);
		triangleBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		triangleBtn.setBorderPainted(false);
		
		// Format the rectangle button
		rectangleBtn = new JButton();
		rectangleBtn.setPreferredSize(new Dimension(50,50));
		rectangleBtn.addActionListener(this);
		rectangleBtn.setToolTipText("Click and drag to draw a rectangle");
		ImageIcon rectangleIcon = new ImageIcon("rectangleIcon.png");
		// Resize the image to fit the button
		Image rectangleImg = rectangleIcon.getImage();  
	    resizedImage = rectangleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    rectangleIcon= new ImageIcon(resizedImage);
		rectangleBtn.setIcon(rectangleIcon);
		rectangleBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		rectangleBtn.setBorderPainted(false);
		
		// Format the line button
		lineBtn = new JButton();
		lineBtn.setPreferredSize(new Dimension(50,50));
		lineBtn.addActionListener(this);
		lineBtn.setToolTipText("Click and drag to draw a line");
		ImageIcon lineIcon = new ImageIcon("lineIcon.png");
		// Resize the image to fit the button
		Image lineImg = lineIcon.getImage();  
	    resizedImage = lineImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    lineIcon= new ImageIcon(resizedImage);
		lineBtn.setIcon(lineIcon);
		lineBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		lineBtn.setBorderPainted(false);
		
		// Format the eraser button
		eraserBtn = new JButton();
		eraserBtn.setPreferredSize(new Dimension(50,50));
		eraserBtn.addActionListener(this);
		eraserBtn.setToolTipText("Click and drag to erase");
		ImageIcon eraserIcon = new ImageIcon("eraserIcon.png");
		// Resize the image to fit the button
		Image eraserImg = eraserIcon.getImage();  
	    resizedImage = eraserImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    eraserIcon= new ImageIcon(resizedImage);
		eraserBtn.setIcon(eraserIcon);
		eraserBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		eraserBtn.setBorderPainted(false);
		
		// Format the export button
		exportBtn = new JButton();
		exportBtn.setPreferredSize(new Dimension(50,50));
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
		paintCanBtn = new JButton();
		paintCanBtn.setPreferredSize(new Dimension(50,50));
		paintCanBtn.addActionListener(this);
		paintCanBtn.setToolTipText("Click to fill any shape with selected color");
		ImageIcon paintCanIcon = new ImageIcon("paintCanIcon.png");
		// Resize the image to fit the button
		Image paintCanImg = paintCanIcon.getImage();  
	    resizedImage = paintCanImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    paintCanIcon= new ImageIcon(resizedImage);
		paintCanBtn.setIcon(paintCanIcon);
		paintCanBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		paintCanBtn.setBorderPainted(false);
		
		// Format the selectColor Button 
		selectColorBtn = new JButton();
		selectColorBtn.setPreferredSize(new Dimension(50,50));
		selectColorBtn.addActionListener(this);
		currentColorDisplay = new JPanel();
		currentColorDisplay.setSize(new Dimension(40,40));
		currentColorDisplay.setBackground(Frame.getPicture().getCurrentColor());
		selectColorBtn.add(currentColorDisplay);
		selectColorBtn.setToolTipText("Click select a color to use");
		
		// Add all of the buttons and other J Components to the toolBar
		this.add(circleBtn);
		this.add(triangleBtn);
		this.add(rectangleBtn);
		this.add(lineBtn);
		this.add(eraserBtn);
		this.add(thicknessMenu);
		this.add(paintCanBtn);
		this.add(selectColorBtn);
		this.add(exportBtn);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==circleBtn) {
			// Set the currentTool to CIRCLE
			Frame.getPicture().setCurrentTool(ToolOpt.CIRCLE);
			Frame.getPicture().chooseTool();
			// Highlight the border of the selected tool 
			circleBtn.setBorderPainted(true);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== rectangleBtn) {
			// Set the currentTool to RECTANGLE
			Frame.getPicture().setCurrentTool(ToolOpt.RECTANGLE);
			Frame.getPicture().chooseTool();
			// Highlight the border of the selected tool 
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(true);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== triangleBtn) {
			// Set the currentTool to TRIANGLE
			Frame.getPicture().setCurrentTool(ToolOpt.TRIANGLE);
			Frame.getPicture().chooseTool();
			// Highlight the border of the selected tool 
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(true);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== lineBtn) {
			// Set the currentTool to LINE
			Frame.getPicture().setCurrentTool(ToolOpt.LINE);
			Frame.getPicture().chooseTool();
			// Highlight the border of the selected tool 
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(true);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== eraserBtn) {
			// Set the currentTool to ERASER
			Frame.getPicture().setCurrentTool(ToolOpt.ERASER);
			Frame.getPicture().chooseTool();
			// Highlight the border of the selected tool 
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(true);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== exportBtn) {
			// Call the export function in the Picture class 
			Frame.getPicture().export();
		}
		else if (e.getSource()== paintCanBtn) {
			// Set the currentTool to PAINTCAN
			Frame.getPicture().setCurrentTool(ToolOpt.PAINTCAN);
			Frame.getPicture().chooseTool();
			// Highlight the border of the selected tool 
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(true);
		}
		else if (e.getSource()==thicknessMenu) {
			// Changes the current thickness which will be used for every shape and the eraser
			if(thicknessMenu.getSelectedIndex()==0) {
				Frame.getPicture().setCurrentWidth(5);
			}
			else if(thicknessMenu.getSelectedIndex()==1) {
				Frame.getPicture().setCurrentWidth(10);
			}
			else if(thicknessMenu.getSelectedIndex()==2) {
				Frame.getPicture().setCurrentWidth(15);
			}
			else if(thicknessMenu.getSelectedIndex()==3) {
				Frame.getPicture().setCurrentWidth(20);
			}
			else if(thicknessMenu.getSelectedIndex()==4) {
				Frame.getPicture().setCurrentWidth(25);
			}
			
		}
		else if (e.getSource()==selectColorBtn) {
			// Gets Color from user input and sets the currentColor equal to that color
			Color color = JColorChooser.showDialog(this,
                    "Select a color", Frame.getPicture().getCurrentColor());
			Frame.getPicture().setCurrentColor(color);
			currentColorDisplay.setBackground(color);
		}
		
		
	}
	
	
}
