package model;

import java.util.ArrayList;

import model.user.User;

public class Page {
	private String title;
	private String description;
	private ArrayList<User> followers = new ArrayList<User>();
	private ArrayList<Post> postsInPage = new ArrayList<Post>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if (title != null && title.length() > 5 && title.length() < 50)
			this.title = title;
		else
			this.title = "----------";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (description != null && description.length() > 5 && description.length() < 500)
			this.description = description;
	}
	public ArrayList<User> getFollowers() {
		return followers;
	}
	public ArrayList<Post> getPostsInPage() {
		return postsInPage;
	}
	
	public Page() {
		setTitle("Autoserviss Ventspili");
		setDescription("Autoserviss Ventspili - jaunakaas aktualitates");
	}
	
	public String toString() {
		return title + "(" + description + ")" + followers.size() + " folowers";
	}
	
}
