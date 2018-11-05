package fr.carbonchat.software.interfaces.launcher;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSButton;
import fr.carbonchat.jfxswinger.swingers.JFXSRipplerButton;
import fr.carbonchat.jfxswinger.utils.ColorUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.CarbonChatSoftware;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class LauncherInterface extends Interface {

	public static final LauncherInterface INTERFACE = new LauncherInterface();

	/*
	 * Messages - L'application de vos rêve pour réaliser et organiser vos projets
	 * les plus fous
	 */

	public HBox boxManager = new HBox();

	public ImageView carbonChatLogo;
	public AnchorPane leftPane = new AnchorPane();
	public BorderPane containerBox = new BorderPane();

	public LauncherInterface() {
		AnchorPane.setBottomAnchor(boxManager, 0D);
		AnchorPane.setTopAnchor(boxManager, 0D);
		AnchorPane.setRightAnchor(boxManager, 0D);
		AnchorPane.setLeftAnchor(boxManager, 0D);

		this.leftPane.setPrefWidth(999875);
		this.leftPane.setBackground(new Background(
				new BackgroundFill(CarbonChatPalette.PALETTE.getDark(), CornerRadii.EMPTY, Insets.EMPTY)));

		AnchorPane.setTopAnchor(this.leftPane, 0D);
		AnchorPane.setLeftAnchor(this.leftPane, 0D);
		AnchorPane.setBottomAnchor(this.leftPane, 0D);

		/* CENTER LEFT PANE */
		VBox centerLeftPane = new VBox();
		centerLeftPane.setAlignment(Pos.CENTER);

		AnchorPane.setLeftAnchor(centerLeftPane, 0D);
		AnchorPane.setRightAnchor(centerLeftPane, 0D);
		AnchorPane.setTopAnchor(centerLeftPane, 0D);
		AnchorPane.setBottomAnchor(centerLeftPane, 0D);

		/* LOGO */
		HBox centerLogo = new HBox();
		centerLogo.setAlignment(Pos.CENTER);
		AnchorPane.setLeftAnchor(centerLogo, 0D);
		AnchorPane.setRightAnchor(centerLogo, 0D);

		carbonChatLogo = new ImageView(new Image(getClass().getResourceAsStream("/imgs/carbonchat-logo-128x128.png")));
		carbonChatLogo.setFitHeight(90);
		carbonChatLogo.setFitWidth(90);
		carbonChatLogo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				playLogoAnimation(null);				
			}
		});
		carbonChatLogo.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.carbonchat.fr/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			};
		});

		centerLogo.getChildren().add(carbonChatLogo);
		centerLogo.setPadding(new Insets(0, 0, 50, 0));
		centerLeftPane.getChildren().add(centerLogo);

		/* TEXT */
		Text text = new Text(CarbonChatSoftware.current_lang.message("home_welcome_message", "<br>", "\n"));

		/*
		 * "Bienvenue sur CarbonChat l'application de vos rêves " + "\n" +
		 * "pour réaliser et organiser vos projets les plus fous " + "\n" + "\n" +
		 * "CarbonChat est sous c'est première version il se peut" + "\n" +
		 * "que vous tombez sur des bug n'hésiter " + "\n" + "pas à nous les rapporter."
		 */

		text.setFont(JFXSwinger.getFont(18D));
		text.setFill(Color.WHITE);
		text.setTextAlignment(TextAlignment.CENTER);

		centerLeftPane.getChildren().add(text);

		Pane spacer = new Pane();
		spacer.setPrefHeight(50);
		spacer.setMinHeight(50);
		spacer.setMaxHeight(50);

		centerLeftPane.getChildren().add(spacer);

		JFXSRipplerButton button = new JFXSRipplerButton(CarbonChatSoftware.current_lang.message("i_have_a_problem")) {
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
					Desktop.getDesktop().browse(new URI("https://www.carbonchat.fr/contact/problem.php"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		};

		button.setBackgroundRadius(10, 10, 10, 10);
		button.setBackgroundColor(CarbonChatPalette.PALETTE.getInfo());
		button.setTextColor(CarbonChatPalette.PALETTE.getWhite());
		button.setPrefHeight(40);
		button.setFont(JFXSwinger.getFont(18D));

		centerLeftPane.getChildren().add(button);

		this.leftPane.getChildren().add(centerLeftPane);

		containerBox.setPrefWidth(999999);

		AnchorPane.setTopAnchor(containerBox, 0D);
		AnchorPane.setLeftAnchor(containerBox, 0D);
		AnchorPane.setRightAnchor(containerBox, 0D);
		AnchorPane.setBottomAnchor(containerBox, 0D);

		containerBox.setBackground(new Background(new BackgroundImage(
				new Image(getClass().getResourceAsStream("/imgs/launcher-background.png")), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

		VBox copyrightBox = new VBox();
		copyrightBox.setPrefHeight(25);
		copyrightBox.setAlignment(Pos.CENTER);
		copyrightBox.setBorder(new Border(new BorderStroke(CarbonChatPalette.PALETTE.getDark(), BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY, new BorderWidths(1))));
		copyrightBox.setBackground(new Background(
				new BackgroundFill(CarbonChatPalette.PALETTE.getDark(), CornerRadii.EMPTY, Insets.EMPTY)));

		AnchorPane.setLeftAnchor(copyrightBox, 0D);
		AnchorPane.setRightAnchor(copyrightBox, 0D);
		AnchorPane.setBottomAnchor(copyrightBox, 0D);

		Text copyrightText = new Text("CARBONCHAT 2018");
		copyrightText.setFont(JFXSwinger.getFont2(20D));
		copyrightText.setFill(CarbonChatPalette.PALETTE.getWhite());

		copyrightBox.getChildren().add(copyrightText);

		containerBox.setBottom(copyrightBox);

		boxManager.getChildren().add(leftPane);
		boxManager.getChildren().add(containerBox);

		this.getChildren().add(boxManager);
		// this.getChildren().add(leftPane);

		loadContainer(HomeLauncherInterface.INTERFACE);
	}

	RotateTransition rotateTransition;

	public void playLogoAnimation(Runnable onFinish) {
		if (rotateTransition != null)
			rotateTransition.stop();

		rotateTransition = new RotateTransition(Duration.millis(100), carbonChatLogo);
		rotateTransition.setFromAngle(-30);
		rotateTransition.setToAngle(30);
		rotateTransition.play();
		rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				rotateTransition = new RotateTransition(Duration.millis(100), carbonChatLogo);
				rotateTransition.setFromAngle(30);
				rotateTransition.setToAngle(-25);
				rotateTransition.play();
				rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						rotateTransition = new RotateTransition(Duration.millis(100), carbonChatLogo);
						rotateTransition.setFromAngle(-25);
						rotateTransition.setToAngle(20);
						rotateTransition.play();
						rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								rotateTransition = new RotateTransition(Duration.millis(100), carbonChatLogo);
								rotateTransition.setFromAngle(20);
								rotateTransition.setToAngle(-20);
								rotateTransition.play();
								rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent event) {
										rotateTransition = new RotateTransition(Duration.millis(100), carbonChatLogo);
										rotateTransition.setFromAngle(-20);
										rotateTransition.setToAngle(15);
										rotateTransition.play();
										rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
											@Override
											public void handle(ActionEvent event) {
												rotateTransition = new RotateTransition(Duration.millis(100),
														carbonChatLogo);
												rotateTransition.setFromAngle(15);
												rotateTransition.setToAngle(-15);
												rotateTransition.play();
												rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
													@Override
													public void handle(ActionEvent event) {
														rotateTransition = new RotateTransition(Duration.millis(100),
																carbonChatLogo);
														rotateTransition.setFromAngle(-15);
														rotateTransition.setToAngle(10);
														rotateTransition.play();
														rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
															@Override
															public void handle(ActionEvent event) {
																rotateTransition = new RotateTransition(
																		Duration.millis(100), carbonChatLogo);
																rotateTransition.setFromAngle(10);
																rotateTransition.setToAngle(-10);
																rotateTransition.play();
																rotateTransition
																		.setOnFinished(new EventHandler<ActionEvent>() {
																			@Override
																			public void handle(ActionEvent event) {
																				rotateTransition = new RotateTransition(
																						Duration.millis(100),
																						carbonChatLogo);
																				rotateTransition.setFromAngle(-10);
																				rotateTransition.setToAngle(5);
																				rotateTransition.play();
																				rotateTransition.setOnFinished(
																						new EventHandler<ActionEvent>() {
																							@Override
																							public void handle(
																									ActionEvent event) {
																								rotateTransition = new RotateTransition(
																										Duration.millis(
																												100),
																										carbonChatLogo);
																								rotateTransition
																										.setFromAngle(
																												5);
																								rotateTransition
																										.setToAngle(-5);
																								rotateTransition.play();
																								rotateTransition
																										.setOnFinished(
																												new EventHandler<ActionEvent>() {
																													@Override
																													public void handle(
																															ActionEvent event) {
																														rotateTransition = new RotateTransition(
																																Duration.millis(
																																		100),
																																carbonChatLogo);
																														rotateTransition
																																.setFromAngle(
																																		-5);
																														rotateTransition
																																.setToAngle(
																																		3);
																														rotateTransition
																																.play();
																														rotateTransition
																																.setOnFinished(
																																		new EventHandler<ActionEvent>() {
																																			@Override
																																			public void handle(
																																					ActionEvent event) {
																																				rotateTransition = new RotateTransition(
																																						Duration.millis(
																																								100),
																																						carbonChatLogo);
																																				rotateTransition
																																						.setFromAngle(
																																								3);
																																				rotateTransition
																																						.setToAngle(
																																								-3);
																																				rotateTransition
																																						.play();
																																				rotateTransition
																																						.setOnFinished(
																																								new EventHandler<ActionEvent>() {
																																									@Override
																																									public void handle(
																																											ActionEvent event) {
																																										rotateTransition = new RotateTransition(
																																												Duration.millis(
																																														100),
																																												carbonChatLogo);
																																										rotateTransition
																																												.setFromAngle(
																																														-3);
																																										rotateTransition
																																												.setToAngle(
																																														1);
																																										rotateTransition
																																												.play();
																																										rotateTransition
																																												.setOnFinished(
																																														new EventHandler<ActionEvent>() {
																																															@Override
																																															public void handle(
																																																	ActionEvent event) {
																																																rotateTransition = new RotateTransition(
																																																		Duration.millis(
																																																				100),
																																																		carbonChatLogo);
																																																rotateTransition
																																																		.setFromAngle(
																																																				1);
																																																rotateTransition
																																																		.setToAngle(
																																																				-1);
																																																rotateTransition
																																																		.play();
																																																rotateTransition
																																																		.setOnFinished(
																																																				new EventHandler<ActionEvent>() {
																																																					@Override
																																																					public void handle(
																																																							ActionEvent event) {
																																																						rotateTransition = new RotateTransition(
																																																								Duration.millis(
																																																										100),
																																																								carbonChatLogo);
																																																						rotateTransition
																																																								.setFromAngle(
																																																										-1);
																																																						rotateTransition
																																																								.setToAngle(
																																																										0);
																																																						rotateTransition
																																																								.play();
																																																						rotateTransition
																																																								.setOnFinished(
																																																										new EventHandler<ActionEvent>() {
																																																											@Override
																																																											public void handle(
																																																													ActionEvent event) {
																																																												if (onFinish != null)
																																																													onFinish.run();
																																																											}
																																																										});
																																																					}
																																																				});
																																															}
																																														});
																																									}
																																								});
																																			}
																																		});
																													}
																												});
																							}
																						});
																			}
																		});
															}
														});
													}
												});
											}
										});
									}
								});
							}
						});
					}
				});
			}
		});
	}

	public void loadContainer(AnchorPane container) {
		this.containerBox.setCenter(container);
	}
}
