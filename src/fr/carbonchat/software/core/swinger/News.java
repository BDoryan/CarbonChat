package fr.carbonchat.software.core.swinger;

public abstract class News {
	
	protected String title;
	protected String description;
	protected String text;
	protected String image_path;
	protected long post_date;
	
	public News(String title, String description, String text, long post_date) {
		this(title, description, text, post_date, null);
	}
	
	public News(String title,  String description, String text, long post_date, String image_path) {
		this.title = title;
		this.description = description;
		this.text = text;
		this.post_date = post_date;
		this.image_path = image_path;
	}
	
	public long getPostDate(){
		return this.post_date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getImagePath() {
		return image_path;
	}
	
	public String getText() {
		return text;
	}
	
	public abstract void action();
}
