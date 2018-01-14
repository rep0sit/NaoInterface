package naointerface.main;

import java.util.ArrayList;
import java.util.List;


import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
/**
 * This class provides methods which can combine multiple
 * instances of {@code naointerface.main.Move} to create motions.
 * @author Nelli Welker
 * @author Etienne Onasch
 *
 */
final class Moves {
	private Moves() {}
	
	/**
	 * 
	 * A movement of actuators and/or motors with endpositions relatively to the ZERO-Position.
	 * All instances of the type {@code naointerface.main.Move} are applied simultanously.
	 * 
	 * @param session the session of the Nao Instance
	 * @param motion the instance of ALMotion of the Nao Instance
	 * @param moves varArgs for a number of Move instances
	 */
	public static void moveAbsolute(Session session, ALMotion motion, Move...moves) {
		move(session, motion, true, moves);
	}
	
	/**
	 * A movement of actuators and/or motors with endpositions relatively to the current position.
	 * All instances of the type {@code naointerface.main.Move} are applied simultanously.
	 * @param session the session of the Nao Instance
	 * @param motion the instance of ALMotion of the Nao Instance
	 * @param moves varArgs for a number of Move instances
	 */
	public static void moveRelative(Session session, ALMotion motion, Move...moves) {
		move(session, motion, false, moves);
	}
	
	/**
	 * 
	 * @param session the session of the Nao Instance
	 * @param motion the instance of ALMotion of the Nao Instance
	 * @param absolute determines if the angle interpolations of the bodyparts should be executed 
	 * relatively to the current position (false) or relatively to their Zero-Position (true).
	 * @param moves varArgs for a number of Move instances
	 */
	private static void move(Session session, ALMotion motion, boolean absolute, Move...moves){
		
		try {
			motion = new ALMotion(session);
			
			List<String> names = new ArrayList<>();
			List<Double> angles = new ArrayList<>();
			List<Double> times = new ArrayList<>();
			
			
			for(Move m : moves) {
				names.add(m.getBodyPart());
				angles.add(m.getAngleRadans());
				times.add(m.getTime());
			}
			
			motion.angleInterpolation(names, angles, times, true);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
