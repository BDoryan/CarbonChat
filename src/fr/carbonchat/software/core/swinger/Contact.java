package fr.carbonchat.software.core.swinger;

import java.util.Random;

import javafx.scene.image.Image;

public class Contact {

	public int id;
	
	public Contact(int id) {
		this.id = id;
	}

	public Image getLogo(int width, int height) {
		Image image = new Image(getClass().getResourceAsStream("/imgs/face-white.png"), width, height, true, true);
		return image;
	}
	
	public String getUsername() {
		return "user "+new Random().nextInt(999999);
	}
}
