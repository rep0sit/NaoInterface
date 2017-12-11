package speech.main;

import java.util.Collection;
import java.util.Set;

public interface SpeechRecognition {
	/**
	 * adds new vocabulary to this Speechrecognition module.
	 * @param voca
	 */
	void addVocabulary(Collection<String> voca);
	/**
	 * adds new vocabulary to this Speechrecognition module.
	 * @param voca
	 */
	void addVocabulary(String...vocas);
	
	/**
	 * Returns a set of the vocabulary.
	 * @return
	 */
	Set<String> getVocabulary();
	
	
}
