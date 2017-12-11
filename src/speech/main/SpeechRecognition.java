package speech.main;

import java.util.Collection;
import java.util.Set;

public interface SpeechRecognition {
	/**
	 * adds new vocabulary to this Speechrecognition module.<br>
	 * Every String that contains " " will be splitted.
	 * @param voca
	 */
	public void addVocabulary(Collection<String> voca);
	/**
	 * adds new vocabulary to this Speechrecognition module.
	 * Every String that contains " " will be splitted.
	 * @param voca
	 */
	public void addVocabulary(String...vocas);
	
	/**
	 * Returns a set of the vocabulary.
	 * @return
	 */
	Set<String> getVocabulary();
	
	/**
	 * Deletes the vocabulary of this instance of Speech Recognition.
	 */
	public void clearVocabulary();
	
	
}
