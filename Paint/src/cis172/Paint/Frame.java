package cis172.Paint;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;

public class Frame extends JFrame {
	
	public Frame() {
		this.setTitle("Paint");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.setLayout(new BorderLayout());
		ImageIcon logo = new ImageIcon("paintBrush.png");
		this.setIconImage(logo.getImage()); 
		
		ToolBar toolBar = new ToolBar();
		toolBar.setPreferredSize(new Dimension(800, 100));
		toolBar.setBackground(Color.lightGray);
		this.add(toolBar,BorderLayout.NORTH);
		
		Picture picture = new Picture();
		picture.setBackground(Color.white);
		this.add(picture,BorderLayout.CENTER);
		
		this.setVisible(true);
		
		
	}




}
