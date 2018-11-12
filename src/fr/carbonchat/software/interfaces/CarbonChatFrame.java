package fr.carbonchat.software.interfaces;

import java.util.Timer;
import java.util.TimerTask;

import fr.carbonchat.jfxswinger.palettes.JFXSwingerPalette;
import fr.carbonchat.jfxswinger.swingers.JFXSFrame;
import fr.carbonchat.jfxswinger.swingers.JFXSTitleBar;
import fr.carbonchat.software.interfaces.launcher.LauncherInterface;
import fr.carbonchat.software.interfaces.main.MainInterface;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CarbonChatFrame extends JFXSFrame {

	public JFXSTitleBar title_bar;
	public AnchorPane container;

	public CarbonChatFrame(Stage stage) {
		super(stage, "CarbonChat", 1280, 720);

		this.setIcon(new Image(getClass().getResourceAsStream("/imgs/carbonchat-logo.png")));
		this.stage.initStyle(StageStyle.UNDECORATED);

		this.container = new AnchorPane();

		this.title_bar = new JFXSTitleBar(this, 23, false) {
			@Override
			public void setMaximized(boolean maximized_) {
				super.setMaximized(maximized_);
			}

			@Override
			public void actionIconified() {
				new Timer().schedule(new TimerTask() {

					float opacity = 1.0f;

					@Override
					public void run() {
						Platform.runLater(() -> {
							opacity -= 0.25;
							if (opacity <= 0.0) {
								CarbonChatFrame.this.stage.setOpacity(0.0f);
								CarbonChatFrame.this.stage.setIconified(true);
								CarbonChatFrame.this.stage.setOpacity(1.0f);
								opacity = 1.0f;
								cancel();
								return;
							} else {
								CarbonChatFrame.this.stage.setOpacity(opacity);
							}
						});
					}
				}, 0, 27);
			}
		};

		AnchorPane.setTopAnchor(this.container, this.title_bar.height - 1);
		AnchorPane.setBottomAnchor(this.container, 0D);
		AnchorPane.setRightAnchor(this.container, 0D);
		AnchorPane.setLeftAnchor(this.container, 0D);

		this.root.getStylesheets().add("/css/scroll-bar.css");
		this.root.getChildren().add(this.container);
		this.root.setBorder(new Border(new BorderStroke(JFXSwingerPalette.PALETTE.getWhite(), BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY, new BorderWidths(0.10D))));

		loadInterface(MainInterface.INTERFACE,
				this.container);
		
		init();
		apply();
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						LauncherInterface.INTERFACE.playLogoAnimation(null);						
					}
				});
			}
		}, 100);
	}

	public void maximized(boolean maximized_) {
		if (!maximized_) {
			root.setBorder(new Border(new BorderStroke(JFXSwingerPalette.PALETTE.getWhite(), BorderStrokeStyle.SOLID,
					CornerRadii.EMPTY, new BorderWidths(0.20D))));
		} else {
			root.setBorder(null);

		}
	}

	public void init() {
		this.title_bar.setBackgroundColor(CarbonChatPalette.PALETTE.getDark());

		this.root.getChildren().add(title_bar);
	}
}
