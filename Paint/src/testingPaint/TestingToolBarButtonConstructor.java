package testingPaint;

import org.junit.jupiter.api.Test;
import cis172.ToolBarButton;

class TestingToolBarButtonConstructor {

	@Test
	void test() { 
		// Create a new ToolBarButton
		ToolBarButton btn = new ToolBarButton(); 
		// Check if the border is not painted and if the preferred size is the expected value
		assert(btn.isBorderPainted()==false); 
		assert(btn.getPreferredSize() != null);
		assert(btn.getBorder()!=null);
	}

}
