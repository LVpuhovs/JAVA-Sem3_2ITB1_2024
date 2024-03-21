package model.user;

import java.util.ArrayList;

import model.Post;
import model.PostType;

public class PrivateUser extends User{

	private ArrayList<Post> privatePosts = new ArrayList<Post>();
	private ArrayList<Post> publicPosts = new ArrayList<Post>();
	private ArrayList<User> followers = new ArrayList<User>();
	
	public ArrayList<Post> getPrivatePosts() {
		return privatePosts;
	}

	public ArrayList<Post> getPublicPosts() {
		return publicPosts;
	}

	public ArrayList<User> getFollowers() {
		return followers;
	}
	@Override
	public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
		// TODO Auto-generated method stub
		if (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-Z]{1}+[a-z]+ [A-Z]{1}+[a-z]+")) {
			super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
		}else {
			super.nameAndSurnameOrTitle = "-------------";
		}
	}
	
	public PrivateUser() {
		super();
		setNameAndSurnameOrTitle("Janis Berzins");
		setUsername();
	}
	
	public PrivateUser(String name, String surname, String password) {
		super(password);
		setNameAndSurnameOrTitle(name + " " + surname);
		setUsername();
	}
	
	public String toString() {
		return super.toString() + "[" +(privatePosts.size() + publicPosts.size()) + " posts]";
	}
	
//other functions
	@Override
	public Post publishPost(PostType type, String msg) throws Exception {
		// TODO Auto-generated method stub
		if (type == null && msg == null) throw new Exception("Problems with input");
		Post newPost = new Post(msg);
		
		if ( type.equals(PostType.privatePost)) privatePosts.add(newPost);
		else if (type.equals(PostType.publicPost)) publicPosts.add(newPost);
		
		return newPost;
	}
	
	public void followPrivateUser(User user) throws Exception {
		if (user == null) throw new Exception("Problems with user input");
		
		for(User temp: followers) {
			if (temp.getUsername().equals(user.getUsername())) {
				throw new Exception("User is already as follower");
			}
		}
		followers.add(user);
	}
}
