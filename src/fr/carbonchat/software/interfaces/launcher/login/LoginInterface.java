package fr.carbonchat.software.interfaces.launcher.login;

import java.util.Timer;
import java.util.TimerTask;

import com.jfoenix.controls.JFXCheckBox;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import fr.carbonchat.api.requests.request.AuthRequest;
import fr.carbonchat.api.requests.response.Response;
import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSButton;
import fr.carbonchat.jfxswinger.swingers.JFXSIconMaterialDesign;
import fr.carbonchat.jfxswinger.swingers.JFXSPasswordField;
import fr.carbonchat.jfxswinger.swingers.JFXSRipplerButton;
import fr.carbonchat.jfxswinger.swingers.JFXSTextField;
import fr.carbonchat.jfxswinger.utils.CSSUtils;
import fr.carbonchat.jfxswinger.utils.ColorUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.CarbonChatSoftware;
import fr.carbonchat.software.interfaces.launcher.HomeLauncherInterface;
import fr.carbonchat.software.interfaces.launcher.LauncherInterface;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LoginInterface extends Interface {

	public static final LoginInterface INTERFACE = new LoginInterface();

	public VBox container = new VBox();
	public VBox notification = new VBox();

	public JFXSTextField emailField;
	public JFXSPasswordField passwordField;
	public JFXSRipplerButton connectionButton;
	public JFXCheckBox saveAuth = new JFXCheckBox("");
	public RotateTransition closeAnimation;

	public LoginInterface() {
		this.notification.setAlignment(Pos.CENTER);
		this.notification.setVisible(false);
		this.notification.setMaxHeight(40);
		this.notification.setMinHeight(40);

		AnchorPane.setTopAnchor(this.notification, 0D);
		AnchorPane.setLeftAnchor(this.notification, 0D);
		AnchorPane.setRightAnchor(this.notification, 0D);

		JFXSButton close = new JFXSButton("", new JFXSIconMaterialDesign(MaterialDesignIcon.CLOSE)) {
			@Override
			public void mouseEntered() {
				if (closeAnimation != null) {
					closeAnimation.stop();

					double lastAngle = getRotate();

					closeAnimation.setFromAngle(lastAngle);
					closeAnimation.setToAngle((90 * 4 - lastAngle));
					closeAnimation.play();
				} else {
					closeAnimation = new RotateTransition(Duration.millis(1000), this);
					closeAnimation.setFromAngle(0);
					closeAnimation.setToAngle(90 * 4);
					closeAnimation.play();
				}
			}

			@Override
			public void mouseExited() {
				if (closeAnimation != null) {
					double lastAngle = getRotate();

					closeAnimation.stop();

					closeAnimation.setFromAngle(lastAngle);
					closeAnimation.setToAngle(0);
					closeAnimation.play();
				}
			}

			@Override
			public void mousePressed() {
			}

			@Override
			public void mouseReleased() {
			}

			@Override
			public void mouseClick() {
				if (closeAnimation != null) {
					closeAnimation.stop();

					double lastAngle = getRotate();

					closeAnimation.setDuration(Duration.millis(1));
					closeAnimation.setFromAngle(lastAngle);
					closeAnimation.setToAngle(0);
					closeAnimation.play();
					closeAnimation.setDuration(Duration.millis(1000));
				}

				emailField.setText("");
				passwordField.setText("");
				notification.setVisible(false);
				LauncherInterface.INTERFACE.loadContainer(HomeLauncherInterface.INTERFACE);
			}
		};
		close.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		close.setPrefWidth(32);
		close.setPrefHeight(32);
		close.setMinWidth(32);
		close.setMinHeight(32);
		close.icon.setIconColor(CarbonChatPalette.PALETTE.getDanger());
		close.icon.setIconSize((int) 30);

		AnchorPane.setTopAnchor(close, 50D);
		AnchorPane.setLeftAnchor(close, 2D);

		AnchorPane.setTopAnchor(this, 0D);
		AnchorPane.setBottomAnchor(this, 0D);
		AnchorPane.setLeftAnchor(this, 0D);
		AnchorPane.setRightAnchor(this, 0D);

		this.container.setAlignment(Pos.CENTER);

		AnchorPane.setTopAnchor(this.container, 0D);
		AnchorPane.setBottomAnchor(this.container, 0D);
		AnchorPane.setLeftAnchor(this.container, 0D);
		AnchorPane.setRightAnchor(this.container, 0D);

		VBox emailBox = new VBox();
		emailBox.setMaxWidth(380);

		Text textEmail = new Text(CarbonChatSoftware.current_lang.message("email_text"));
		textEmail.setFill(CarbonChatPalette.PALETTE.getWhite());
		textEmail.setFont(JFXSwinger.getFont(18));

		emailField = new JFXSTextField(380, 40) {
			@Override
			public void mouseReleased() {
			}

			@Override
			public void mousePressed() {
			}

			@Override
			public void mouseExited() {
			}

			@Override
			public void mouseEntered() {
			}

			@Override
			public void mouseClick() {
			}
		};
		emailField.setFocusColor(CarbonChatPalette.PALETTE.getInfo());
		emailField.setBorderColor(CarbonChatPalette.PALETTE.getLight());
		emailField.setTextColor(CarbonChatPalette.PALETTE.getWhite());
		emailField.setBackgroundColor(CarbonChatPalette.PALETTE.getDark());
		emailField.setBackgroundRadius(25, 25, 25, 25);
		emailField.setBorderRadius(25, 25, 25, 25);
		emailField.setMaxHeight(40);
		emailField.setFont(JFXSwinger.getFont(18));

		VBox passwordBox = new VBox();
		passwordBox.setMaxWidth(380);

		Text textPassword = new Text(CarbonChatSoftware.current_lang.message("password_text"));
		textPassword.setFill(CarbonChatPalette.PALETTE.getWhite());
		textPassword.setFont(JFXSwinger.getFont(18));

		passwordField = new JFXSPasswordField(380, 40) {
			@Override
			public void mouseReleased() {
			}

			@Override
			public void mousePressed() {
			}

			@Override
			public void mouseExited() {
			}

			@Override
			public void mouseEntered() {
			}

			@Override
			public void mouseClick() {
			}
		};
		passwordField.setFocusColor(CarbonChatPalette.PALETTE.getInfo());
		passwordField.setBorderColor(CarbonChatPalette.PALETTE.getLight());
		passwordField.setTextColor(CarbonChatPalette.PALETTE.getWhite());
		passwordField.setBackgroundColor(CarbonChatPalette.PALETTE.getDark());
		passwordField.setBackgroundRadius(25, 25, 25, 25);
		passwordField.setBorderRadius(25, 25, 25, 25);
		passwordField.setMaxHeight(40);
		passwordField.setFont(JFXSwinger.getFont(18));

		connectionButton = new JFXSRipplerButton(CarbonChatSoftware.current_lang.message("connection_button_text")) {
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
				login(emailField.getText(), passwordField.getText());
			}
		};

		connectionButton.setBackgroundRadius(10, 10, 10, 10);
		connectionButton.setBackgroundColor(CarbonChatPalette.PALETTE.getInfo());
		connectionButton.setTextColor(CarbonChatPalette.PALETTE.getWhite());
		connectionButton.setMinWidth(330);
		connectionButton.setPrefHeight(50);
		connectionButton.setFont(JFXSwinger.getFont(22D));

		emailBox.getChildren().add(textEmail);
		emailBox.getChildren().add(emailField);

		passwordBox.getChildren().add(textPassword);
		passwordBox.getChildren().add(passwordField);

		Pane spacer = new Pane();
		spacer.setPrefHeight(25);
		spacer.setMinHeight(25);
		spacer.setMaxHeight(25);

		container.getChildren().add(emailBox);
		container.getChildren().add(spacer);
		container.getChildren().add(passwordBox);

		spacer = new Pane();
		spacer.setPrefHeight(25);
		spacer.setMinHeight(25);
		spacer.setMaxHeight(25);

		this.saveAuth.setFont(JFXSwinger.getFont(18));
		this.saveAuth.setTextFill(CarbonChatPalette.PALETTE.getWhite());
		this.saveAuth.setUnCheckedColor(CarbonChatPalette.PALETTE.getWhite());
		this.saveAuth.setText(CarbonChatSoftware.current_lang.message("save_check_box"));

		container.getChildren().add(spacer);
		container.getChildren().add(saveAuth);

		spacer = new Pane();
		spacer.setPrefHeight(25);
		spacer.setMinHeight(25);
		spacer.setMaxHeight(25);

		container.getChildren().add(spacer);
		container.getChildren().add(connectionButton);

		getChildren().add(this.container);
		getChildren().add(this.notification);
		getChildren().add(close);
	}

	public void login(String email, String password) {
		notification.getChildren().clear();

		CSSUtils cssUtils = new CSSUtils(notification);

		Text text = new Text("");
		text.setFill(CarbonChatPalette.PALETTE.getWhite());
		text.setFont(JFXSwinger.getFont(18));

		notification.getChildren().add(text);

		notification.setVisible(true);
		
		if (email.equals("") || password.equals("")) {
			cssUtils.addCSS("-fx-background-color", ColorUtils.convertColor(CarbonChatPalette.PALETTE.getDanger()));
			text.setText(CarbonChatSoftware.current_lang.message("textfield_empty"));
			return;
		} 

		text.setText(CarbonChatSoftware.current_lang.message("current_connection"));
		cssUtils.addCSS("-fx-background-color", ColorUtils.convertColor(CarbonChatPalette.PALETTE.getInfo()));

		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				toggleConnectionLoadingEffect(text);
				Response response = new AuthRequest(email, password).send();
				connection_loading_effect = false;

				cssUtils.addCSS("-fx-background-color", ColorUtils.convertColor(CarbonChatPalette.PALETTE.getInfo()));

				if (response != null) {
					if (response.success) {
						cssUtils.addCSS("-fx-background-color",
								ColorUtils.convertColor(CarbonChatPalette.PALETTE.getSuccess()));
					} else {
						cssUtils.addCSS("-fx-background-color",
								ColorUtils.convertColor(CarbonChatPalette.PALETTE.getDanger()));
					}
					text.setText(CarbonChatSoftware.current_lang.message(response.message));
				} else {
					cssUtils.addCSS("-fx-background-color",
							ColorUtils.convertColor(CarbonChatPalette.PALETTE.getDanger()));
					text.setText("response_null");
				}
			}
		}, 1000);
	}
	
	public boolean connection_loading_effect = true;
	
	public void toggleConnectionLoadingEffect(Text text) {
		connection_loading_effect = true;
		new Timer().schedule(new TimerTask() {
			int i = 0;
			String text_ = text.getText();
			@Override
			public void run() {
				if(!connection_loading_effect) {
					cancel();
					return;
				}
				if(i == 0) {
					text.setText(text_.substring(0, text_.length() - 2));
				} else if (i == 1) {
					text.setText(text_.substring(0, text_.length() - 1));
				} else {
					text.setText(text_.substring(0, text_.length()));
					i = 0;
					return;
				}
				i++;
			}
		}, 0, 750);
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
}
