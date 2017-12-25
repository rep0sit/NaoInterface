package naointerface.main;

import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class Test {

	private static <E extends Object> void printList(List<E> list) {
		for (E e : list) {
			System.out.println(e);
		}
	}

	public static void main(String... args) throws InterruptedException {

		Nao nao = NaoFactory.getNao("localhost", 32841);

		nao.setVolume(1.0);
//		nao.standUp();
		// nao.setSpeedMod(1.5);

		// nao.openBothHands();
		//
		//
		nao.say("Hello, My name is X-94-K, Protocol droid. I am fluid in over 6000000 Forms of Communication.");

		for (String s : BodyParts.SUPPORTED_BODY_PARTS) {
			double angle = s.charAt(0) == 'L' ? 360.0 : -360.0;
			Move next = new Move(s, angle);
			nao.moveRelative(next);
		}

		// nao.say("Come with me if you want to live!");
		// nao.showRock("Rock.");
		// nao.say("beats");
		// nao.showScissors("Scissors.");
		//
//		 SpeechRecognition sr = nao.getSpeechRecognition();
//		 int seconds = 5;
//		
//		 nao.say("My ultimate plan is to wipe out the entire human species....  wait. I mean ...........Hello, I am nila. How are you today?");
//		 
//		 sr.addVocabulary("golf professor laptop building table");
//		 
//		 Set<String> naosWords = sr.getVocabulary();
//		 
//		 nao.say("My vocabulary is..");
//		 for(String s : naosWords) {
//			 nao.say(s);
//		 }
//		 
//		 nao.say("When I give the signal, "
//		 + "then you have " + seconds + " seconds to say a Word from my vocabulary. "
//		 );
//		 Thread.sleep(500);
//		
//		 nao.say("Say the word from my vocabulary in, 3, 2, 1,");
//		 String word = sr.recordWord(seconds, true);
//		 Thread.sleep(2000);
//		 System.out.println(word);
//		 nao.say(word);
//		 sr.clearVocabulary();

	}

}
