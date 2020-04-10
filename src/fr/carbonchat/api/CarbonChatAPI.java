package fr.carbonchat.api;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import fr.carbonchat.tools.Toolkit;
import fr.carbonchat.tools.logger.Logger;
import fr.carbonchat.tools.logger.LoggerFile;
import fr.carbonchat.tools.reader.FileReader;

public class CarbonChatAPI {

	public static final String NAME = "CarbonChat API";
	public static final String VERSION = "BETA-0.0.1";
	public static final String WEB_MASTER_SERVER = "http://doryan-bessiere.000webhostapp.com/apps/carbonchat/";
	public static final String API_REST = "http://77.144.207.27/api/";
	
	public static Logger LOGGER = null;

	public static boolean WEB_MASTER_SERVER_CONNECTED = false;

	public static String[] AUTHORS = null;
	public static String[] DEVELOPERS = null;
	
	public static Boolean has_update = false;

	public static void initialize(boolean debug) {
		if(LOGGER == null) {
			LOGGER = new Logger("CarbonChat API", new LoggerFile(new File(localDirectory(), "logs")));
		}
		
		LOGGER.debug = debug;

		getServer();
		
		FileReader carbonchat = getCarbonChatInfo();
		if(carbonchat != null) {
			AUTHORS = carbonchat.get("authors").split(",");
			DEVELOPERS = carbonchat.get("developers").split(",");	
		}

		has_update = checkUpdate();

		LOGGER.info("----------[ CARBONCHAT ]----------");
		LOGGER.info("");
		LOGGER.info("Version: " + VERSION);
		LOGGER.info("Web Master Server: " + WEB_MASTER_SERVER);
		LOGGER.info("Web Master Server Status : " + (WEB_MASTER_SERVER_CONNECTED ? "online" : "offline"));
		LOGGER.info("");
		LOGGER.info("has update: "+(has_update == null ? "null" : has_update ? "yes" : "no"));
		LOGGER.info("  current version: "+VERSION);
		LOGGER.info("  last version: "+(carbonchat != null ? carbonchat.get("version") : "null"));
		LOGGER.info("");
		LOGGER.info("----------------------------------");
	}

	public static File localDirectory() {
		try {
			File file = new File(CarbonChatAPI.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
			return file;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static URL getServer() {
		URL url = Toolkit.getURL(WEB_MASTER_SERVER, false);
		if(url == null) {
			WEB_MASTER_SERVER_CONNECTED = false;
		} else {
			WEB_MASTER_SERVER_CONNECTED = true;
		}
		return url;
	}
	
	public static Boolean checkUpdate() {
		FileReader carbonchat = getCarbonChatInfo();
		if(carbonchat != null) {
			
			if(VERSION.equalsIgnoreCase(carbonchat.get("version")))
				return false;
			else
				return true;
		}
		return null;
	}

	public static FileReader getCarbonChatInfo() {
		try {
			URL url = Toolkit.getURL(WEB_MASTER_SERVER + "carbonchat.info", false);
			if (url == null)
				return null;

			FileReader info = new FileReader("carbonchat.info", url.openStream());
			info.read(false);
			return info;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
