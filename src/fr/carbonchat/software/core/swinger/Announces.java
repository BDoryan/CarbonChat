package fr.carbonchat.software.core.swinger;

import javafx.scene.image.Image;

public class Announces {

	public String uuid;

	public Announces(String uuid) {
		this.uuid = uuid;
	}

	public Image getLogo(int width, int height) {
		Image image = new Image(getClass().getResourceAsStream("/imgs/description-white.png"), width, height, true, true);
		return image;
	}

	public String getMessage() {
		return "Le Lorem Ipsum est simplement du faux texte employ� dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les ann�es 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour r�aliser un livre sp�cimen de polices de texte. Il n'a pas fait que survivre cinq si�cles, mais s'est aussi adapt� � la bureautique informatique, sans que son contenu n'en soit modifi�. Il a �t� popularis� dans les ann�es 1960 gr�ce � la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus r�cemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.";
	}

	public String getTitle() {
		return "Je cr�er des titres pour tester mes annonces, j'utilise Java";
	}
}
