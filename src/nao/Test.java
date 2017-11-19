package nao;

import utils.Languages;

public class Test {
	
	
	
	public static void main(String...args) {
		
		
		Nao NAO = NaoFactory.getNao("127.0.0.1", 39343);
		NAO.setLanguage(Languages.ENGLISH);
		NAO.say("It does work finally!");
		NAO.sad("Now, I am sad");
		NAO.standInit(0.25f);
		
	}
}
