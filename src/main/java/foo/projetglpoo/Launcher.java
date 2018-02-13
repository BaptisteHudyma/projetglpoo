package foo.projetglpoo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Launcher {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger log = Logger.getLogger(Launcher.class);
		log.debug("Hello World");
	}
}