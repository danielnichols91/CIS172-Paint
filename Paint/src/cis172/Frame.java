package cis172.Paint;

import java.awt.Dimension;
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
			
			
	}

		
	public static Picture getPicture() {
		return picture;
	}
	



}
