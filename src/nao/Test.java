package nao;

public class Test {
	
	
	
	public static void main(String...args) {
		
		
		Nao nao = NaoFactory.getNao("localhost", 40051);
		
		nao.greet("Hey wie geht's denn so?");
		
		
		
	}
}
