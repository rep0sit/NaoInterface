package naointerface.main;

import com.aldebaran.qi.Session;
/**
 * A Factory Class for Speech Recognition modules.
 *
 *
 */
final class SpeechRecognitionFactory {
	private SpeechRecognitionFactory() {}
	
	private static SpeechRecognition SPEECH_RECOG = null;
	/**
	 * This will return a singleton object!
	 * @param session the current session you are working with.
	 * @return a singleton SpeechRecognitionImpl object.
	 */
	static SpeechRecognition getSpeechRecognition(Session session) {
		
		if (SPEECH_RECOG == null) {
			SPEECH_RECOG = new SpeechRecognitionImpl(session);
		}
		return SPEECH_RECOG;
		
		
	}
	
	
}
