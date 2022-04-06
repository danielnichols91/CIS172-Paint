package cis172.Paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Image; 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener{

	private JButton circleBtn;
	private JButton triangleBtn;
	private JButton rectangleBtn;
	private JButton lineBtn;
	private JButton eraserBtn;
	private JButton exportBtn;
	private JComboBox thicknessMenu;
	private JButton paintCanBtn;
	
	public ToolBar() {
		//TODO: Format all the buttons and menus and add them to the ToolBar
		circleBtn = new JButton();
		circleBtn.setPreferredSize(new Dimension(50,50));
		circleBtn.addActionListener(this);
		ImageIcon circleIcon = new ImageIcon("circleIcon.png"); 
		circleBtn.setToolTipText("Click and drag to draw a circle");
		Image circleImg = circleIcon.getImage();  
	    Image resizedImage = circleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    circleIcon= new ImageIcon(resizedImage);
		circleBtn.setIcon(circleIcon);
		circleBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		circleBtn.setBorderPainted(false);
		
		triangleBtn = new JButton();
		triangleBtn.setPreferredSize(new Dimension(50,50));
		triangleBtn.addActionListener(this);
		ImageIcon triangleIcon = new ImageIcon("triangleIcon.png"); 
		triangleBtn.setToolTipText("Click and drag to draw a triangle");
		Image triangleImg = triangleIcon.getImage();  
	    resizedImage = triangleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    triangleIcon= new ImageIcon(resizedImage);
		triangleBtn.setIcon(triangleIcon);
		triangleBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		triangleBtn.setBorderPainted(false);
		
		rectangleBtn = new JButton();
		rectangleBtn.setPreferredSize(new Dimension(50,50));
		rectangleBtn.addActionListener(this);
		rectangleBtn.setToolTipText("Click and drag to draw a rectangle");
		ImageIcon rectangleIcon = new ImageIcon("rectangleIcon.png");
		Image rectangleImg = rectangleIcon.getImage();  
	    resizedImage = rectangleImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    rectangleIcon= new ImageIcon(resizedImage);
		rectangleBtn.setIcon(rectangleIcon);
		rectangleBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		rectangleBtn.setBorderPainted(false);
		
		lineBtn = new JButton();
		lineBtn.setPreferredSize(new Dimension(50,50));
		lineBtn.addActionListener(this);
		lineBtn.setToolTipText("Click and drag to draw a line");
		ImageIcon lineIcon = new ImageIcon("lineIcon.png");
		Image lineImg = lineIcon.getImage();  
	    resizedImage = lineImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    lineIcon= new ImageIcon(resizedImage);
		lineBtn.setIcon(lineIcon);
		lineBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		lineBtn.setBorderPainted(false);
		
		
		eraserBtn = new JButton();
		eraserBtn.setPreferredSize(new Dimension(50,50));
		eraserBtn.addActionListener(this);
		eraserBtn.setToolTipText("Click and drag to erase");
		ImageIcon eraserIcon = new ImageIcon("eraserIcon.png");
		Image eraserImg = eraserIcon.getImage();  
	    resizedImage = eraserImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    eraserIcon= new ImageIcon(resizedImage);
		eraserBtn.setIcon(eraserIcon);
		eraserBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		eraserBtn.setBorderPainted(false);
		
		exportBtn = new JButton();
		exportBtn.setPreferredSize(new Dimension(50,50));
		exportBtn.addActionListener(this);
		exportBtn.setToolTipText("Export your picture");
		ImageIcon exportIcon = new ImageIcon("exportIcon.png");
		Image exportImg = exportIcon.getImage();  
	    resizedImage = exportImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    exportIcon= new ImageIcon(resizedImage);
		exportBtn.setIcon(exportIcon);
		
		String[] thicknesses = {"5 px", "10 px", "15 px", "20 px", "25 px"};
		thicknessMenu = new JComboBox(thicknesses);
		thicknessMenu.addActionListener(this);
		thicknessMenu.setToolTipText("Select weight/thickness");
		
		paintCanBtn = new JButton();
		paintCanBtn.setPreferredSize(new Dimension(50,50));
		paintCanBtn.addActionListener(this);
		paintCanBtn.setToolTipText("Click to fill any shape with selected color");
		ImageIcon paintCanIcon = new ImageIcon("paintCanIcon.png");
		Image paintCanImg = paintCanIcon.getImage();  
	    resizedImage = paintCanImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    paintCanIcon= new ImageIcon(resizedImage);
		paintCanBtn.setIcon(paintCanIcon);
		paintCanBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		paintCanBtn.setBorderPainted(false);
		
		this.add(circleBtn);
		this.add(triangleBtn);
		this.add(rectangleBtn);
		this.add(lineBtn);
		this.add(eraserBtn);
		this.add(thicknessMenu);
		this.add(paintCanBtn);
		this.add(exportBtn);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==circleBtn) {
			//TODO:: event when button is clicked
			circleBtn.setBorderPainted(true);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== rectangleBtn) {
			//TODO:: event when button is clicked
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(true);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== triangleBtn) {
			//TODO:: event when button is clicked
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(true);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== lineBtn) {
			//TODO:: event when button is clicked
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(true);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== eraserBtn) {
			//TODO:: event when button is clicked
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(true);
			paintCanBtn.setBorderPainted(false);
		}
		else if (e.getSource()== exportBtn) {
			//TODO:: event when button is clicked
		}
		else if (e.getSource()== paintCanBtn) {
			//TODO:: event when button is clicked
			circleBtn.setBorderPainted(false);
			rectangleBtn.setBorderPainted(false);
			triangleBtn.setBorderPainted(false);
			lineBtn.setBorderPainted(false);
			eraserBtn.setBorderPainted(false);
			paintCanBtn.setBorderPainted(true);
		}
		else if (e.getSource()==thicknessMenu) {
			//TODO:: change current thickness which will be used for 
			//all the shapes and eraser
			//thicknessMenu.getSelectedItem(); 
			
		}
		
		
	}
	
	
}
