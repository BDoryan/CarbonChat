package fr.carbonchat.software.interfaces.home;

import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSButton;
import fr.carbonchat.jfxswinger.swingers.JFXSIconMaterial;
import fr.carbonchat.jfxswinger.utils.CSSUtils;
import fr.carbonchat.jfxswinger.utils.ColorUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.CarbonChatSoftware;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainInterface extends Interface {

	public static final MainInterface INTERFACE = new MainInterface();

	public AnchorPane navbar = new AnchorPane();
	
	public Label usernameText;
	
	public JFXSButton navbarButton;
	
	public JFXSButton homeButton;
	public JFXSButton announcesButton;
	public JFXSButton myProjectsButton;
	public JFXSButton contactsButton;
	public JFXSButton settingsButton;
	
	public MainInterface() {
		this.cssUtils.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());
		
		CSSUtils navbarCSS = new CSSUtils(navbar);
		navbarCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		
		AnchorPane.setLeftAnchor(navbar, 0D);
		AnchorPane.setBottomAnchor(navbar, 0D);
		AnchorPane.setTopAnchor(navbar, 0D);
		
		this.navbar.setMinWidth(260);
		
		/*

		JFXSIconMaterial icon = new JFXSIconMaterial(MaterialIcon.TOC);
		icon.setIconSize(32);
		icon.setIconColor(Color.WHITE);
		
		this.navbarButton = new JFXSButton("", icon) {
			@Override
			public void mouseReleased() {
			}
			
			@Override
			public void mousePressed() {
			}
			
			@Override
			public void mouseExited() {
				icon.setIconColor(CarbonChatPalette.PALETTE.getWhite());
			}
			
			@Override
			public void mouseEntered() {
				icon.setIconColor(ColorUtils.darkenColor(icon.getCurrentColor(), 55));
			}
			
			@Override
			public void mouseClick() {
			}
		};
		
		AnchorPane.setRightAnchor(navbarButton, 10D);
		AnchorPane.setTopAnchor(navbarButton, 10D);
		
		this.navbar.getChildren().add(navbarButton);*/
		this.getChildren().add(navbar);
		
		VBox buttonList = new VBox();

		AnchorPane.setLeftAnchor(buttonList, 0D);
		AnchorPane.setBottomAnchor(buttonList, 60D);
		AnchorPane.setTopAnchor(buttonList, 10D);
		
		Font buttonFont = JFXSwinger.getFont(20D);
		
		JFXSIconMaterial annoncementIcon = new JFXSIconMaterial(MaterialIcon.DESCRIPTION);
		annoncementIcon.setIconSize(24);
		annoncementIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial myProjectsIcon = new JFXSIconMaterial(MaterialIcon.WORK);
		myProjectsIcon.setIconSize(24);
		myProjectsIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial settingsIcon = new JFXSIconMaterial(MaterialIcon.SETTINGS);
		settingsIcon.setIconSize(24);
		settingsIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial contactsIcon = new JFXSIconMaterial(MaterialIcon.CONTACTS);
		contactsIcon.setIconSize(24);
		contactsIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial homeIcon = new JFXSIconMaterial(MaterialIcon.HOME);
		homeIcon.setIconSize(24);
		homeIcon.setIconColor(Color.WHITE);
		
		this.homeButton = new JFXSButton(CarbonChatSoftware.current_lang.get("navbar_home"), homeIcon) {
			@Override
			public void mouseReleased() {
			}
			
			@Override
			public void mousePressed() {
			}
			
			@Override
			public void mouseExited() {
				setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
			}
			
			@Override
			public void mouseEntered() {
				setBackgroundColor(ColorUtils.darkenColor(CarbonChatPalette.PALETTE.getHalfDark(), 7));
			}
			
			@Override
			public void mouseClick() {
			}
		};
		this.homeButton.setFont(buttonFont);
		this.homeButton.setTextFill(Color.WHITE);
		this.homeButton.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		this.homeButton.setAlignment(Pos.CENTER_LEFT);
		this.homeButton.setMinWidth(this.navbar.getMinWidth());
		
		buttonList.getChildren().add(this.homeButton);
		
		this.announcesButton = new JFXSButton(CarbonChatSoftware.current_lang.get("navbar_announces"), annoncementIcon) {
			@Override
			public void mouseReleased() {
			}
			
			@Override
			public void mousePressed() {
			}
			
			@Override
			public void mouseExited() {
				setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
			}
			
			@Override
			public void mouseEntered() {
				setBackgroundColor(ColorUtils.darkenColor(CarbonChatPalette.PALETTE.getHalfDark(), 7));
			}
			
			@Override
			public void mouseClick() {
			}
		};
		this.announcesButton.setFont(buttonFont);
		this.announcesButton.setTextFill(Color.WHITE);
		this.announcesButton.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		this.announcesButton.setAlignment(Pos.CENTER_LEFT);
		this.announcesButton.setMinWidth(this.navbar.getMinWidth());
		
		buttonList.getChildren().add(this.announcesButton);
		
		this.myProjectsButton = new JFXSButton(CarbonChatSoftware.current_lang.get("navbar_myprojects"), myProjectsIcon) {
			@Override
			public void mouseReleased() {
			}
			
			@Override
			public void mousePressed() {
			}
			
			@Override
			public void mouseExited() {
				setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
			}
			
			@Override
			public void mouseEntered() {
				setBackgroundColor(ColorUtils.darkenColor(CarbonChatPalette.PALETTE.getHalfDark(), 7));
			}
			
			@Override
			public void mouseClick() {
			}
		};
		this.myProjectsButton.setFont(buttonFont);
		this.myProjectsButton.setTextFill(Color.WHITE);
		this.myProjectsButton.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		this.myProjectsButton.setAlignment(Pos.CENTER_LEFT);
		this.myProjectsButton.setMinWidth(this.navbar.getMinWidth());
		
		buttonList.getChildren().add(this.myProjectsButton);
		
		this.contactsButton = new JFXSButton(CarbonChatSoftware.current_lang.get("navbar_contacts"), contactsIcon) {
			@Override
			public void mouseReleased() {
			}
			
			@Override
			public void mousePressed() {
			}
			
			@Override
			public void mouseExited() {
				setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
			}
			
			@Override
			public void mouseEntered() {
				setBackgroundColor(ColorUtils.darkenColor(CarbonChatPalette.PALETTE.getHalfDark(), 7));
			}
			
			@Override
			public void mouseClick() {
			}
		};
		this.contactsButton.setFont(buttonFont);
		this.contactsButton.setTextFill(Color.WHITE);
		this.contactsButton.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		this.contactsButton.setAlignment(Pos.CENTER_LEFT);
		this.contactsButton.setMinWidth(this.navbar.getMinWidth());
		
		buttonList.getChildren().add(this.contactsButton);
		
		this.settingsButton = new JFXSButton(CarbonChatSoftware.current_lang.get("navbar_settings"), settingsIcon) {
			@Override
			public void mouseReleased() {
			}
			
			@Override
			public void mousePressed() {
			}
			
			@Override
			public void mouseExited() {
				setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
			}
			
			@Override
			public void mouseEntered() {
				setBackgroundColor(ColorUtils.darkenColor(CarbonChatPalette.PALETTE.getHalfDark(), 7));
			}
			
			@Override
			public void mouseClick() {
			}
		};
		this.settingsButton.setFont(buttonFont);
		this.settingsButton.setTextFill(Color.WHITE);
		this.settingsButton.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		this.settingsButton.setAlignment(Pos.CENTER_LEFT);
		this.settingsButton.setMinWidth(this.navbar.getMinWidth());
		
		buttonList.getChildren().add(this.settingsButton);

		this.homeButton.setContentDisplay(ContentDisplay.RIGHT);
		this.announcesButton.setContentDisplay(ContentDisplay.RIGHT);
		this.myProjectsButton.setContentDisplay(ContentDisplay.RIGHT);
		this.contactsButton.setContentDisplay(ContentDisplay.RIGHT);
		this.settingsButton.setContentDisplay(ContentDisplay.RIGHT);
		
		buttonList.setSpacing(5D);

		this.getChildren().add(buttonList);
		
		JFXSIconMaterial faceIcon = new JFXSIconMaterial(MaterialIcon.FACE);
		faceIcon.setIconSize(24);
		faceIcon.setIconColor(Color.WHITE);

		this.usernameText = new Label("userbeta");
		this.usernameText.setFont(buttonFont);
		this.usernameText.setTextFill(Color.WHITE);
		this.usernameText.setGraphic(faceIcon.icon());
		
		AnchorPane.setLeftAnchor(this.usernameText, 10D);
		AnchorPane.setBottomAnchor(this.usernameText, 10D);
		
		this.getChildren().add(this.usernameText);
	}
}
