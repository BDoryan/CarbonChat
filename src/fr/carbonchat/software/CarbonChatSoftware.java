package fr.carbonchat.software;

import java.io.File;
import java.net.URISyntaxException;

import fr.carbonchat.api.CarbonChatAPI;
import fr.carbonchat.api.langs.Lang;
import fr.carbonchat.api.tools.ArgsReader;
import fr.carbonchat.api.tools.logger.Logger;
import fr.carbonchat.api.tools.logger.LoggerFile;

public class CarbonChatSoftware {
	
	public static File software_directory;
	public static Lang current_lang;

	public static void start(String[] args) {
		ArgsReader reader = new ArgsReader(args);
		reader.read();

		String directory = reader.getString("directory");
		if(directory != null) {
			software_directory = new File(directory.replace("%20", " "));
		} else {
			System.err.println("software directory not found !");
			System.exit(-1);
			return;
		}
		
		Boolean debug = reader.getBoolean("debug");
		
		CarbonChatAPI.LOGGER = new Logger("CarbonChat - Software", new LoggerFile(new File(localDirectory(), "logs")));
		CarbonChatAPI.initialize(debug == null ? false : debug);
		
		String lang = reader.getString("lang");
		if(lang != null) {
			try {
				current_lang = new Lang(CarbonChatAPI.class.getResourceAsStream("/langs/"+lang+".lang"));
				current_lang.read(debug);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("lang argument not found !");
			System.exit(-1);
			return;
		}

		CarbonChatApplication.launch(CarbonChatApplication.class, args);
	}

	public static File localDirectory() {
		try {
			File file = new File(CarbonChatSoftware.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
			return file;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		start(args);
	}
}
