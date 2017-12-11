package naointerface.main;

public class Test {
	
	
	
	public static void main(String...args) {
		
		
		Nao nao = NaoFactory.getNao("192.168.1.121", 9559);
		
		//nao.setLanguage(Languages.GERMAN);
		
//		nao.greet("Great Success!");
//		nao.say("Ich bin ein Berliner.");
//		nao.showRock("Rock.");
//		nao.say("schlägt");
		nao.showScissors("Scissors.");
//		
		
		
	}
}
