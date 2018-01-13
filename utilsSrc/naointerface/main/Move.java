package naointerface.main;

import static naointerface.main.Constants.STANDARD_MOVING_TIME;
import static naointerface.main.Constants.getSpeedMod;

import naointerface.exceptions.WrongBodyPartException;

/**
 * This class represents a single, linear move. <br>
 * It consists of a bodypart and an angle. <br>
 * 
 *
 * @author Nelli welker, Etienne onasch
 *
 */
public class Move {
	private final String bodyPart;
	private final double angle;
	private final double time;
	private static final double MIN_DEGREE = -360.0;
	private static final double MAX_DEGREE = -MIN_DEGREE;
	
	/**
	 * 
	 * @param bodyPart you can view the list of supported BodyParts <br>
	 * in naointerface.main.Moves.SUPPORTED_BODYPARTS."
	 * @param angle the angle in degree. <br> will be normalized to the interval (-360.0...360.0)
	 */
	public Move(String bodyPart, double angle){
		this(bodyPart, angle, 
				getSpeedMod() != 0.0 ? STANDARD_MOVING_TIME / getSpeedMod() : STANDARD_MOVING_TIME);
		
	}
	
	private Move(String bodyPart, double angle, double time){
		
		if(!BodyParts.SUPPORTED_BODY_PARTS.contains(bodyPart)) {
			try {
				throw new WrongBodyPartException("This BodyPart is not supported! You can get"
						+ " the supported BodyParts from the list naointerface.main.Moves.SUPPORTED_BODYPARTS.");
			} catch (WrongBodyPartException e) {
				System.out.println("Can't apply this move.");
			}
		}
		
		this.bodyPart = bodyPart;
		this.angle = Constants.normalize(angle, MIN_DEGREE, MAX_DEGREE);
		this.time = time;
	}

	/**
	 * Returns a String representation of this bodypart.<br>
	 * @return the bodypart.
	 */
	String getBodyPart() {
		return bodyPart;
	}

	/**
	 * Returns the angle of this move in radans.
	 * @return the angle in randans.
	 */
	double getAngleRadans() {
		return Math.toRadians(angle);
	}

	/**
	 * Returns the time of this Move.<br>
	 * If the time is 0.9 for example, <br>
	 * it means that the robot try to make this move in 0.9 seconds.
	 * @return the time in seconds
	 */
	double getTime() {
		return time;
	}
	
	
	
}
