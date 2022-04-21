package testingPaint;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import cis172.Picture;
import cis172.ToolBar;
import cis172.Picture.ToolOpt;

class TestingToolBarTriangleBtnClick {

	@Test
	void test() {
		
		// Setup testing situation
		Picture picture = new Picture();
		picture.setBackground(Color.white);
		ToolBar toolBar = new ToolBar(picture); 
		
		// Press button
		toolBar.getTriangleBtn().doClick(); 
		// Check if the behavior is expected
		assert(Picture.getCurrentTool()==ToolOpt.TRIANGLE);
		
	}

}
