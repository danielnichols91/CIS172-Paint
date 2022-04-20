package testingPaint;

import org.junit.jupiter.api.Test;
import cis172.Picture;
import java.awt.Color;

class TestingSecondPictureConstructor {

	@Test
	void test() {
		Picture picture = new Picture(Color.green, 20); 
		assert(picture.getCurrentWidth()==20);
		assert(picture.getCurrentColor() == Color.green); 
		assert(picture.getShapes()!=null); 
	}

}