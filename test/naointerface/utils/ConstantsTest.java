package naointerface.utils;

import static org.junit.Assert.*;
import static naointerface.utils.Constants.*;

import org.junit.Test;

public class ConstantsTest {

	@Test
	public void testSetSpeedMod() {
		Constants.setSpeedMod(2000.0);
		assertEquals(1.5, Constants.getSpeedMod(), EPSILON);
		Constants.setSpeedMod(-2000.0);
		assertEquals(.5, Constants.getSpeedMod(), EPSILON);
	}

	@Test
	public void testGetSpeedMod() {
		Constants.setSpeedMod(1.0);
		assertEquals(1.0, Constants.getSpeedMod(), EPSILON);
	}

	@Test
	public void testNormalize() {
		assertEquals(normalize(-10.0, -3.0, -1.0), -3.0, EPSILON);
		assertEquals(normalize(-10.0, -1.0, -3.0), -3.0, EPSILON);
	}

}
