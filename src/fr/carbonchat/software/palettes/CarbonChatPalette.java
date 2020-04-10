package fr.carbonchat.software.palettes;

import fr.carbonchat.jfxswinger.palettes.Palette;
import javafx.scene.paint.Color;

public class CarbonChatPalette extends Palette {

	public static final CarbonChatPalette PALETTE = new CarbonChatPalette();

	public Color getDanger() {
		return Color.web("#cc3300");
	}

	public Color getPrimary() {
		return Color.web("#00D1B2");
	}
	
	public Color getHalfLight() {
		return Color.web("#4a4a4a");
	}
	
	public Color getHalfDark() {
		return Color.web("#3a3a3a");
	}

	public Color getInfo() {
		return Color.web("#3273DC");
	}

	public Color getLink() {
		return Color.web("#209CEE");
	}

	public Color getSuccess() {
		return Color.web("#23D160");
	}

	public Color getWarning() {
		return Color.web("#FFDD57");
	}

	public Color getWhite() {
		return Color.web("#FFFFFF");
	}

	public Color getBlack() {
		return Color.web("#000000");
	}

	public Color getLight() {
		return Color.web("#2e2e2e");
	}

	public Color getDark() {
		return Color.web("#191919");
	}
}
