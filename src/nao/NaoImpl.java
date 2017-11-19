package nao;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

import utils.Constants;
import utils.Languages;
import utils.Motors;
import utils.Move;
import utils.Moves;

import utils.Stances;

import static utils.Constants.*;


class NaoImpl implements Nao {
	
	
	private final int port;
	private final String ip;
	private final Application app;
	private final Session session;
	
	
	private ALTextToSpeech tts;
	private ALMotion motion;
	private ALRobotPosture posture;
	
	NaoImpl(String ip, int port){
		this.port = port;
		this.ip = ip;
		
		String[] args = {};
		String robotUrl = "tcp://" + ip + ":" + Integer.toString(port);
		
		app = new Application(args, robotUrl);
		
		app.start();
		session = app.session();
		
		
		try {
			tts = new ALTextToSpeech(session);
			tts.setLanguage(Languages.GERMAN);
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
	public String getLanguage() {
		String l = null;
		try {
			l =  tts.getLanguage();
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	public void setLanguage(String language) {
		try {
			tts.setLanguage(language);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getPort() {
		return port;
	}
	public String getIp() {
		return ip;
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
		stand(FLOAT_ONE_POINT_ZERO);
		
		Move rightArm = new Move(Motors.RIGHT_SHOULDER_PITCH, .0, .85);
		Moves.moveAbsolute(session, motion, rightArm);
		
		try {
			motion.openHand(Motors.RIGHT_HAND);
			motion.closeHand(Motors.RIGHT_HAND);
			
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		say(text);
		sleep();
		stand(FLOAT_POINT_SIX_FIVE);

	}

	@Override
	public void showStone(String text) {
		stand(FLOAT_ONE_POINT_ZERO);
		Move rightArm = new Move(Motors.RIGHT_SHOULDER_PITCH, .0, .85);
		Move turnForeArm = new Move(Motors.RIGHT_ELBOW_YAW, 0.0, .85);
		Moves.moveAbsolute(session, motion, rightArm, turnForeArm);
		
		
		
		say(text);
		sleep();
		stand(FLOAT_POINT_SIX_FIVE);
	}

	@Override
	public void showPaper(String text) {
		stand(FLOAT_ONE_POINT_ZERO);
		Move rightArm = new Move(Motors.LEFT_SHOULDER_PITCH, .0, .85);
		Move turnForeArm = new Move(Motors.LEFT_ELBOW_YAW, 0.0, .85);
		
		Moves.moveAbsolute(session, motion, rightArm, turnForeArm);
		try {
			motion.openHand(Motors.LEFT_HAND);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		say(text);
		sleep();
		stand(FLOAT_POINT_SIX_FIVE);

	}

	@Override
	public void greet(String text) {
		stand(Constants.FLOAT_ONE_POINT_ZERO);
		Move wave1 = new Move(Motors.LEFT_SHOULDER_PITCH, -50.0, .5);
		Move wave2 = new Move(Motors.LEFT_SHOULDER_ROLL, 25.0,0.5);
		Moves.moveAbsolute(session, motion, wave1, wave2);
		say(text);
		sleep();
		stand(Constants.FLOAT_ONE_POINT_ZERO);

	}



	@Override
	public void happy(String text) {
		stand(FLOAT_ONE_POINT_ZERO);
		double armAngle = -50.0;
		double time = 1.0;
		Move leftArm = 
				new Move(Motors.LEFT_SHOULDER_PITCH, armAngle, time);
		Move rightArm = 
				new Move(Motors.RIGHT_SHOULDER_PITCH, armAngle, time);
		Move head = 
				new Move(Motors.HEAD_PITCH, -30.0, time);
		
		Moves.moveAbsolute(session, motion, leftArm, rightArm, head);
		say(text);
		sleep();
		
		stand(FLOAT_POINT_SIX_FIVE);

	}

	@Override
	public void sad(String text) {
		stand(FLOAT_POINT_THREE);
		
		Move headDown = new Move(Motors.HEAD_PITCH, 15.0, 1.0);
		Moves.moveAbsolute(session, motion, headDown);
		say(text);
		sleep();
		stand(FLOAT_POINT_THREE);
	}

	@Override
	public void standZero(float maxSpeedFraction) {
		try {
			posture.applyPosture(Stances.STAND_ZERO, maxSpeedFraction);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void standInit(float maxSpeedFraction) {
		try {
			posture.applyPosture(Stances.STAND_INIT, maxSpeedFraction);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void stand(float maxSpeedFraction) {
		try {
			posture.applyPosture(Stances.STAND, maxSpeedFraction);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
