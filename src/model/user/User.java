package model.user;

import java.security.MessageDigest;

public abstract class User extends GuestUser{
	private String username;
	//TODO password encoder
	private String password;
	private String nameAndSurnameOrTitle;
	
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
		if (password != null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"))
			this.password = password;
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
		return super.toString() + ":";
	}
	
	//TODO login()
	//TODO followPage
}
