package fr.carbonchat.software;

import java.io.File;
import java.net.URISyntaxException;

import fr.carbonchat.api.CarbonChatAPI;
import fr.carbonchat.api.langs.Lang;
import fr.carbonchat.software.CarbonChatApplication.CarbonChatApplicationLoading;
import fr.carbonchat.software.interfaces.CarbonChatLoadingFrame;
import fr.carbonchat.tools.ArgsReader;
import fr.carbonchat.tools.logger.Logger;
import fr.carbonchat.tools.logger.LoggerFile;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class CarbonChatSoftware {

	public static File software_directory;
	public static Lang current_lang;

	public static void start(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Application.launch(CarbonChatApplicationLoading.class);
			}
		}).start();

		ArgsReader reader = new ArgsReader(args);
		reader.read();

		String directory = reader.getString("directory");
		if (directory != null) {
			software_directory = new File(directory.replace("%20", " "));
		} else {
			System.err.println("software directory not found !");
			System.exit(-1);
			return;
		}

		Boolean debug = reader.getBoolean("debug");

		System.setProperty("prism.lcdtext", "false");

		CarbonChatAPI.LOGGER = new Logger("CarbonChat - Software", new LoggerFile(new File(localDirectory(), "logs")));
		CarbonChatAPI.initialize(debug == null ? false : debug);

		String lang = reader.getString("lang");
		if (lang != null) {
			try {
				current_lang = new Lang(CarbonChatAPI.class.getResourceAsStream("/langs/" + lang + ".lang"));
				current_lang.read(debug);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("lang argument not found !");
			System.exit(-1);
			return;
		}
		
		if (CarbonChatLoadingFrame.instance != null)
			CarbonChatLoadingFrame.instance.close();
		else
			System.err.println("Error found on closing loading frame !");

		Platform.runLater(new Runnable() {
			public void run() {
				try {
					new CarbonChatApplication().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static File localDirectory() {
		try {
			File file = new File(CarbonChatSoftware.class.getProtectionDomain().getCodeSource().getLocation().toURI())
					.getParentFile();
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
