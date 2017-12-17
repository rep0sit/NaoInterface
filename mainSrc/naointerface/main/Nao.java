package naointerface.main;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;

/**
 * 
 * A NAO Object is an interface to a real or virtual Nao robot in the network.<br>
 * It provides a set of easy-to-use methods to control the robot.
 * 
 * @author Etienne Onasch
 * @author Nelli Welker
 *
 */
public interface Nao {
	/**
	 * This is needed for example if you want to expand the funcionality with the JNaoQi.
	 * @return the session of the NAO instance. <br>
	 * 
	 */
	public Session getSession();
	/**
	 * This is needed for example if you want to expand the funcionality with the JNaoQi.
	 * @return the ALMotion module of the NAO instance. <br>
	 * 
	 */
	public ALMotion getMotionModule();
	/**
	 * This method returns the IP Adress of the NAO robot.
	 * @return the IP as a String.
	 */
	public String getIp();
	/**
	 * This method returns the port of the NAO robot.
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
     * @param mod the new speed modification 
     */
    public void setSpeedMod(double mod);
    /**
     * 
     * @return the current speed modification.
     */
    public double getSpeedMod();
    /**
     * Returns the current Volume of NAO's TextToSpeech Module.<br>
     * It can be a value between 0.0 and 1.0.
     * @return the current volume
     */
    public double getVolume();
    /**
     * Sets the volume of NAO's TextToSpeech Module.<br>
     * The intput value of the parameter vol is normalized to the interval (0.0...1.0).
     * @param vol the volume for NAO's TextToSpeech Engine.
     */
    public void setVolume(double vol);
	/**
	 * Returns the URL of the Robot as a String.<br>
	 * The Format is: <br>
	 * tcp//{IP-ADDRESS}:{PORT} 
	 * @return the URL of this NAO Object as a String.
	 */
    public String getUrl();
	
	/**
	 * The NAO speaks given text.
	 * @param text the text which NAO will speak
	 */
    public void say(String text);
	/**
	 * 
	 * The NAO shows "Scissors" and speaks the given text. 
	 * @param text the text which NAO will speak
	 */
    public void showScissors(String text);
	/**
	 * The NAO shows "Rock" and speaks the given text.
	 * @param text the text which NAO will speak
	 */
    public void showRock(String text);
	/**
	 *The NAO shows "paper" and speaks the given text.
	 * @param text the text which NAO will speak
	 */
    public void showPaper(String text);
	/**
	 * The NAO shows a greeting gesture and speaks the given text.
	 * @param text the text which NAO will speak
	 */
    public void greet(String text);
	
	/**
	 * The NAO makes a happy gesture and speaks the given text.
	 * @param text the text which NAO will speak
	 */
    public void happy(String text);
	/**
	 *The NAO makes a sad gesture and speaks the given text.
	 * @param text the text which NAO will speak
	 */
    public void sad(String text);
	/**
	 * Returs a SpeechRecognition module.
	 * @return a SpeechRecognition module.
	 */
	public SpeechRecognition getSpeechRecognition();
	/**
	 * A method that let the Nao Robot stand up and go to <br>
	 * the Initial pose. <br>
	 * 
	 */
	public void standUp();
	/**
	 * This method opens the right hand of the Nao Robot.
	 */
	public void openRightHand();
	/**
	 * This method closes the right hand of the Nao Robot.
	 */
	public void closeRightHand();
	/**
	 * This method opens the left hand of the Nao Robot.
	 */
	public void openLeftHand();
	/**
	 * This method closes the left hand of the Nao Robot.
	 */
	public void closeLeftHand();
	/**
	 * This method closes both hands of the Nao Robot.
	 */
	public void closeBothHands();
	/**
	 * This method opens both hands of the Nao Robot.
	 */
	public void openBothHands();
	/**
	 * The nao instance will apply all the instances of Move in the <br>
	 * varArgs list simultanously.<br>
	 * This method will interpret the angles of the instances of Move <br>
	 * as absolute positions.
	 * @param moves the varArgs list of instances of Move.
	 */
	public void moveAbsolute(Move...moves);
	/**
	 * The nao instance will apply all the instances of Move in the <br>
	 * varArgs list simultanously.<br>
	 * This method will interpret the angles of the instances of Move <br>
	 * as relative positions.
	 * @param moves the varArgs list of instances of Move.
	 */
	public void moveRelative(Move...moves);
}
