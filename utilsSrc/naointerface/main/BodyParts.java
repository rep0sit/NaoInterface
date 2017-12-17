package naointerface.main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class BodyParts {
	private BodyParts() {}
	//HEAD
	@Nomove
	public static final String HEAD = "Head";
	public static final String HEAD_YAW = "HeadYaw";
	public static final String HEAD_PITCH = "HeadPitch";
	
	//LEFT ARM
	@Nomove
	public static final String LEFT_ARM = "LArm";
	public static final String LEFT_SHOULDER_PITCH = "LShoulderPitch";
	public static final String LEFT_SHOULDER_ROLL = "LShoulderRoll";
	public static final String LEFT_ELBOW_YAW = "LElbowYaw";
	public static final String LEFT_ELBOW_ROLL = "LElbowRoll";
	public static final String LEFT_WRIST_YAW = "LWristYaw";
	public static final String LEFT_HAND = "LHand";
	
	// RIGHT ARM
	@Nomove
	public static final String RIGHT_ARM = "RArm";
	public static final String RIGHT_SHOULDER_PITCH = "RShoulderPitch";
	public static final String RIGHT_SHOULDER_ROLL = "RShoulderRoll";
	public static final String RIGHT_ELBOW_YAW = "RElbowYaw";
	public static final String RIGHT_ELBOW_ROLL = "RElbowRoll";
	public static final String RIGHT_WRIST_YAW = "RWristYaw";
	public static final String RIGHT_HAND = "RHand";
	
	// LEFT LEG
	@Nomove
	public static final String LEFT_LEG = "LLeg";
	@Nomove
	public static final String LEFT_HIP_YAW_PITCH = "LHipYawPitch";
	@Nomove
	public static final String LEFT_HIP_ROLL = "LHipRoll";
	@Nomove
	public static final String LEFT_HIP_PITCH = "LHipPitch";
	@Nomove
	public static final String LEFT_KNEE_PITCH = "LKneePitch";
	@Nomove
	public static final String LEFT_ANKLE_PITCH = "LAnklePitch";
	@Nomove
	public static final String LEFT_ANKLE_ROLL = "LAnkleRoll";
	
	// RIGHT LEG
	@Nomove
	public static final String RIGHT_LEG = "RLeg";
	@Nomove
	public static final String RIGHT_HIP_YAW_PITCH = "RHipYawPitch";
	@Nomove
	public static final String RIGHT_HIP_ROLL = "RHipRoll";
	@Nomove
	public static final String RIGHT_HIP_PITCH = "RHipPitch";
	@Nomove
	public static final String RIGHT_KNEE_PITCH = "RKneePitch";
	@Nomove
	public static final String RIGHT_ANKLE_PITCH = "RAnklePitch";
	@Nomove
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
				boolean check = supportedOnly ? !f.isAnnotationPresent(Nomove.class) : !supportedOnly;
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
