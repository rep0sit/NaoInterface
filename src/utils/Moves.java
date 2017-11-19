package utils;

import java.util.ArrayList;
import java.util.List;

import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;

public final class Moves {
	private Moves() {}
	
	/**
	 * A method for combining multiple instances from class Move
	 * and perform them simultaneously.
	 * No Hand opening or closing supported!
	 * @param session
	 * @param moves
	 */
	public static void moveAbsolute(Session session, ALMotion motion, Move...moves){
		
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
	
	public void closeHand(Session session) {
		
	}
	public void openHand(Session session) {
		
	}
	
	
}
