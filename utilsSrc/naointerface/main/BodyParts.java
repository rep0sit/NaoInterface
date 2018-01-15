package naointerface.main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/**
 * This utility class consist all the names for the Bodyparts of a Nao robot, that are
 * used in the JNaoQi API.
 * Some of them are marked with a {@code @Supported} annotation.<br><br>
 * The list {@code naointerface.main.BodyParts.BODY_PARTS} consists all the fields that are
 * in this class that are NOT marked with a {@code @NoBodyPart} annotation.<br>
 * The list {@code naointerface.main.BodyParts.SUPPORTED_BODY_PARTS} consists all the fields
 * that are in this class that are marked with a {@code @Supported} annotation.<br>
 * Bodyparts that are marked with the {@code @Supported} annotation can be used to invoke
 * the constructor of the class {@code naointerface.main.Move}.
 * @author Nelli Welker
 * @author Etienne Onasch
 *
 */
public final class BodyParts {
	private BodyParts() {}
	//HEAD
	
	public static final String HEAD = "Head"; 
	@Supported
	public static final String HEAD_YAW = "HeadYaw";
	@Supported
	public static final String HEAD_PITCH = "HeadPitch";
	
	//LEFT ARM
	
	public static final String LEFT_ARM = "LArm";
	@Supported
	public static final String LEFT_SHOULDER_PITCH = "LShoulderPitch";
	@Supported
	public static final String LEFT_SHOULDER_ROLL = "LShoulderRoll";
	@Supported
	public static final String LEFT_ELBOW_YAW = "LElbowYaw";
	@Supported
	public static final String LEFT_ELBOW_ROLL = "LElbowRoll";
	@Supported
	public static final String LEFT_WRIST_YAW = "LWristYaw";
	@Supported
	public static final String LEFT_HAND = "LHand";
	
	// RIGHT ARM
	
	public static final String RIGHT_ARM = "RArm";
	@Supported
	public static final String RIGHT_SHOULDER_PITCH = "RShoulderPitch";
	@Supported
	public static final String RIGHT_SHOULDER_ROLL = "RShoulderRoll";
	@Supported
	public static final String RIGHT_ELBOW_YAW = "RElbowYaw";
	@Supported
	public static final String RIGHT_ELBOW_ROLL = "RElbowRoll";
	@Supported
	public static final String RIGHT_WRIST_YAW = "RWristYaw";
	@Supported
	public static final String RIGHT_HAND = "RHand";
	
	// LEFT LEG
	
	public static final String LEFT_LEG = "LLeg";
	public static final String LEFT_HIP_YAW_PITCH = "LHipYawPitch";
	public static final String LEFT_HIP_ROLL = "LHipRoll";
	public static final String LEFT_HIP_PITCH = "LHipPitch";
	public static final String LEFT_KNEE_PITCH = "LKneePitch";
	public static final String LEFT_ANKLE_PITCH = "LAnklePitch";
	public static final String LEFT_ANKLE_ROLL = "LAnkleRoll";
	
	// RIGHT LEG
	
	public static final String RIGHT_LEG = "RLeg";
	public static final String RIGHT_HIP_YAW_PITCH = "RHipYawPitch";
	public static final String RIGHT_HIP_ROLL = "RHipRoll";
	public static final String RIGHT_HIP_PITCH = "RHipPitch";
	public static final String RIGHT_KNEE_PITCH = "RKneePitch";
	public static final String RIGHT_ANKLE_PITCH = "RAnklePitch";
	public static final String RIGHT_ANKLE_ROLL = "RAnkleRoll";
	
	/**
	 * A list of all BodyParts.
	 * 
	 */
	@NoBodyPart
	public static List<String> BODY_PARTS = getBodyParts(false);
	/**
	 * A list of all Supported BodyParts.<br>
	 * The methods moveAbsolute(...) and moveRelative(...) from a Nao instance <br>
	 * only work with supported BodyParts!<br>
	 * 
	 */
	@NoBodyPart
	public static List<String> SUPPORTED_BODY_PARTS = getBodyParts(true);


	/**
	 * Returns a List of all BodyParts with Reflections.<br>
	 * 
	 * @param supportedOnly If true, this method returns a list of the supported BodyParts only!<br>
	 * The methods moveAbsolute(...) and moveRelative(...) from a Nao instance <br>
	 * only work with supported BodyParts!<br>
	 * If true, a list of all BodyParts is returned.
	 * @return the list of BodyParts
	 */
	private static List<String> getBodyParts(boolean supportedOnly){
		List<String> valueList = new ArrayList<>();
		Field[] allFields = BodyParts.class.getFields();
		for(Field f : allFields) {
			try {
				String val = f.isAnnotationPresent(NoBodyPart.class) ? null : (String)f.get(null);
				boolean check = supportedOnly ? f.isAnnotationPresent(Supported.class) : !supportedOnly;
				if(check && val != null) {
					valueList.add(val);
				}
				
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return valueList;
	}
	
}
