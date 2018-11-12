package fr.carbonchat.software.interfaces.main;

import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSButton;
import fr.carbonchat.jfxswinger.swingers.JFXSIcon;
import fr.carbonchat.jfxswinger.swingers.JFXSIconMaterial;
import fr.carbonchat.jfxswinger.utils.CSSUtils;
import fr.carbonchat.jfxswinger.utils.ColorUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.CarbonChatSoftware;
import fr.carbonchat.software.interfaces.main.home.HomeInterface;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainInterface extends Interface {

	public static final MainInterface INTERFACE = new MainInterface();

	public AnchorPane navbar = new AnchorPane();
	
	public Label username_text;
	
	public JFXSButton home_button;

	public JFXSButton create_a_ad_button;
	public JFXSButton my_ads_button;
	public JFXSButton see_the_ads_button;

	public JFXSButton create_a_project_button;
	public JFXSButton see_more_projects_button;

	public JFXSButton add_contact_button;
	public JFXSButton my_contacts_button;
	
	public JFXSButton settings_button;
	
	public AnchorPane container = new AnchorPane();
	
	public MainInterface() {
		this.cssUtils.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());
		
		CSSUtils navbarCSS = new CSSUtils(navbar);
		navbarCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		
		AnchorPane.setLeftAnchor(navbar, 0D);
		AnchorPane.setBottomAnchor(navbar, 0D);
		AnchorPane.setTopAnchor(navbar, 0D);
		
		this.navbar.setMinWidth(260);

		this.getChildren().add(navbar);

		VBox buttonList = new VBox();

		AnchorPane.setLeftAnchor(buttonList, 0D);
		AnchorPane.setBottomAnchor(buttonList, 60D);
		AnchorPane.setTopAnchor(buttonList, 10D);
		
		Font buttonFont = JFXSwinger.getFont(20D);
		Font littleButtonFont = JFXSwinger.getFont(17D);
		
		JFXSIconMaterial adsIcon = new JFXSIconMaterial(MaterialIcon.DESCRIPTION);
		adsIcon.setIconSize(24);
		adsIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial projectsIcon = new JFXSIconMaterial(MaterialIcon.WORK);
		projectsIcon.setIconSize(24);
		projectsIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial settingsIcon = new JFXSIconMaterial(MaterialIcon.SETTINGS);
		settingsIcon.setIconSize(24);
		settingsIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial contactsIcon = new JFXSIconMaterial(MaterialIcon.CONTACTS);
		contactsIcon.setIconSize(24);
		contactsIcon.setIconColor(Color.WHITE);
		
		JFXSIconMaterial homeIcon = new JFXSIconMaterial(MaterialIcon.HOME);
		homeIcon.setIconSize(24);
		homeIcon.setIconColor(Color.WHITE);
		
		this.home_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_home_button"), buttonFont, homeIcon, new Runnable() {
			@Override
			public void run() {
			}
		}, false);
		
		buttonList.getChildren().add(this.home_button);
		
		//Ads

		Label ads_text = generateText(CarbonChatSoftware.current_lang.get("navbar_ads_text"), buttonFont, adsIcon);
		ads_text.setPadding(new Insets(2, 0, 5, 12));
		
		this.create_a_ad_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_create_a_ad_button"), littleButtonFont, null, new Runnable() {
			@Override
			public void run() {
			}
		}, true);
		this.create_a_ad_button.setPadding(new Insets(0, 0, 0, 30));

		
		this.my_ads_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_my_ads_button"), littleButtonFont, null, new Runnable() {
			@Override
			public void run() {
			}
		}, true);
		this.my_ads_button.setPadding(new Insets(0, 0, 0, 30));
		
		this.see_the_ads_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_see_the_ads_button"), littleButtonFont, null, new Runnable() {
			@Override
			public void run() {
			}
		}, true);
		this.see_the_ads_button.setPadding(new Insets(0, 0, 0, 30));
		
		//Projects

		Label projects_text = generateText(CarbonChatSoftware.current_lang.get("navbar_projects_text"), buttonFont, projectsIcon);
		projects_text.setPadding(new Insets(10, 0, 5, 12));
		
		this.create_a_project_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_create_a_project_button"), littleButtonFont, null, new Runnable() {
			@Override
			public void run() {
			}
		}, true);
		this.create_a_project_button.setPadding(new Insets(0, 0, 0, 30));
		
		this.see_more_projects_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_see_more_projects_button"), littleButtonFont, null, new Runnable() {
			@Override
			public void run() {
			}
		}, true);
		this.see_more_projects_button.setPadding(new Insets(0, 0, 0, 30));
		
		//Contacts

		Label contacts_text = generateText(CarbonChatSoftware.current_lang.get("navbar_contacts_text"), buttonFont, contactsIcon);
		contacts_text.setPadding(new Insets(10, 0, 5, 12));
		
		this.add_contact_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_add_contact_button"), littleButtonFont, null, new Runnable() {
			@Override
			public void run() {
			}
		}, true);
		this.add_contact_button.setPadding(new Insets(0, 0, 0, 30));
		
		this.my_contacts_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_my_contacts_button"), littleButtonFont, null, new Runnable() {
			@Override
			public void run() {
			}
		}, true);
		this.my_contacts_button.setPadding(new Insets(0, 0, 0, 30));

		buttonList.getChildren().add(ads_text);
		buttonList.getChildren().add(create_a_ad_button);
		buttonList.getChildren().add(my_ads_button);
		buttonList.getChildren().add(see_the_ads_button);
		
		buttonList.getChildren().add(projects_text);
		buttonList.getChildren().add(create_a_project_button);
		buttonList.getChildren().add(see_more_projects_button);
		
		buttonList.getChildren().add(contacts_text);
		buttonList.getChildren().add(add_contact_button);
		buttonList.getChildren().add(my_contacts_button);
		
		this.settings_button = generateJFXSButton(CarbonChatSoftware.current_lang.get("navbar_settings_button"), buttonFont, settingsIcon, new Runnable() {
			@Override
			public void run() {
			}
		}, false);
		
		buttonList.getChildren().add(this.settings_button);

		this.home_button.setContentDisplay(ContentDisplay.RIGHT);
		this.settings_button.setContentDisplay(ContentDisplay.RIGHT);
		
		buttonList.setSpacing(5D);

		this.getChildren().add(buttonList);
		
		JFXSIconMaterial faceIcon = new JFXSIconMaterial(MaterialIcon.FACE);
		faceIcon.setIconSize(24);
		faceIcon.setIconColor(Color.WHITE);

		this.username_text = new Label("userbeta");
		this.username_text.setFont(buttonFont);
		this.username_text.setTextFill(Color.WHITE);
		this.username_text.setGraphic(faceIcon.icon());
		
		AnchorPane.setLeftAnchor(this.username_text, 10D);
		AnchorPane.setBottomAnchor(this.username_text, 10D);
		
		
		this.getChildren().add(this.username_text);
		this.getChildren().add(this.container);

		AnchorPane.setLeftAnchor(this.container, this.navbar.getMinWidth());
		AnchorPane.setRightAnchor(this.container, 0D);
		AnchorPane.setTopAnchor(this.container, 0D);
		AnchorPane.setBottomAnchor(this.container, 0D);
		
		loadContainer(HomeInterface.INTERFACE);
	}
	
	private Label generateText(String text, Font font, JFXSIconMaterial icon) {
		Label label = new Label(text);
		label.setGraphic(icon == null ? null : icon.icon());
		label.setFont(font);
		label.setTextFill(Color.WHITE);
		label.setContentDisplay(ContentDisplay.RIGHT);
		return label;
	}

	private JFXSButton generateJFXSButton(String text, Font font, JFXSIcon icon, Runnable action, boolean withArrow) {
		JFXSButton button = new JFXSButton(text) {
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
				action.run();
			}
		};
		if(withArrow) {
			JFXSIconMaterial arrowIcon = new JFXSIconMaterial(MaterialIcon.KEYBOARD_ARROW_RIGHT);
			arrowIcon.setIconSize(20);
			arrowIcon.setIconColor(Color.WHITE);

			button.setGraphic(arrowIcon.icon());
			button.setContentDisplay(ContentDisplay.LEFT);
		} else {
			button.setGraphic(icon == null ? null : icon.icon());
			button.setContentDisplay(ContentDisplay.RIGHT);	
		}
		button.setFont(font);
		button.setTextFill(Color.WHITE);
		button.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		button.setAlignment(Pos.CENTER_LEFT);
		button.setMinWidth(this.navbar.getMinWidth());
		
		return button;
	}

	public void loadContainer(Interface container) {
		if (this.container != null && this.container instanceof Interface) {
			((Interface) this.container).leave();
		}
		if (container instanceof Interface) {
			((Interface) container).enter();
		}
		
		AnchorPane.setTopAnchor(container, 0D);
		AnchorPane.setBottomAnchor(container, 0D);
		AnchorPane.setRightAnchor(container, 0D);
		AnchorPane.setLeftAnchor(container, 0D);

		this.container.getChildren().clear();
		this.container.getChildren().add(container);
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
	}
}
