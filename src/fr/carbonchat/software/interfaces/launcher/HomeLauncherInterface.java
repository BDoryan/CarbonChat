package fr.carbonchat.software.interfaces.launcher;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSRipplerButton;
import fr.carbonchat.jfxswinger.utils.ColorUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.CarbonChatSoftware;
import fr.carbonchat.software.interfaces.launcher.login.LoginInterface;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HomeLauncherInterface extends Interface {
	
	public static final Interface INTERFACE = new HomeLauncherInterface();
	
	public VBox container = new VBox();
	
	public HomeLauncherInterface() {
		AnchorPane.setTopAnchor(this, 0D);
		AnchorPane.setBottomAnchor(this, 0D);
		AnchorPane.setLeftAnchor(this, 0D);
		AnchorPane.setRightAnchor(this, 0D);

		this.container.setAlignment(Pos.CENTER);
		
		AnchorPane.setTopAnchor(this.container, 0D);
		AnchorPane.setBottomAnchor(this.container, 0D);
		AnchorPane.setLeftAnchor(this.container, 0D);
		AnchorPane.setRightAnchor(this.container, 0D);
		
		JFXSRipplerButton loginButton = new JFXSRipplerButton(CarbonChatSoftware.current_lang.message("connection_button_text")) {
			@Override
			public void mouseReleased() {

			}

			@Override
			public void mousePressed() {
			}

			@Override
			public void mouseExited() {
				setBackgroundColor(CarbonChatPalette.PALETTE.getInfo());
				setTextColor(CarbonChatPalette.PALETTE.getWhite());
			}

			@Override
			public void mouseEntered() {
				setBackgroundColor(ColorUtils.darkenColor(CarbonChatPalette.PALETTE.getInfo(), 25));
				setTextColor(CarbonChatPalette.PALETTE.getWhite());
			}
			
			@Override
			public void mouseClick() {
				LauncherInterface.INTERFACE.loadContainer(LoginInterface.INTERFACE);
			}
		};

		loginButton.setBackgroundRadius(10, 10, 10, 10);
		loginButton.setBackgroundColor(CarbonChatPalette.PALETTE.getInfo());
		loginButton.setTextColor(CarbonChatPalette.PALETTE.getWhite());
		loginButton.setMinWidth(330);
		loginButton.setPrefHeight(50);
		loginButton.setFont(JFXSwinger.getFont(22D));

		JFXSRipplerButton registerButton = new JFXSRipplerButton(CarbonChatSoftware.current_lang.message("register_button_text")) {
			@Override
			public void mouseReleased() {

			}

			@Override
			public void mousePressed() {
			}

			@Override
			public void mouseExited() {
				setBackgroundColor(CarbonChatPalette.PALETTE.getInfo());
				setTextColor(CarbonChatPalette.PALETTE.getWhite());
			}

			@Override
			public void mouseEntered() {
				setBackgroundColor(ColorUtils.darkenColor(CarbonChatPalette.PALETTE.getInfo(), 25));
				setTextColor(CarbonChatPalette.PALETTE.getWhite());
			}
			
			@Override
			public void mouseClick() {
				try {
					Desktop.getDesktop().browse(new URI("https://www.carbonchat.fr/register.php"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		};

		registerButton.setBackgroundRadius(10, 10, 10, 10);
		registerButton.setBackgroundColor(CarbonChatPalette.PALETTE.getInfo());
		registerButton.setTextColor(CarbonChatPalette.PALETTE.getWhite());
		registerButton.setWrapText(true);
		registerButton.setMinWidth(330);
		registerButton.setPrefHeight(50);
		registerButton.setFont(JFXSwinger.getFont(22D));
		
		Pane spacer = new Pane();
		spacer.setPrefHeight(50);
		spacer.setMinHeight(50);
		spacer.setMaxHeight(50);

		container.getChildren().add(loginButton);
		container.getChildren().add(spacer);
		container.getChildren().add(registerButton);
		
		getChildren().add(this.container);
	}
}
