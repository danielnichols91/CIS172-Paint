package cis172.Paint;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ToolBarButton extends JButton{
	public ToolBarButton() {
		setPreferredSize(new Dimension(50,50));
		setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		setBorderPainted(false);
	}
}
