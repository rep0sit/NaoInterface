package naointerface.main;
/**
 * This class consist of constants and static helper methods.
 * @author Nelli Welker
 * @author Etienne Onasch
 *
 */
final class Constants {
	private Constants() {}
	public static final String LINE_BREAK = "\n";
	
	
	public static final String NO_VOCABULARY = "Vocabulary is Empty!";
	public static final String WORD_RECOGNIZED = "WordRecognized";
	public static final double EPSILON = 1e-6;
	
	public static final int MILLISECONDS_PER_SECOND = 1000;
	
	
	public static final int STANDARD_WAITING_TIME = 400;
	
	public static final double STANDARD_MOVING_TIME = 1.0;
	public static final float STANDARD_SPEED_FRACTION = 0.5f;
	
	
	public static final double MAX_SPEED_MOD = 1.5;
	public static final double MIN_SPEED_MOD = 0.5;
	
	private static double speedMod = 1.0;
	
	/**
	 * Sets the global speed modification.<br>
	 * this value will be normalized to the interval <br>
	 * [0.5...1.5]
	 * @param mod the double value 
	 */
	public static void setSpeedMod(double mod) {
		
		speedMod = normalize(mod, MIN_SPEED_MOD, MAX_SPEED_MOD);
	}
	/**
	 * Returns the current global speed modification.<br>
	 * @return the speed modification.
	 */
	public static double getSpeedMod() {
		return speedMod;
	}
	
	/**
	 * Normalizes a number to the given interval.<br>
	 * It also works if min > max.
	 * @param number the numnber to be normalized	
	 * @param min the low end of the interval
	 * @param max the upper end of the interval
	 * @return the normalized number.
	 */
	public static double normalize(double number, double min, double max) {
		if(min > max) {
			double mem = max;
			max = min;
			min = mem;
		}
		
		return number < min ? min : number > max ? max : number;
	}
	/**
	 * Normalizes a number to the given interval.<br>
	 * It also works if min > max.
	 * @param number the numnber to be normalized	
	 * @param min the low end of the interval
	 * @param max the upper end of the interval
	 * @return the normalized number.
	 */
	public static int normalize(int number, int min, int max) {
		return (int) normalize((double) number, (double) min, (double) max);
	}
	
	
	
}
