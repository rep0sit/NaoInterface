package naointerface.main;

import com.aldebaran.qi.Session;

import speech.main.SpeechRecognition;

/**
 * Ein Nao Objekt stellt eine Schnittstelle zu einem Nao Roboter dar.
 * An diesem Objekt können verschiedene Methoden ausgeführt werden,
 * die dann von einem Nao Roboter im Netzwerk ausgeführt werden.
 * Ein Nao Objekt wird über die Klasse NaoFactory erzeugt.
 * @author Etienne Onasch
 * @author Nelli Welker
 *
 */
public interface Nao {
	/**
	 * 
	 * @return the session of the NAO instance.
	 */
	public Session getSession();
	
	
	/**
	 * 
	 * @return the IP as a String.
	 */
	public String getIp();
	/**
	 * 
	 * @return the port as an int.
	 */
    public int getPort();
    /**
     * A multiplier for NAO's movement speed.<br>
     * Due to safety measures the input value for the parameter mult is normalized <br> 
     * to the interval (0.5...1.5).<br><br>
     * 
     * The standard speed for applying stances is currently 50% of maxSpeed.<br>
     * So with the multiplier it can modified to an absolute value <br> from <br>
     * 50% * 0.5 = 25% maxSpeed<br>to<br>
     * 50% * 1.5 = 75% maxSpeed.<br><br>
     * 
     * The current time for an limb (Motor) of the NAO to move into a new position <br>is 1.0 seconds.<br> 
     * 
     * So with the multiplier it can be modified to an absolute value <br> from <br>
     * 
     * 1.0 / 0.5 = 2 seconds (slow) <br>to<br>
     * 1.0 / 1.5 = 0.666.. seconds (fast).
     * 
     * @param mult
     */
    public void setSpeedMod(double mult);
    /**
     * 
     * @return the current SpeedMultiplier.
     */
    public double getSpeedMod();
    /**
     * Returns the current Volume of NAO's TextToSpeech Module.<br>
     * It can be a value between 0.0 and 1.0.
     * @return
     */
    public double getVolume();
    /**
     * Sets the volume of NAO's TextToSpeech Module.<br>
     * The intput value of the parameter vol is normalized to the interval (0.0...1.0).
     * @param vol
     */
    public void setVolume(double vol);
	/**
	 * Returns the URL of the Robot as a String.<br>
	 * The Format is: <br>
	 * tcp//{IP-ADDRESS}:{PORT} 
	 * @return
	 */
    public String getUrl();
	
	/**
	 * Der Nao Roboter spricht einen Text.
	 * @param text
	 */
    public void say(String text);
	/**
	 * Der Nao Roboter zeigt "Schere" und
	 * spricht einen Text
	 * @param text
	 */
    public void showScissors(String text);
	/**
	 * Der Nao Roboter zeigt "Stein" und
	 * spricht einen Text
	 * @param text
	 */
    public void showRock(String text);
	/**
	 * Der Nao Roboter zeigt "Papier" und
	 * spricht einen Text
	 * @param text
	 */
    public void showPaper(String text);
	/**
	 * Der Nao Roboter macht eine begrüßende
	 * Bewegung und spricht einen Text
	 * @param text
	 */
    public void greet(String text);
	
	/**
	 * Der Roboter jubelt und spricht einen
	 * Text
	 * @param text
	 */
    public void happy(String text);
	/**
	 * Der Roboter zeigt eine traurige Emotion
	 * und spricht einen Text
	 * @param text
	 */
    public void sad(String text);
	/**
	 * 
	 * @return a SpeechRecognition module.
	 */
	public SpeechRecognition getSpechRecognition();
}
