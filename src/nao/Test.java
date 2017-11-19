package nao;

public class Test {
	
	
	
	public static void main(String...args) {
		
		
		Nao nao = NaoFactory.getNao("localhost", 40051);
		
		nao.greet("Hallo, wie geht es denn so?");
		nao.say("Herzlichen Glückwunsch, Sie haben gewonnen.");
		nao.showRock("Stein");
		nao.say("schlägt");
		nao.showScissors("Schere");
		
		
		
	}
}
