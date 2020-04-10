package fr.carbonchat.software.core.swinger;

import javafx.scene.image.Image;

public class Project {

	public int id;
	public String name;

	public Project(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// TODO: change the value returned
	public int getMemberOnline() {
		return 14;
	}

	public Image getLogo(int width, int height) {
		Image image = new Image(getClass().getResourceAsStream("/imgs/carbonchat-logo.png"), width, height, true, true);
		return image;
	}

	public String getName() {
		return name;
	}
}
