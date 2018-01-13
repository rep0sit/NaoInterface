package naointerface.main;

import static naointerface.main.Constants.*;
import static naointerface.main.BodyParts.*;
import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

class NaoImpl implements Nao {
	
	
	private final int port;
	private final String ip;
	private final String url;
	private final Application app;
	private final Session session;
	
	private ALTextToSpeech tts;
	private ALMotion motion;
	private ALRobotPosture posture;
	
	private static final double CLOSE_HAND_ANGLE = -100.0;
	private static final double OPEN_HAND_ANGLE = -CLOSE_HAND_ANGLE;
	
	NaoImpl(String ip, int port){
		this.port = port;
		this.ip = ip;
		
		String[] args = {};
		url = "tcp://" + ip + ":" + Integer.toString(port);
		
		app = new Application(args, url);
		
		app.start();
		session = app.session();
		
		
		try {
			tts = new ALTextToSpeech(session);
			tts.setLanguage(Languages.ENGLISH);
			motion = new ALMotion(session);
			posture = new ALRobotPosture(session);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void sleep() {
		try {
			Thread.sleep(STANDARD_WAITING_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void say(String text) {
		
		try {
		
			tts.say(text);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void showScissors(String text) {
		stand();
		
		Moves.moveAbsolute(session, motion, new Move(BodyParts.RIGHT_SHOULDER_PITCH, .0));
		say(text);
		closeRightHand();
		openRightHand();
		closeRightHand();
		sleep();
		stand();

	}

	@Override
	public void showRock(String text) {
		stand();
		Move rightArm = new Move(BodyParts.RIGHT_SHOULDER_PITCH, .0);
		Move turnForeArm = new Move(BodyParts.RIGHT_ELBOW_YAW, 0.0);
		Moves.moveAbsolute(session, motion, rightArm, turnForeArm);
		say(text);
		sleep();
		stand();
	}

	@Override
	public void showPaper(String text) {
		stand();
		Move rightArm = new Move(BodyParts.LEFT_SHOULDER_PITCH, 0.0);
		Move turnForeArm = new Move(BodyParts.LEFT_ELBOW_YAW, 0.0);
		
		Moves.moveAbsolute(session, motion, rightArm, turnForeArm);
		try {
			motion.openHand(BodyParts.LEFT_HAND);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		sleep();
		say(text);
		stand();

	}

	@Override
	public void greet(String text) {
		stand();
		Move wave1 = new Move(BodyParts.LEFT_SHOULDER_PITCH, -50.0);
		Move wave2 = new Move(BodyParts.LEFT_SHOULDER_ROLL, 25.0);
		Moves.moveAbsolute(session, motion, wave1, wave2);
		say(text);
		sleep();
		stand();

	}



	@Override
	public void happy(String text) {
		stand();
		double armAngle = -50.0;
		
		Move leftArm = 
				new Move(BodyParts.LEFT_SHOULDER_PITCH, armAngle);
		Move rightArm = 
				new Move(BodyParts.RIGHT_SHOULDER_PITCH, armAngle);
		Move head = 
				new Move(BodyParts.HEAD_PITCH, -30.0);
		
		Moves.moveAbsolute(session, motion, leftArm, rightArm, head);
		say(text);
		sleep();
		
		stand();

	}

	@Override
	public void sad(String text) {
		stand();
		
		Move headDown = new Move(BodyParts.HEAD_PITCH, 15.0);
		Moves.moveAbsolute(session, motion, headDown);
		say(text);
		sleep();
		stand();
	}
	/**
	 * Alle Motoren in die 0-Position.
	 */
	@SuppressWarnings("unused")
	private void standZero(float maxSpeedFraction) {
		try {
			posture.applyPosture(Stances.STAND_ZERO, maxSpeedFraction);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Initialer Stand. Nao kann von 
	 * dieser Pose aus alles tun.
	 */
	@SuppressWarnings("unused")
	private void standInit(float maxSpeedFraction) {
		try {
			posture.applyPosture(Stances.STAND_INIT, maxSpeedFraction);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void stand() {
		stand(Constants.STANDARD_SPEED_FRACTION * (float)getSpeedMod());
	}
	
	/**
	 * Pose mit geringem Energieverbrauch.
	 */
	private void stand(float maxSpeedFraction) {
		try {
			posture.applyPosture(Stances.STAND, maxSpeedFraction);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getIp() {
		return ip;
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public void setSpeedMod(double mod) {
		Constants.setSpeedMod(mod);
		
	}

	@Override
	public double getSpeedMod() {
		return Constants.getSpeedMod();
	}

	@Override
	public double getVolume() {
		double retVal =  0.0;
		
		try {
			retVal = tts.getVolume();
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

	@Override
	public void setVolume(double vol) {
		
		try {
			tts.setVolume((float) normalize(vol, 0.0, 1.0));
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public SpeechRecognition getSpeechRecognition() {
		
		return SpeechRecognitionFactory.getSpeechRecognition(session);
	}

	@Override
	public void standUp() {
		try {
			posture.goToPosture(Stances.STAND_INIT, STANDARD_SPEED_FRACTION * (float)getSpeedMod());
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * A method to open or close a hand.<br>
	 * Parameter {@code String hand} can only be {@code "RHand"} or {@code "LHand"}.<br>
	 * @param hand the hand that which should be open or closed.
	 * @param open a boolean parameter. If true, the hand will open. If false the hand will close.
	 */
	private void hand(String hand, boolean open) {
		assert hand.equals(LEFT_HAND) || hand.equals(RIGHT_HAND) : 
			"Parameter can only be RHand or LHand." ;
		if (open) {
			Moves.moveAbsolute(session, motion, new Move(hand, OPEN_HAND_ANGLE));

		} else {
			Moves.moveAbsolute(session, motion, new Move(hand, CLOSE_HAND_ANGLE));
		}
		
	}
	@Override
	public void openRightHand() {
		hand(RIGHT_HAND, true);
		
	}

	@Override
	public void closeRightHand() {
		hand(RIGHT_HAND, false);
		
	}

	@Override
	public void openLeftHand() {
		hand(LEFT_HAND, true);
		
	}

	@Override
	public void closeLeftHand() {
		hand(LEFT_HAND, false);
		
	}

	@Override
	public ALMotion getMotionModule() {
		return motion;
	}

	@Override
	public void closeBothHands() {
		Move closeLeft = new Move(LEFT_HAND, CLOSE_HAND_ANGLE);
		Move closeRight = new Move(RIGHT_HAND, CLOSE_HAND_ANGLE);
		Moves.moveAbsolute(session, motion, closeLeft, closeRight);
		
	}

	@Override
	public void openBothHands() {
		Move closeLeft = new Move(LEFT_HAND, OPEN_HAND_ANGLE);
		Move closeRight = new Move(RIGHT_HAND, OPEN_HAND_ANGLE);
		Moves.moveAbsolute(session, motion, closeLeft, closeRight);
		
	}

	@Override
	public void moveAbsolute(Move... moves) {
		Moves.moveAbsolute(session, motion, moves);
		
	}

	@Override
	public void moveRelative(Move... moves) {
		Moves.moveAbsolute(session, motion, moves);
		
	}
	
	
	
}
