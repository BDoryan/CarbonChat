package fr.carbonchat.jfxswinger;

import java.io.File;
import java.net.URISyntaxException;

import fr.carbonchat.api.CarbonChatAPI;
import fr.carbonchat.tools.ArgsReader;
import fr.carbonchat.tools.logger.Logger;
import fr.carbonchat.tools.logger.LoggerFile;
import javafx.scene.text.Font;

public class JFXSwinger {

	public static final String NAME = "JFXSwinger";
	public static final String VERSION = "BETA-0.0.1";

	public static void init(String... args) {
		ArgsReader reader = new ArgsReader(args);
		reader.read();

		// APP_FONT_2 =
		// Font.loadFont(JFXSwinger.class.getResourceAsStream("/fonts/SteelTongs/SteelTongs.ttf"),
		// 18D);
		// APP_FONT =
		// Font.loadFont(JFXSwinger.class.getResourceAsStream("/fonts/GoogleSansFont/GoogleSans-Regular.ttf"),
		// 18D);

		Boolean debug = reader.getBoolean("debug");

		CarbonChatAPI.LOGGER = new Logger("CarbonChat - Software", new LoggerFile(new File(localDirectory(), "logs")));
		CarbonChatAPI.initialize(debug == null ? false : debug);
	}

	public static Font getFont2(double height) {
		return Font.loadFont(JFXSwinger.class.getResourceAsStream("/fonts/SteelTongs/SteelTongs.ttf"), height);
	}

	public static Font getFont(double height) {
		Font font = Font.loadFont(JFXSwinger.class.getResourceAsStream("/fonts/GoogleSansFont/GoogleSans-Regular.ttf"),
				height);
		return font;
	}

	public static File localDirectory() {
		try {
			File file = new File(JFXSwinger.class.getProtectionDomain().getCodeSource().getLocation().toURI())
					.getParentFile();
			return file;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
