package naointerface.main;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class Test {
	   
	
	private static <E extends Object> void printList(List<E> list) {
		for(E e : list) {
			System.out.println(e);
		}
	}
	
	public static void main(String...args) throws InterruptedException {
		
		
		
		Nao nao = NaoFactory.getNao("localhost", 33463);
		
		nao.setVolume(1.0);
		nao.standUp();
		nao.setSpeedMod(1.5);
		
		nao.openRightHand();
		nao.openLeftHand();
		
		
		for(String s : BodyParts.SUPPORTED_BODY_PARTS) {
			
			double angle = s.charAt(0) == 'L' ? 30.0 : -30.0;
			Move next = new Move(s, angle);
			nao.moveRelative(next);
		}
		
		
//		nao.setSpeedMod(1.5);
		
//		nao.greet("Hello User.");
//		nao.say("Come with me if you want to live!");
//		nao.showRock("Rock.");
//		nao.say("beats");
//		nao.showScissors("Scissors.");
		
//		SpeechRecognition sr = nao.getSpeechRecognition();
//		int seconds = 5;
//		String test = "test";
//		String test2 = "autobahn";
//		String test3 = "pterodactyl";
//		String test0 = "what";
//		sr.addVocabulary(test0, test, test2, test3);
//		nao.say("When I give the signal, "
//				+ "then you have " + seconds + " seconds to say the Word, " 
//				+ test + ".");
//		Thread.sleep(500);
//		
//		nao.say("Say the word " + test + " , in, 3, 2, 1,");
//		String word = sr.recordWord(seconds, true);
//		Thread.sleep(2000);
//		System.out.println(word);
//		nao.say(word);
//		sr.clearVocabulary();
		
		
	}
	
	
}
