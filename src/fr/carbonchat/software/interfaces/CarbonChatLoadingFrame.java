package fr.carbonchat.software.interfaces;

import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.palettes.JFXSwingerPalette;
import fr.carbonchat.jfxswinger.swingers.JFXSFrame;
import fr.carbonchat.jfxswinger.utils.CSSUtils;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CarbonChatLoadingFrame extends JFXSFrame {

	public static CarbonChatLoadingFrame instance;

	public AnchorPane container;

	public CarbonChatLoadingFrame(Stage stage) {
		super(stage, "CarbonChat", 300, 250);
		
		instance = this;

		this.setIcon(new Image(getClass().getResourceAsStream("/imgs/carbonchat-logo.png")));
		this.stage.initStyle(StageStyle.UNDECORATED);

		Text text = new Text("Chargement de CarbonChat ...");
		text.setFont(JFXSwinger.getFont(20));
		text.setFill(Color.WHITE);
		
		HBox center_text = new HBox();
		center_text.setAlignment(Pos.CENTER);
		center_text.getChildren().add(text);

		CSSUtils rootCSS = new CSSUtils(this.root);
		rootCSS.addCSS("-fx-background-image", "url('/imgs/loading.gif')");
		rootCSS.addCSS("-fx-background-position", "center center");
		rootCSS.addCSS("-fx-background-size", "200px 200px");
		rootCSS.addCSS("-fx-background-repeat", "no-repeat");
		
		rootCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfDark());
		
		AnchorPane.setRightAnchor(center_text, 0D);
		AnchorPane.setLeftAnchor(center_text, 0D);
		AnchorPane.setBottomAnchor(center_text, 10D);
		
		this.root.getChildren().add(center_text);
		
		this.root.setBorder(new Border(new BorderStroke(JFXSwingerPalette.PALETTE.getWhite(), BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY, new BorderWidths(0.10D))));

		apply();
	}

	public void maximized(boolean maximized_) {
		if (!maximized_) {
			root.setBorder(new Border(new BorderStroke(JFXSwingerPalette.PALETTE.getWhite(), BorderStrokeStyle.SOLID,
					CornerRadii.EMPTY, new BorderWidths(0.20D))));
		} else {
			root.setBorder(null);

		}
	}
}
