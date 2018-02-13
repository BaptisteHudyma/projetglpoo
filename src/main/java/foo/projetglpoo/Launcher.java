package foo.projetglpoo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import foo.projetglpoo.api.EuroMillionsAPI;
import foo.projetglpoo.api.EuroMillionsResult;
import foo.projetglpoo.api.mashape.MashableAPI;

public class Launcher {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger log = Logger.getLogger(Launcher.class);
		log.debug("Hello World");
		
		Properties conf = new Properties();
		try {
			InputStream in = Launcher.class.getResourceAsStream("api.properties");			
			conf.load(in);
			in.close();
		} catch (IOException e) {
			log.fatal("could not load api.properties", e);
			return;
		}
		
		EuroMillionsAPI api = new MashableAPI(conf.getProperty("mashape_key"));
		EuroMillionsResult result = api.getLastResult();
		log.debug(Arrays.toString(result.getNumbers()));
		log.debug(Arrays.toString(result.getStars()));
	}
}