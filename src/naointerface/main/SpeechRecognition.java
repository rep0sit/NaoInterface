package naointerface.main;

import java.util.Collection;
import java.util.Set;
/**
 * 
 * @author Etienne Onasch
 * @author Nelli Welker
 */
public interface SpeechRecognition {
	/**
	 * adds new vocabulary to this Speechrecognition module.<br>
	 * Every String that contains {@code " "} will be splitted.
	 * @param voca
	 */
	public void addVocabulary(Collection<String> voca);
	/**
	 * adds new vocabulary to this Speechrecognition module.
	 * Every String that contains {@code " "} will be splitted.
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
	
	
	/**
	 * This method starts a recording session for a single word!<br>
	 * The word must be in the vocabulary list {@code getVocabulary()}.<br>
	 * The {@code (int seconds)} parameter determines how long the module <br>
	 * is listening to the user.<br>
	 * The parameter will be normalized to the interval (0,1,...,9,10).<br>
	 * It returns a word from the vocabulary that matches with <br>
	 * the highest probability.
	 * @param seconds
	 * @return
	 */
	public String recordWord(int seconds);
	
}
