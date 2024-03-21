package model.user;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends User{
	private ArrayList<Page> listOfPages = new ArrayList<Page>();
	private String PVN;
	
	public String getPVN() {
		return PVN;
	}

	public void setPVN(String PVN) {
		if ( PVN != null && PVN.matches("[A-Z]{2}[0-9]{11}"))
			this.PVN = PVN;
		else
			this.PVN = "-----------";
	}

	public ArrayList<Page> getListOfPages() {
		return listOfPages;
	}
	@Override
	public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
		// TODO Auto-generated method stub
		if (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-za-z0-9%&+@,.!]{3,50}"))
			super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
		else
			super.nameAndSurnameOrTitle = "----------------------";
	}
	
	public BusinessUser() {
		super(); //tiek izsaukts user klases konstruktors
		setNameAndSurnameOrTitle("Autoserviss");
		setUsername();
		setPVN("LV40003245752");
	}
	
	public BusinessUser(String title, String password, String PVN) {
		super(password);
		setNameAndSurnameOrTitle(title);
		setUsername();
		setPVN(PVN);
	}
	
	public String toString() {
		return super.toString() + " " + PVN ;
	}

	public void createPage(String title, String description) throws Exception {
		if (title != null && description != null) {
			for (Page temp: listOfPages) {
				if (temp.getTitle().equals(title)) {
					throw new Exception("Page already exists");
				}
			}
			listOfPages.add(new Page(title, description));
		}
			
	}
	
	public void publishPostsInPage(String pageTitle, String msg) throws Exception {
		if (pageTitle == null && msg == null) throw new Exception("Page not found");
		
		for (Page temp: listOfPages) {
			if(temp.getTitle().equals(pageTitle)) {
				Post newPost = publishPost(PostType.publicPost, msg);
				temp.getPostsInPage().add(newPost);
				return;
			}
		}
		
	}
	
	@Override
	public Post publishPost(PostType type, String msg) throws Exception {
		// TODO Auto-generated method stub
		Post newPost = new Post(msg);
		return newPost;
	}

	

}
