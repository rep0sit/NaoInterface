package naointerface.utils;

public final class Constants {
	private Constants() {}
	public static final String LINE_BREAK = "\n";
	
	
	public static final double EPSILON = 1e-6;
	
	
	public static final float FLOAT_ONE_POINT_ZERO = 1.0f;
	public static final float FLOAT_POINT_EIGHT_FIVE = .85f;
	public static final float FLOAT_POINT_SIX_FIVE = .65f;
	public static final float FLOAT_POINT_FIVE = .5f;
	public static final float FLOAT_POINT_THREE = .3f;
	public static final float FLOAT_POINT_TWO_FIVE = .25f;
	public static final float FLOAT_POINT_ZERO = .0f;
	
	
	public static final int STANDARD_WAITING_TIME = 400;
	
	public static final double STANDARD_MOVING_TIME = 1.0;
	public static final float STANDARD_SPEED_FRACTION = 0.5f;
	
	
	public static final double MAX_SPEED_MOD = 1.5;
	public static final double MIN_SPEED_MOD = 0.5;
	
	private static double speedMod = 1.0;
	
	public static void setSpeedMod(double mod) {
		
		speedMod = normalize(mod, MIN_SPEED_MOD, MAX_SPEED_MOD);
	}
	public static double getSpeedMod() {
		return speedMod;
	}
	
	
	public static double normalize(double number, double min, double max) {
		if(min > max) {
			double mem = max;
			max = min;
			min = mem;
		}
		
		return number < min ? min : number > max ? max : number;
	}
}
