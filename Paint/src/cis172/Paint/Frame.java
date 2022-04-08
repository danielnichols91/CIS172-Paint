package cis172.Paint;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import cis172.Paint.Picture.ToolOpt;

import java.awt.Color;

public class Frame extends JFrame {
	
	private static Picture picture; 
	
	public Frame() {
		// Format the Frame or window itself
		this.setTitle("Paint");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.setLayout(new BorderLayout());
		ImageIcon logo = new ImageIcon("paintBrush.png");
		this.setIconImage(logo.getImage()); 
		
		// Declare an instance of Picture and format it
		picture = new Picture();
		picture.setBackground(Color.white);
		this.add(picture,BorderLayout.CENTER);
		
		// Declare an instance of ToolBar and format it
		ToolBar toolBar = new ToolBar();
		toolBar.setPreferredSize(new Dimension(800, 100));
		toolBar.setBackground(Color.lightGray);
		this.add(toolBar,BorderLayout.NORTH);
		
		// Set the visibility to true
		this.setVisible(true);
		
		
		// Determining what shape is being drawn
		// Note: I haven't (as of yet) figured out how this piece of code to reupdate 
		// each time the user does an action, so the only way for the draw to work
		// would be to change the if statement condition to null instead of ToolOpt
		// Note: Also, I'm going to fix the draw statement later
		
		if (picture.getCurrentTool() == ToolOpt.RECTANGLE) { 
			Rectangle r1 = new Rectangle();
			
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					r1.setX(e.getX());
					r1.setY(e.getY());
					
				}
				
				public void mouseReleased(MouseEvent e) {
					r1.setWidth(e.getX() - r1.getX());
					r1.setHeight(e.getY() - r1.getY());
					
					picture.getShapes().add(r1);
					r1.draw(getGraphics());
					
				}
				
			});
			
			
		} else if (picture.getCurrentTool() == ToolOpt.CIRCLE) { 
			Circle c1 = new Circle();
			
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					c1.setX(e.getX());
					c1.setY(e.getY());
					
				}
				
				public void mouseReleased(MouseEvent e) {
					c1.setWidth(e.getX() - c1.getX());
					c1.setHeight(e.getY() - c1.getY());
					
					picture.getShapes().add(c1);
					c1.draw(getGraphics());
					
				}
				
			});
			
			
		}
			
			
	}

		
	public static Picture getPicture() {
		return picture;
	}
	



}
