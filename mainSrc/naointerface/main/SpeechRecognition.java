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
	 * Every String that contains {@code " "} will be splitted! <br>
	 * If you want to be allowed to put whole phrases in the vocabulary, <br>
	 * invoke the method {@code phrasesAllowed(boolean allowed)}
	 * @param voca the vocabulary to be added
	 */
	public void addVocabulary(Collection<String> voca);
	/**
	 * adds new vocabulary to this Speechrecognition module.
	 * Every String that contains {@code " "} will be splitted!
	 * If you want to be allowed to put whole phrases in the vocabulary, <br>
	 * invoke the method {@code phrasesAllowed(boolean allowed)}
	 * @param vocas the vocabulary to be added
	 */
	public void addVocabulary(String...vocas);
	
	/**
	 * Returns a set of the vocabulary.
	 * @return the know vocabulary as a Set.
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
	 * the highest probability.<br>
	 * If the parameter {@code boolean prob} is true, <br>
	 * This method will return a whole sentence, that includes <br>
	 * the word plus the probability that this word matched the speech. <br>
	 * Otherwise it will just return the word with the highest probability. <br>
	 * If a word can't be detected, this method will return {@code null}.
	 * @param seconds the window of time for the user to speak.
	 * @param prob if this is true, this module will return a whole sentence with further infos
	 * @return The result as a String.
	 */
	public String recordWord(int seconds, boolean prob);
	
	/**
	 * This method determines if whole phrases are allowed as vocabulary or not.<br>
	 * If the parameter is true, phrases are allowed.<br>
	 * Per default phrases are not allowed.<br>
	 * This will not modify the vocabulary this instance of SpeechRecognition already knows!!<br>
	 * 
	 * @param allowed a boolean value that determins if whole phrases are allowed or not.
	 */
	public void phrasesAllowed (boolean allowed);
	
	
	
}
