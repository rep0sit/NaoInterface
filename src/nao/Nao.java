package nao;
/**
 * Ein Nao Objekt stellt eine Schnittstelle zu einem Nao Roboter dar.
 * An diesem Objekt können verschiedene Methoden ausgeführt werden,
 * die dann von einem Nao Roboter im Netzwerk ausgeführt werden.
 * Ein Nao Objekt wird über die Klasse NaoFactory erzeugt.
 * @author multipass
 *
 */
public interface Nao {
	/**
	 * 
	 * @return the current language of the Nao Object 
	 * as a String
	 */
	String getLanguage();
	/**
	 * Stellt die Sprache für dieses Nao-Objekt ein.
	 * @param language
	 */
	void setLanguage(String language);
	/**
	 * Alle Motoren in die 0-Position.
	 */
	void standZero(float maxSpeedFraction);
	/**
	 * Initialer Stand. Nao kann von 
	 * dieser Pose aus alles tun.
	 */
	void standInit(float maxSpeedFraction);
	/**
	 * Pose mit geringem Energieverbrauch.
	 */
	void stand(float maxSpeedFraction);
	
	
	/**
	 * Der Nao Roboter spricht einen Text.
	 * @param text
	 */
	void say(String text);
	/**
	 * Der Nao Roboter zeigt "Schere" und
	 * spricht einen Text
	 * @param text
	 */
	void showScissors(String text);
	/**
	 * Der Nao Roboter zeigt "Stein" und
	 * spricht einen Text
	 * @param text
	 */
	void showStone(String text);
	/**
	 * Der Nao Roboter zeigt "Papier" und
	 * spricht einen Text
	 * @param text
	 */
	void showPaper(String text);
	/**
	 * Der Nao Roboter macht eine begrüßende
	 * Bewegung und spricht einen Text
	 * @param text
	 */
	void greet(String text);
	
	/**
	 * Der Roboter jubelt und spricht einen
	 * Text
	 * @param text
	 */
	void happy(String text);
	/**
	 * Der Roboter zeigt eine traurige Emotion
	 * und spricht einen Text
	 * @param text
	 */
	void sad(String text);
}
