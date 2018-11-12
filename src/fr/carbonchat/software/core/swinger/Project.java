package fr.carbonchat.software.core.swinger;

import javafx.scene.image.Image;

public class Project {

	public String uuid;
	public String name;

	public Project(String uuid, String name) {
		this.uuid = uuid;
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
