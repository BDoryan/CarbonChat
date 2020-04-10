package fr.carbonchat.software.interfaces.main.announces.list;

import java.text.SimpleDateFormat;

import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSImageView;
import fr.carbonchat.jfxswinger.utils.CSSUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.core.swinger.Ad;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class AnnounceListInterface extends Interface {

	protected final int MAX_ANNOUNCES_PER_PAGE = 7;

	public int page;
	public Ad[] ad = new Ad[MAX_ANNOUNCES_PER_PAGE];

	public VBox announces_vbox = new VBox(20);
	public ScrollPane scrollPane;

	public AnnounceListInterface(int page) {
		this.page = page;
		
		this.scrollPane = new ScrollPane(this.announces_vbox);
		this.scrollPane.setFitToWidth(true);
		this.scrollPane.setFitToHeight(true);

		this.announces_vbox.setPadding(new Insets(40, 40, 40, 40));
		
		AnchorPane.setBottomAnchor(this.scrollPane, 0D);
		AnchorPane.setTopAnchor(this.scrollPane, 0D);
		AnchorPane.setRightAnchor(this.scrollPane, 0D);
		AnchorPane.setLeftAnchor(this.scrollPane, 0D);
		
		CSSUtils scrollPaneCSS = new CSSUtils(this.scrollPane);
		scrollPaneCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());

		CSSUtils containerCSS = new CSSUtils(this.announces_vbox);
		containerCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());
		
		this.getChildren().add(this.scrollPane);
	}
	
	public void load() {
		reloadAll();
	}

	public void reloadAll() {
		reloadAnnounces();
	}

	public void reloadAnnounces() {
		this.announces_vbox.getChildren().clear();
		
		for(int i = 0; i < MAX_ANNOUNCES_PER_PAGE; i++) {
			this.ad[i] = new Ad(0);

			Ad announce = this.ad[i];
			
			HBox announcePane = new HBox();
			announcePane.setMinHeight(140);
			CSSUtils announcePaneCSS = new CSSUtils(announcePane);
			announcePaneCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
			announcePane.setAlignment(Pos.CENTER_LEFT);

			ScaleTransition enterTransition = new ScaleTransition(Duration.millis(100), announcePane);
			ScaleTransition exitTransition = new ScaleTransition(Duration.millis(100), announcePane);
			
			announcePane.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
				};
			});
			
			announcePane.setOnMouseEntered(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					exitTransition.stop();
					
					enterTransition.setFromX(getScaleX());
					enterTransition.setFromY(getScaleY());
					enterTransition.setToX(1.04);
					enterTransition.setToY(1.04);
					enterTransition.playFromStart();
				};
			});
			
			announcePane.setOnMouseExited(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					enterTransition.stop();

					exitTransition.setFromX(enterTransition.getToX());
	                exitTransition.setFromY(enterTransition.getToY());
	                exitTransition.setToX(1);
	                exitTransition.setToY(1);
	                exitTransition.playFromStart();
				};
			});
			
			Image logo_image = this.ad[i].getLogo(120, 120);
			JFXSImageView logo = null;
			
			if(logo_image != null) {
				logo = new JFXSImageView(logo_image);
				
				announcePane.getChildren().add(logo);
			}
			
			Label title = new Label(announce.getTitle());
			title.setPadding(new Insets(5, 0,0,0));
			title.setTextFill(Color.WHITE);
			title.setFont(JFXSwinger.getFont(22).font("GoogleSansRegular", FontWeight.BOLD, 22));
			title.setMinWidth(announcePane.getWidth() - logo.getFitWidth());
			
			Label message = new Label(announce.getMessage());
			message.setTextFill(Color.WHITE);
			message.setFont(JFXSwinger.getFont(18));
			message.setMinWidth(announcePane.getWidth() - logo.getFitWidth());
			message.setWrapText(true);
			message.setPadding(new Insets(0, 5, 5, 0));
			
			Label date = new Label(new SimpleDateFormat().format(announce.getDate()));
			date.setTextFill(Color.WHITE);
			date.setFont(JFXSwinger.getFont(16));
			date.setPadding(new Insets(0, 0, 5, 0));
			
			VBox text_pane = new VBox(2);
			text_pane.getChildren().add(title);
			text_pane.getChildren().add(message);	
			text_pane.getChildren().add(date);	
			
			announcePane.getChildren().add(text_pane);
			
			this.announces_vbox.getChildren().add(announcePane);		
		}
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
	}
}
