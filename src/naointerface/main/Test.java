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
	
	public static void main(String...args) {
		
		
//		Nao nao = NaoFactory.getNao("192.168.1.121", 9559);
		
		
//		nao.greet("Great Success!");
//		nao.say("Ich bin ein Berliner.");
//		nao.showRock("Rock.");
//		nao.say("schlägt");
//		nao.showScissors("Scissors.");
	
		
		String a = "a a";
		String b = "b";
		
		b.split(" ");
		
		System.out.println(b.split(" ").length);
		
	}
}
