package model.user;

import java.security.MessageDigest;

import Service.IPostService;

public abstract class User extends GuestUser implements IPostService{
	private String username;
	//TODO password encoder
	private String password;
	protected String nameAndSurnameOrTitle;
	
	public String getUsername() {
		return username;
	}
	public void setUsername() {
		this.username = nameAndSurnameOrTitle + "_" + getUserID();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		//TODO ievietot enkodesanu
		if (password != null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,40}$")) {
			try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			this.password = new String(md.digest());
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else
			this.password = "-------------";
	}
	public String getNameAndSurnameOrTitle() {
		return nameAndSurnameOrTitle;
	}
	public abstract void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle);
	
	public User(){
		super();
		setPassword("1234567890");
	}
	public User(String password) {
		super();
		setPassword(password);
	}
	
	public String toString() {
		return super.toString() + ":" + nameAndSurnameOrTitle + "(" + username + ")";
	}
	
	//TODO login()
	//TODO followPage
}
