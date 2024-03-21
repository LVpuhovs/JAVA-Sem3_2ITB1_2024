package model.user;

import java.time.LocalDateTime;

import Service.impl.GuestUserServiceImpl;

public class GuestUser {
	private long UserID;
	
	private static long counter = 0;
	
	public GuestUserServiceImpl service = new GuestUserServiceImpl();

	public long getUserID() {
		return UserID;
	}

	public void setUserID() {
		this.UserID = counter ++;
	}
	public GuestUser() {
		setUserID();
	}
	public String toString() {
		return "" + UserID;
	}
	
	//other functions
	//TODO find user
	//TODO find page
	//TODO find public posts of private user
	//TODO find public posts of page
	
}
