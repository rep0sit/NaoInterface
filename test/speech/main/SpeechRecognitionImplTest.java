package speech.main;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class SpeechRecognitionImplTest {
	
	@Test
	public void testSpeechRecognitionImpl() {
		SpeechRecognition sr = SpeechRecognitionFactory.getSpeechRecognition(null);
		
		assertTrue(sr != null);
		
	}

	@Test
	public void testAddVocabularyCollectionOfString() {
		
		SpeechRecognition sr = SpeechRecognitionFactory.getSpeechRecognition(null);
		List<String> sList = Arrays.asList("qraf", "Haunted House", "wurst");
		
		sr.addVocabulary(sList);
		assertTrue(sr.getVocabulary().size() == 4);
		System.out.println(sr);
	}

	@Test
	public void testAddVocabularyStringArray() {
		SpeechRecognition sr = SpeechRecognitionFactory.getSpeechRecognition(null);
		String[] sAry = {"qraf", "Haunted House", "wurst", "5"};
		
		sr.addVocabulary(sAry);
		assertTrue(sr.getVocabulary().size() == 5);
		
		System.out.println(sr);
	}

	@Test
	public void testGetVocabulary() {
		SpeechRecognition sr = SpeechRecognitionFactory.getSpeechRecognition(null);
		String[] sAry = {"qraf", "Haunted House", "wurst", "5"};
		
		sr.addVocabulary(sAry);
		
		
		assertTrue(sr.getVocabulary().getClass() == HashSet.class);
		assertTrue(!sr.getVocabulary().isEmpty());
		
		
	}
	
	@Test
	public void testClearVocabulary() {
		SpeechRecognition sr = SpeechRecognitionFactory.getSpeechRecognition(null);
		String[] sAry = {"qraf", "Haunted House", "wurst", "5"};
		
		sr.addVocabulary(sAry);
		
		sr.clearVocabulary();
		assertTrue(sr.getVocabulary().getClass() == HashSet.class);
		assertTrue(sr.getVocabulary().isEmpty());
		
	}

}
