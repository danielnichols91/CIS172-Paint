package testingPaint;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import cis172.Paint.Picture;
import cis172.Paint.ToolBar;
import cis172.Paint.Picture.ToolOpt;

class testingToolBarRectangleBtnClick {

	@Test
	void test() throws Throwable {
		
		// Setup testing situation
		Picture picture = new Picture();
		picture.setBackground(Color.white);
		ToolBar toolBar = new ToolBar(picture); 
		
		// Press button
		toolBar.getRectangleBtn().doClick(); 
		// Check if the behavior is expected
		assert(Picture.getCurrentTool()==ToolOpt.RECTANGLE);
		
	}

}
