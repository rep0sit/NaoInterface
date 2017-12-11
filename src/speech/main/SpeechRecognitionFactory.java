package speech.main;

import com.aldebaran.qi.Session;

public final class SpeechRecognitionFactory {
	private SpeechRecognitionFactory() {}
	
	public static SpeechRecognition getSpeechRecognition(Session session) {
		return new SpeechRecognitionImpl(session);
	}
}
