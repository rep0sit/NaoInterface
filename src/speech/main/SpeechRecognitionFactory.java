package speech.main;

import com.aldebaran.qi.Session;
/**
 * A Factory Class for Speech Recognition modules.
 *
 *
 */
public final class SpeechRecognitionFactory {
	private SpeechRecognitionFactory() {}
	
	public static SpeechRecognition getSpeechRecognition(Session session) {
		return new SpeechRecognitionImpl(session);
	}
}
