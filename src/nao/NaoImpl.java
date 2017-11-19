package nao;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

import utils.Languages;
import utils.MotorNames;
import utils.Move;
import utils.Moves;
import utils.Stances;

public class NaoImpl implements Nao {
	
	private final int port;
	private final String ip;
	private final Application app;
	private final Session session;
	private String language = Languages.GERMAN;
	
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
			motion = new ALMotion(session);
			posture = new ALRobotPosture(session);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void setLanguage(String language) {
		this.language = language;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void showStone(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showPaper(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void greet(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isAnnoyed(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happy(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sad(String text) {
		standInit(0.3f);
		
		Move headDown = new Move(MotorNames.HEAD_PITCH, 15.0, 1.0);
		Moves.moveAbsolute(session, motion, headDown);
		say(text);
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
