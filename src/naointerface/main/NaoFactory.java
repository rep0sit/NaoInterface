package naointerface.main;

public final class NaoFactory {
	private NaoFactory() {}
	
	/**
	 * The singleton Nao Objekt
	 */
	private static Nao nao = null;
	/**
	 * Factory Method for returning a Nao Objekt.
	 * The nao Objekt is singleton, so if you call
	 * this method again, the same Object is returned
	 * again and the ip and port parameters are ignored.
	 * @param ip
	 * @param port
	 * @return
	 */
	public static Nao getNao(String ip, int port) {
		if(nao == null) {
			nao = new NaoImpl(ip, port);
		}
		
		
		return nao;
	}
}
