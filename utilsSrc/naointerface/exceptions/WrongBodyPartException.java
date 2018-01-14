package naointerface.exceptions;
/**
 * 
 * This exception is written to be thrown whenever the constructor
 * of the class {@code naointerface.main.Move} is invoked with 
 * a {@code String} (parameter 'bodyPart') that isn't in the list
 * {@code naointerface.main.BodyParts.SUPPORTED_BODY_PARTS}.
 * @author Nelli Welker
 * @author Etienne Onasch
 *
 */
public class WrongBodyPartException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongBodyPartException() {
		super();
	}
	
	public WrongBodyPartException(String s) {
		super(s);
	}

}
