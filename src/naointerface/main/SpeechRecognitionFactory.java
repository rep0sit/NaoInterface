package naointerface.main;

import com.aldebaran.qi.Session;
/**
 * A Factory Class for Speech Recognition modules.
 *
 *
 */
final class SpeechRecognitionFactory {
	private SpeechRecognitionFactory() {}
	
	static SpeechRecognition getSpeechRecognition(Session session) {
		return new SpeechRecognitionImpl(session);
	}
	
	
}
