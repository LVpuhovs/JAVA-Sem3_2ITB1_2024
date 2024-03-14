package model;

import java.time.LocalDateTime;


public class Post {
	private LocalDateTime dateTime;
	private String msg;
	private int countOfLikes = 0;
	
	public String get_msg() {
		return msg;
	}
	public int getCountOfLikes() {
		return countOfLikes;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}
	public void set_msg(String msg) {
		if (msg != null && msg.length() > 5 && msg.length() < 300)
			this.msg = msg;
		else
			this.msg = "------------------";
	}
	//TODO glabajam lietotajsu kuri piespiedusi like
	
	public void incrementCountOfLikes() {
		this.countOfLikes++;
	}
	public Post() {
		set_msg("Test msg");
		setDateTime();
		
	}
	
	public Post(String msg) {
		set_msg(msg);
		setDateTime();
		
	}
	
	public String toString() {
		return msg + " (" + dateTime  + ") likes[" + countOfLikes + "]";
	}
}
