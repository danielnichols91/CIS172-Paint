package testingPaint;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import cis172.Picture;
import cis172.ToolBar;
import cis172.Picture.ToolOpt;

class TestingToolBarCircleBtnClick {

	@Test
	void test() throws Throwable{
		
		// Setup testing situation
		Picture picture = new Picture();
		picture.setBackground(Color.white);
		ToolBar toolBar = new ToolBar(picture); 
		
		// Press button
		toolBar.getCircleBtn().doClick(); 
		// Check if the behavior is expected
		assert(Picture.getCurrentTool()==ToolOpt.CIRCLE);
	}

}
