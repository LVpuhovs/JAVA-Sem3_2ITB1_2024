package model.user;

import java.time.LocalDateTime;

public class GuestUser {
	private long UserID;
	
	private static long counter = 0;

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
