package naointerface.utils;

import static naointerface.utils.Constants.*;

/**
 * Eine Klasse für eine einfache, 
 * lineare Bewegung.
 * 
 * @author Nelli Welker, Etienne Onasch
 *
 */
public class Move {
	private final String bodyPart;
	private final double angle;
	private final double time;
	
	public Move(String bodyPart, double angle) {
		this(bodyPart, angle, 
				getSpeedMod() != 0.0 ? STANDARD_MOVING_TIME / getSpeedMod() : STANDARD_MOVING_TIME);
		
	}
	
	public Move(String bodyPart, double angle, double time) {
		this.bodyPart = bodyPart;
		this.angle = angle;
		this.time = time;
	}


	public String getBodyPart() {
		return bodyPart;
	}


	public double getAngleRadans() {
		return Math.toRadians(angle);
	}


	public double getTime() {
		return time;
	}
	
	
	
}
