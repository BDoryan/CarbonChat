package fr.carbonchat.software.interfaces.main.home;

import java.text.SimpleDateFormat;

import fr.carbonchat.jfxswinger.JFXSwinger;
import fr.carbonchat.jfxswinger.swingers.JFXSImageView;
import fr.carbonchat.jfxswinger.utils.CSSUtils;
import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.CarbonChatSoftware;
import fr.carbonchat.software.core.swinger.Contact;
import fr.carbonchat.software.core.swinger.News;
import fr.carbonchat.software.core.swinger.Project;
import fr.carbonchat.software.palettes.CarbonChatPalette;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HomeInterface extends Interface {

	public static final HomeInterface INTERFACE = new HomeInterface();

	public News[] news = new News[3];
	public Project[] recent_projects = new Project[3];
	public Contact[] recent_contacts = new Contact[5];

	public HBox news_hbox = new HBox();
	public VBox news_vbox = new VBox();

	public VBox recent_projects_vbox = new VBox();
	public HBox recent_projects_hbox = new HBox();

	public AnchorPane first_news;
	public AnchorPane second_news;
	public AnchorPane third_news;

	public AnchorPane first_recent_project;
	public AnchorPane second_recent_project;
	public AnchorPane third_recent_project;

	public AnchorPane first_contact_recent;
	public AnchorPane second_contact_recent;
	public AnchorPane third_contact_recent;
	public AnchorPane fourth_contact_recent;
	public AnchorPane fifth_contact_recent;

	public VBox recent_contacts_vbox = new VBox();
	public HBox recent_contacts_hbox = new HBox();

	public VBox container = new VBox(50); 
	public ScrollPane scrollPane;

	public HomeInterface() {
		reloadAll();
		
		this.news_vbox.setPrefHeight(400);
		this.news_vbox.setPrefWidth(800);

		this.first_news = generateBignews(news[0]);
		this.second_news = generateLittlenews(news[1]);
		this.third_news = generateLittlenews(news[2]);

		this.first_recent_project = generateRecentProject(recent_projects[0]);
		this.second_recent_project = generateRecentProject(recent_projects[1]);
		this.third_recent_project = generateRecentProject(recent_projects[2]);

		this.first_contact_recent = generateContactRecent(recent_contacts[0]);
		this.second_contact_recent = generateContactRecent(recent_contacts[1]);
		this.third_contact_recent = generateContactRecent(recent_contacts[2]);
		this.fourth_contact_recent = generateContactRecent(recent_contacts[3]);
		this.fifth_contact_recent = generateContactRecent(recent_contacts[4]);
		
		this.recent_contacts_hbox.setMinHeight(150);
		
		this.news_hbox.setMinHeight(340);
		
		this.news_hbox.getChildren().add(this.first_news);
		this.news_vbox.getChildren().add(this.second_news);
		this.news_vbox.getChildren().add(this.third_news);

		this.news_hbox.getChildren().add(this.news_vbox);
		
		Text recent_projects_title = new Text(CarbonChatSoftware.current_lang.get("home_recent_projects_title"));
		recent_projects_title.setFill(Color.WHITE);
		recent_projects_title.setFont(JFXSwinger.getFont(28));
		
		Text recent_contacts_title = new Text(CarbonChatSoftware.current_lang.get("home_recent_contacts_title"));
		recent_contacts_title.setFill(Color.WHITE);
		recent_contacts_title.setFont(JFXSwinger.getFont(28));

		this.recent_projects_vbox.setSpacing(20);
		this.recent_projects_vbox.setAlignment(Pos.CENTER);
		
		this.recent_projects_hbox.setAlignment(Pos.CENTER);
		this.recent_projects_hbox.setSpacing(60);

		this.recent_contacts_vbox.setSpacing(20);
		this.recent_contacts_vbox.setAlignment(Pos.CENTER);
		
		this.recent_contacts_hbox.setAlignment(Pos.CENTER);
		this.recent_contacts_hbox.setSpacing(60);
		
		this.recent_projects_hbox.getChildren().add(first_recent_project);		
		this.recent_projects_hbox.getChildren().add(second_recent_project);		
		this.recent_projects_hbox.getChildren().add(third_recent_project);

		this.recent_projects_vbox.getChildren().add(recent_projects_title);		
		this.recent_projects_vbox.getChildren().add(this.recent_projects_hbox);
		
		this.recent_contacts_hbox.getChildren().add(first_contact_recent);		
		this.recent_contacts_hbox.getChildren().add(second_contact_recent);		
		this.recent_contacts_hbox.getChildren().add(third_contact_recent);
		this.recent_contacts_hbox.getChildren().add(fourth_contact_recent);		
		this.recent_contacts_hbox.getChildren().add(fifth_contact_recent);

		this.recent_contacts_vbox.getChildren().add(recent_contacts_title);		
		this.recent_contacts_vbox.getChildren().add(this.recent_contacts_hbox);
		
		this.container.getChildren().add(this.news_hbox);
		this.container.getChildren().add(this.recent_projects_vbox);
		this.container.getChildren().add(this.recent_contacts_vbox);
		
		this.scrollPane = new ScrollPane(this.container);
		this.scrollPane.setFitToWidth(true);
		this.scrollPane.setFitToHeight(true);
		this.scrollPane.setOnScroll(new EventHandler<ScrollEvent>() {
			
	        @Override
	        public void handle(ScrollEvent event) {
	            double vvalue = scrollPane.getVvalue();
	            System.out.println("vvalue : "+vvalue);
	            double deltaY = event.getDeltaY()*6; // *6 to make the scrolling a bit faster
	            double width = scrollPane.getContent().getBoundsInLocal().getWidth();
	            scrollPane.setVvalue(vvalue + -deltaY/width); // deltaY/width to make the scrolling equally fast regardless of the actual width of the component
	        }
	    });
		
		AnchorPane.setBottomAnchor(this.scrollPane, 0D);
		AnchorPane.setRightAnchor(this.scrollPane, 0D);
		AnchorPane.setLeftAnchor(this.scrollPane, 0D);
		AnchorPane.setTopAnchor(this.scrollPane, 0D);
		
		this.getChildren().add(this.scrollPane);
		
		CSSUtils scrollPaneCSS = new CSSUtils(this.scrollPane);
		scrollPaneCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());

		CSSUtils containerCSS = new CSSUtils(this.container);
		containerCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getHalfLight());
	}
	
	public void reloadAll() {
		reloadnewss();
		reloadRecentContacts();
		reloadRecentProjects();
	}
	
	public void reloadRecentContacts() {
		recent_contacts[0] = new Contact(0);
		recent_contacts[1] = new Contact(0);
		recent_contacts[2] = new Contact(0);
		recent_contacts[3] = new Contact(0);
		recent_contacts[4] = new Contact(0);
	}
	
	public void reloadRecentProjects() {
		recent_projects[0] = new Project(0, "CarbonChat");
		recent_projects[1] = new Project(0, "BloostryNetwork");
		recent_projects[2] = new Project(0, "iPvP");
	}
	
	public void reloadnewss() {
		news[0] =  new News("Devlog", "Devlog #1 : Ajout des demandes de contact, appel vocaux",
				"Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié.",
				System.currentTimeMillis()) {
			@Override
			public void action() {
			}
		};
		news[1] = new News("Devlog", "Devlog #1 : Ajout des demandes de contact, appel vocaux",
				"Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié.",
				System.currentTimeMillis()) {
			@Override
			public void action() {
			}
		};
		news[2] = new News("Devlog", "Devlog #1 : Ajout des demandes de contact, appel vocaux",
				"Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié.",
				System.currentTimeMillis()) {
			@Override
			public void action() {
			}
		};
	}
	
	public AnchorPane generateContactRecent(Contact contact) {
		AnchorPane pane = new AnchorPane();
		
		VBox recent_project_vbox = new VBox();
		recent_project_vbox.setAlignment(Pos.CENTER);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(1.90);
		dropShadow.setOffsetY(1.90);
		dropShadow.setColor(Color.BLACK);
		
		Image logo_image = contact.getLogo(90, 90);
		JFXSImageView logo = null;
		
		if(logo_image != null) {
			logo = new JFXSImageView(logo_image);
			
			recent_project_vbox.getChildren().add(logo);
		}
		
		Text title = new Text(contact.getUsername());
		title.setFill(Color.WHITE);
		title.setFont(JFXSwinger.getFont(20));
		
		recent_project_vbox.getChildren().add(title);
		
		pane.setCursor(Cursor.HAND);

		title.setSmooth(true);
		logo.setSmooth(true);

		ScaleTransition enterTransition = new ScaleTransition(Duration.millis(100), title);
		ScaleTransition exitTransition = new ScaleTransition(Duration.millis(180), title);
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
			};
		});
		
		pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitTransition.stop();
				
				enterTransition.setFromX(getScaleX());
				enterTransition.setFromY(getScaleY());
				enterTransition.setToX(1.08);
				enterTransition.setToY(1.08);
				enterTransition.playFromStart();
			};
		});
		
		pane.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				enterTransition.stop();

				exitTransition.setFromX(enterTransition.getToX());
                exitTransition.setFromY(enterTransition.getToY());
                exitTransition.setToX(1);
                exitTransition.setToY(1);
                exitTransition.playFromStart();
			};
		});
		
		pane.getChildren().add(recent_project_vbox);
		
		return pane;
	}
	
	public AnchorPane generateRecentProject(Project project) {
		AnchorPane pane = new AnchorPane();
		
		VBox recent_project_vbox = new VBox();
		recent_project_vbox.setAlignment(Pos.CENTER);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(1.90);
		dropShadow.setOffsetY(1.90);
		dropShadow.setColor(Color.BLACK);
		
		Image logo_image = project.getLogo(90, 90);
		JFXSImageView logo = null;
		
		if(logo_image != null) {
			logo = new JFXSImageView(logo_image);
			
			recent_project_vbox.getChildren().add(logo);
		}
		
		Text title = new Text(project.getName());
		title.setFill(Color.WHITE);
		title.setFont(JFXSwinger.getFont(20).font("GoogleSansRegular", FontWeight.BOLD, 18));
		
		recent_project_vbox.getChildren().add(title);
		
		Text members_online = new Text(project.getMemberOnline()+" "+CarbonChatSoftware.current_lang.get("home_recent_projects_members_online"));
		members_online.setFill(Color.WHITE);
		members_online.setFont(JFXSwinger.getFont(18));
		//members_online.setEffect(dropShadow);
		
		recent_project_vbox.getChildren().add(members_online);
		
		pane.setCursor(Cursor.HAND);

		title.setSmooth(true);
		members_online.setSmooth(true);
		logo.setSmooth(true);

		ScaleTransition enterTransition = new ScaleTransition(Duration.millis(100), title);
		ScaleTransition exitTransition = new ScaleTransition(Duration.millis(180), title);

		ScaleTransition enterTransition_ = new ScaleTransition(Duration.millis(100), members_online);
		ScaleTransition exitTransition_ = new ScaleTransition(Duration.millis(180), members_online);
		
		RotateTransition rotateTransition = new RotateTransition(Duration.millis(350), logo);
		rotateTransition.setFromAngle(0);
		rotateTransition.setToAngle(360);
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				rotateTransition.playFromStart();
			};
		});
		
		pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitTransition.stop();
				
				enterTransition.setFromX(getScaleX());
				enterTransition.setFromY(getScaleY());
				enterTransition.setToX(1.08);
				enterTransition.setToY(1.08);
				enterTransition.playFromStart();
				
				exitTransition_.stop();
				
				enterTransition_.setFromX(getScaleX());
				enterTransition_.setFromY(getScaleY());
				enterTransition_.setToX(1.08);
				enterTransition_.setToY(1.08);
				enterTransition_.playFromStart();
			};
		});
		
		pane.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				enterTransition.stop();

				exitTransition.setFromX(enterTransition.getToX());
                exitTransition.setFromY(enterTransition.getToY());
                exitTransition.setToX(1);
                exitTransition.setToY(1);
                exitTransition.playFromStart();
                
                enterTransition_.stop();

                exitTransition_.setFromX(enterTransition.getToX());
                exitTransition_.setFromY(enterTransition.getToY());
                exitTransition_.setToX(1);
                exitTransition_.setToY(1);
                exitTransition_.playFromStart();
			};
		});
		
		pane.getChildren().add(recent_project_vbox);
		
		return pane;
	}

	public AnchorPane generateBignews(News news) {
		AnchorPane pane = new AnchorPane();
		pane.setPrefWidth(1000);
		pane.setPrefHeight(this.news_vbox.getPrefHeight());

		CSSUtils paneCSS = new CSSUtils(pane);

		if (news.getImagePath() != null) {
			paneCSS.addCSS("-fx-background-image", "url("+news.getImagePath()+")");
			paneCSS.addCSS("-fx-background-size", "cover");
		} else {
			paneCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getLight());
		}

		HBox.setMargin(pane, new Insets(10, 10, 10, 10));

		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(1.90);
		dropShadow.setOffsetY(1.90);
		dropShadow.setColor(Color.BLACK);

		VBox pane_vbox = new VBox();
		pane_vbox.setAlignment(Pos.BOTTOM_LEFT);

		AnchorPane.setRightAnchor(pane_vbox, 10D);
		AnchorPane.setLeftAnchor(pane_vbox, 10D);
		AnchorPane.setTopAnchor(pane_vbox, 10D);
		AnchorPane.setBottomAnchor(pane_vbox, 10D);

		Text date = new Text(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(news.getPostDate()));
		date.setFill(Color.WHITE);
		date.setFont(JFXSwinger.getFont(16));
		date.setEffect(dropShadow);

		String description_string = news.getDescription();

		Text description = new Text(description_string);
		description.setFill(Color.WHITE);
		description.setFont(JFXSwinger.getFont(18));
		description.setEffect(dropShadow);

		Text title = new Text(news.getTitle());
		title.setFill(Color.WHITE);
		title.setFont(JFXSwinger.getFont(18).font("GoogleSansRegular", FontWeight.BOLD, 18));
		title.setEffect(dropShadow);
		
		pane.setCursor(Cursor.HAND);

		ScaleTransition enterTransition = new ScaleTransition(Duration.millis(100), pane);
		ScaleTransition exitTransition = new ScaleTransition(Duration.millis(180), pane);
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				news.action();
			};
		});
		
		pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitTransition.stop();
				
				enterTransition.setFromX(getScaleX());
				enterTransition.setFromY(getScaleY());
				enterTransition.setToX(1.025);
				enterTransition.setToY(1.025);
				enterTransition.playFromStart();
			};
		});
		
		pane.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				enterTransition.stop();

				exitTransition.setFromX(getScaleX());
                exitTransition.setFromY(getScaleY());
                exitTransition.setToX(1);
                exitTransition.setToY(1);
                exitTransition.playFromStart();
			};
		});

		pane_vbox.getChildren().add(title);
		pane_vbox.getChildren().add(description);
		pane_vbox.getChildren().add(date);

		pane.getChildren().add(pane_vbox);

		return pane;
	}

	public AnchorPane generateLittlenews(News news) {
		AnchorPane pane = new AnchorPane();
		pane.setPrefWidth(500);
		pane.setPrefHeight(this.news_vbox.getPrefHeight());

		VBox.setMargin(pane, new Insets(10, 10, 10, 10));
		
		CSSUtils paneCSS = new CSSUtils(pane);

		if (news.getImagePath() != null) {
			paneCSS.addCSS("-fx-background-image", "url("+news.getImagePath()+")");
			paneCSS.addCSS("-fx-background-size", "cover");
		} else {
			paneCSS.setBackgroundColor(CarbonChatPalette.PALETTE.getLight());
		}
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(1.90);
		dropShadow.setOffsetY(1.90);
		dropShadow.setColor(Color.BLACK);

		ScaleTransition enterTransition = new ScaleTransition(Duration.millis(100), pane);
		ScaleTransition exitTransition = new ScaleTransition(Duration.millis(180), pane);
		
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				news.action();
			};
		});
		
		pane.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				exitTransition.stop();
				
				enterTransition.setFromX(getScaleX());
				enterTransition.setFromY(getScaleY());
				enterTransition.setToX(1.025);
				enterTransition.setToY(1.025);
				enterTransition.playFromStart();
			};
		});
		
		pane.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				enterTransition.stop();

				exitTransition.setFromX(getScaleX());
                exitTransition.setFromY(getScaleY());
                exitTransition.setToX(1);
                exitTransition.setToY(1);
                exitTransition.playFromStart();
			};
		});

		VBox pane_vbox = new VBox();
		pane_vbox.setAlignment(Pos.BOTTOM_LEFT);

		AnchorPane.setRightAnchor(pane_vbox, 10D);
		AnchorPane.setLeftAnchor(pane_vbox, 10D);
		AnchorPane.setTopAnchor(pane_vbox, 10D);
		AnchorPane.setBottomAnchor(pane_vbox, 10D);

		Text date = new Text(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(news.getPostDate()));
		date.setFill(Color.WHITE);
		date.setFont(JFXSwinger.getFont(16));
		date.setEffect(dropShadow);

		Text title = new Text(news.getTitle());
		title.setFill(Color.WHITE);
		title.setFont(JFXSwinger.getFont(18).font("GoogleSansRegular", FontWeight.BOLD, 18));
		title.setEffect(dropShadow);

		pane_vbox.getChildren().add(title);
		pane_vbox.getChildren().add(date);

		pane.getChildren().add(pane_vbox);
		return pane;
	}

	@Override
	public void enter() {
		reloadAll();
	}

	@Override
	public void leave() {
	}
}
