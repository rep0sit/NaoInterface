package naointerface.utils;

import java.util.ArrayList;
import java.util.List;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;

public final class Moves {
	private Moves() {}
	
	
	
	/**
	 * Eine Bewegung mehrerer Motoren mit Endpositionen relativ zur 0-Position.
	 * @param session
	 * @param motion
	 * @param moves
	 */
	public static void moveAbsolute(Session session, ALMotion motion, Move...moves) {
		move(session, motion, true, moves);
	}
	
	/**
	 * Eine Bewegung mehrerer Motoren mit Endpositionen relativ zur jetzigen.
	 * @param session
	 * @param motion
	 * @param moves
	 */
	public static void moveRelative(Session session, ALMotion motion, Move...moves) {
		move(session, motion, false, moves);
	}
	
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
