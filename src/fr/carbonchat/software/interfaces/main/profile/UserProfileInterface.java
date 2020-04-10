package fr.carbonchat.software.interfaces.main.profile;

import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSImageView;
import fr.carbonchat.jfxswinger.utils.CSSUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.CarbonChatSoftware;
import fr.carbonchat.software.core.swinger.Project;
import fr.carbonchat.software.core.swinger.User;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class UserProfileInterface extends Interface {

	public ScrollPane scrollPane;
	public AnchorPane container;

	public UserProfileInterface(User user) {
		this.container = new AnchorPane();

		String twitter = user.getSocialNetwork(User.SOCIAL_NETWORK_TWITTER);
		String facebook = user.getSocialNetwork(User.SOCIAL_NETWORK_FACEBOOK);
		String youtube = user.getSocialNetwork(User.SOCIAL_NETWORK_YOUTUBE);
		String github = user.getSocialNetwork(User.SOCIAL_NETWORK_GITHUB);

		VBox socialNetworkBoxLeft = new VBox(80);
		AnchorPane.setLeftAnchor(socialNetworkBoxLeft, 10D);
		AnchorPane.setTopAnchor(socialNetworkBoxLeft, 20D);

		VBox socialNetworkBoxRight = new VBox(socialNetworkBoxLeft.getSpacing());
		AnchorPane.setRightAnchor(socialNetworkBoxRight, 10D);
		AnchorPane.setTopAnchor(socialNetworkBoxRight, 20D);

		HBox centerLogoUser = new HBox();
		centerLogoUser.setAlignment(Pos.CENTER);

		ImageView logoImage = new ImageView(user.getLogo(160, 160));

		VBox logoBox = new VBox();

		Circle userStatus = new Circle(12);

		if (user.getStatus() == User.STATUS_ONLINE) {
			userStatus.setFill(CarbonChatPalette.PALETTE.getSuccess());
		} else if (user.getStatus() == User.STATUS_OFFLINE) {
			userStatus.setFill(CarbonChatPalette.PALETTE.getHalfDark());
		} else if (user.getStatus() == User.STATUS_INACTIVE) {
			userStatus.setFill(CarbonChatPalette.PALETTE.getWarning());
		} else if (user.getStatus() == User.STATUS_DO_NOT_DISTURB) {
			userStatus.setFill(CarbonChatPalette.PALETTE.getDanger());
		}

		Label username = new Label(" " + user.getUsername());
		logoBox.setAlignment(Pos.CENTER);
		username.setFont(JFXSwinger.getFont(22));
		username.setTextFill(Color.WHITE);
		username.setGraphic(userStatus);

		logoBox.getChildren().add(logoImage);
		logoBox.getChildren().add(username);

		centerLogoUser.getChildren().add(logoBox);

		this.container.getChildren().add(logoBox);
		this.container.getChildren().add(socialNetworkBoxLeft);
		this.container.getChildren().add(socialNetworkBoxRight);

		AnchorPane.setTopAnchor(logoBox, 15D);
		AnchorPane.setRightAnchor(logoBox, 0D);
		AnchorPane.setLeftAnchor(logoBox, 0D);

		if (twitter != null) {
			if (socialNetworkBoxLeft.getChildren().size() - socialNetworkBoxRight.getChildren().size() == 0) {
				HBox social_network = generateSocialNetwork(twitter, "/imgs/twitter-white.png", true);
				socialNetworkBoxLeft.getChildren().add(social_network);
			} else {
				HBox social_network = generateSocialNetwork(twitter, "/imgs/twitter-white.png", false);
				socialNetworkBoxRight.getChildren().add(social_network);
			}
		}

		if (facebook != null) {
			if (socialNetworkBoxLeft.getChildren().size() - socialNetworkBoxRight.getChildren().size() == 0) {
				HBox social_network = generateSocialNetwork(facebook, "/imgs/facebook-white.png", true);
				socialNetworkBoxLeft.getChildren().add(social_network);
			} else {
				HBox social_network = generateSocialNetwork(facebook, "/imgs/facebook-white.png", false);
				socialNetworkBoxRight.getChildren().add(social_network);
			}
		}

		if (github != null) {
			if (socialNetworkBoxLeft.getChildren().size() - socialNetworkBoxRight.getChildren().size() == 0) {
				HBox social_network = generateSocialNetwork(github, "/imgs/github-white.png", true);
				socialNetworkBoxLeft.getChildren().add(social_network);
			} else {
				HBox social_network = generateSocialNetwork(github, "/imgs/github-white.png", false);
				socialNetworkBoxRight.getChildren().add(social_network);
			}
		}

		if (youtube != null) {
			if (socialNetworkBoxLeft.getChildren().size() - socialNetworkBoxRight.getChildren().size() == 0) {
				HBox social_network = generateSocialNetwork(youtube, "/imgs/youtube-white.png", true);
				socialNetworkBoxLeft.getChildren().add(social_network);
			} else {
				HBox social_network = generateSocialNetwork(youtube, "/imgs/youtube-white.png", false);
				socialNetworkBoxRight.getChildren().add(social_network);
			}
		}

		Label descriptionBox = new Label(user.getDescription().substring(0, 120));
		descriptionBox.setTextFill(Color.WHITE);
		descriptionBox.setFont(JFXSwinger.getFont(18));
		descriptionBox.setPadding(new Insets(10, 10, 10, 10));
		descriptionBox.setAlignment(Pos.TOP_LEFT);
		descriptionBox.setWrapText(true);

		CSSUtils descriptionBoxCSS = new CSSUtils(descriptionBox);
		descriptionBoxCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		descriptionBoxCSS.setBackgroundRadius(10, 10, 10, 10);

		AnchorPane.setTopAnchor(descriptionBox, 250D);
		AnchorPane.setRightAnchor(descriptionBox, 20D);
		AnchorPane.setLeftAnchor(descriptionBox, 20D);

		this.container.getChildren().add(descriptionBox);

		/* BOTTOM */

		AnchorPane projectsPane = new AnchorPane();
		projectsPane.setMinWidth(500);

		AnchorPane.setTopAnchor(projectsPane, 380D);
		AnchorPane.setBottomAnchor(projectsPane, 0D);
		AnchorPane.setLeftAnchor(projectsPane, 0D);

		Label projectsText = new Label(CarbonChatSoftware.current_lang.get("user_interface_projects"));
		projectsText.setAlignment(Pos.CENTER);
		projectsText.setFont(JFXSwinger.getFont(22));
		projectsText.setTextFill(Color.WHITE);

		AnchorPane.setTopAnchor(projectsText, 10D);
		AnchorPane.setLeftAnchor(projectsText, 0D);
		AnchorPane.setRightAnchor(projectsText, 0D);
		
		VBox projectsBox = new VBox(20);
		projectsBox.setAlignment(Pos.CENTER);
		projectsBox.setPadding(new Insets(20, 0, 0, 0));
		
		for(Project project : user.getProjects()) {
			projectsBox.getChildren().add(generateProject(project));
		}

		AnchorPane.setTopAnchor(projectsBox, 40D);
		AnchorPane.setLeftAnchor(projectsBox, 0D);
		AnchorPane.setRightAnchor(projectsBox, 0D);
		
		projectsPane.getChildren().add(projectsText);
		projectsPane.getChildren().add(projectsBox);
		
		/* ANNONCES */

		AnchorPane adsPane = new AnchorPane();

		AnchorPane.setTopAnchor(adsPane, 380D);
		AnchorPane.setBottomAnchor(adsPane, 0D);
		AnchorPane.setLeftAnchor(adsPane, projectsPane.getMinWidth());
		AnchorPane.setRightAnchor(adsPane, 0D);
		
		Label adsText = new Label(CarbonChatSoftware.current_lang.get("user_interface_ads"));
		adsText.setAlignment(Pos.CENTER);
		adsText.setFont(JFXSwinger.getFont(22));
		adsText.setTextFill(Color.WHITE);

		AnchorPane.setTopAnchor(adsText, 10D);
		AnchorPane.setLeftAnchor(adsText, 0D);
		AnchorPane.setRightAnchor(adsText, 0D);

		adsPane.getChildren().add(adsText);

		this.container.getChildren().add(adsPane);
		this.container.getChildren().add(projectsPane);

		this.scrollPane = new ScrollPane(this.container);
		this.scrollPane.setFitToWidth(true);
		this.scrollPane.setFitToHeight(true);

		AnchorPane.setTopAnchor(this.scrollPane, 0D);
		AnchorPane.setRightAnchor(this.scrollPane, 0D);
		AnchorPane.setBottomAnchor(this.scrollPane, 0D);
		AnchorPane.setLeftAnchor(this.scrollPane, 0D);

		CSSUtils scrollPaneCSS = new CSSUtils(this.scrollPane);
		scrollPaneCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());

		CSSUtils containerCSS = new CSSUtils(this.container);
		containerCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());

		this.getChildren().add(this.scrollPane);
	}

	public VBox generateProject(Project project) {
		VBox project_vbox = new VBox();
		project_vbox.setAlignment(Pos.CENTER);

		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(1.90);
		dropShadow.setOffsetY(1.90);
		dropShadow.setColor(Color.BLACK);

		Image logo_image = project.getLogo(70, 70);
		JFXSImageView logo = null;

		if (logo_image != null) {
			logo = new JFXSImageView(logo_image);

			project_vbox.getChildren().add(logo);
		}

		Text title = new Text(project.getName());
		title.setFill(Color.WHITE);
		title.setFont(JFXSwinger.getFont(18));

		project_vbox.getChildren().add(title);

		project_vbox.setCursor(Cursor.HAND);

		title.setSmooth(true);
		logo.setSmooth(true);

		ScaleTransition enterTransition = new ScaleTransition(Duration.millis(100), title);
		ScaleTransition exitTransition = new ScaleTransition(Duration.millis(100), title);

		RotateTransition rotateTransition = new RotateTransition(Duration.millis(350), logo);
		rotateTransition.setFromAngle(0);
		rotateTransition.setToAngle(360);

		project_vbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				rotateTransition.playFromStart();
			};
		});

		project_vbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitTransition.stop();

				enterTransition.setFromX(getScaleX());
				enterTransition.setFromY(getScaleY());
				enterTransition.setToX(1.08);
				enterTransition.setToY(1.08);
				enterTransition.playFromStart();
			};
		});

		project_vbox.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				enterTransition.stop();

				exitTransition.setFromX(enterTransition.getToX());
				exitTransition.setFromY(enterTransition.getToY());
				exitTransition.setToX(1);
				exitTransition.setToY(1);
				exitTransition.playFromStart();
			};
		});

		return project_vbox;
	}

	public HBox generateSocialNetwork(String text, String imagePath, boolean onRight) {
		HBox hbox = new HBox(5);
		hbox.setMinWidth(200);
		hbox.setMinHeight(40);
		hbox.setAlignment(Pos.CENTER);

		ScaleTransition enterTransition = new ScaleTransition(Duration.millis(100), hbox);
		ScaleTransition exitTransition = new ScaleTransition(Duration.millis(100), hbox);

		hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
			};
		});

		hbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitTransition.stop();

				enterTransition.setFromX(getScaleX());
				enterTransition.setFromY(getScaleY());
				enterTransition.setToX(1.04);
				enterTransition.setToY(1.04);
				enterTransition.playFromStart();
			};
		});

		hbox.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				enterTransition.stop();

				exitTransition.setFromX(enterTransition.getToX());
				exitTransition.setFromY(enterTransition.getToY());
				exitTransition.setToX(1);
				exitTransition.setToY(1);
				exitTransition.playFromStart();
			};
		});

		CSSUtils hboxCSS = new CSSUtils(hbox);
		hboxCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getLight());
		hboxCSS.setBorderRadius(25, 25, 25, 25);
		hboxCSS.setBackgroundRadius(25, 25, 25, 25);

		Label label = new Label(text);
		label.setFont(JFXSwinger.getFont(20));
		label.setTextFill(Color.WHITE);

		if (onRight) {
			hbox.getChildren().add(generateImageView(imagePath));
			hbox.getChildren().add(label);
		} else {
			hbox.getChildren().add(label);
			hbox.getChildren().add(generateImageView(imagePath));
		}
		
		return hbox;
	}

	public ImageView generateImageView(String path) {
		System.out.println("path: " + path);
		Image image = new Image(getClass().getResourceAsStream(path), 25, 25, true, true);

		return new ImageView(image);
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
	}
}
