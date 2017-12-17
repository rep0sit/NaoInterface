package naointerface.main;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class BodyPartsMovesTest {

	@Test
	public void test() {
		List<String> bodyPartsList = BodyParts.BODY_PARTS;
		
		List<String> legalBodyPartsList = BodyParts.SUPPORTED_BODY_PARTS;
		
//		System.out.println("BodyParts list size : " + bodyPartsList.size());
//		System.out.println("Legal BodyParts list size : " + legalBodyPartsList.size());
		
		assertTrue(legalBodyPartsList.size() < bodyPartsList.size());
		
	}

}
