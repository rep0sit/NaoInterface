package naointerface.main;
/**
 * This factory class instantiates Nao objects.
 * @author Etienne Onasch
 * @author Nelli Welker
 *
 */
public final class NaoFactory {
	/**
	 * 
	 */
	private NaoFactory() {}
	
	/**
	 * The singleton Nao Objekt
	 */
	private static Nao nao = null;
	/**
	 * Factory Method for returning a Nao Objekt.
	 * The given Nao instance is singleton, so if you call
	 * this method again, the same Object is returned
	 * again and the ip and port parameters of the method are ignored.
	 * @param ip the ip adress
	 * @param port the port
	 * @return a new Nao instance.
	 */
	public static Nao getNao(String ip, int port) {
		if(nao == null) {
			nao = new NaoImpl(ip, port);
		}
		
		return nao;
	}
}
