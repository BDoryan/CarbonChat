package fr.carbonchat.software;

import fr.carbonchat.jfxswinger.swingers.JFXSFrame;
import fr.carbonchat.software.interfaces.CarbonChatFrame;
import fr.carbonchat.software.interfaces.CarbonChatLoadingFrame;
import javafx.application.Application;
import javafx.stage.Stage;

public class CarbonChatApplication extends Application {

	public static JFXSFrame frame;

	@Override
	public void start(Stage stage) throws Exception {
		frame = new CarbonChatFrame(stage);
	}
	
	public static class CarbonChatApplicationLoading extends Application {

		public static JFXSFrame frame;
		
		@Override
		public void start(Stage stage) throws Exception {
			frame = new CarbonChatLoadingFrame(stage);
		}	
	}
}
