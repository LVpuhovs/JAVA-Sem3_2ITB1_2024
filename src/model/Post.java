package model;

import java.util.Date;

public class Post {
	private String msg;
	private Date date;
	private int countOfLikes;
	
	public String get_msg() {
		return msg;
	}
	public Date getdate() {
		return date;
	}
	public int getCountOfLikes() {
		return countOfLikes;
	}
	
	public void set_msg() {
		if (msg != null)
			this.msg = msg;
		else
			this.msg = "undefinied";
	}
	public void setdate(Date date) {
		if (date != null)
			this.date = date;
			else
				this.date = new Date();
	}
	public void setCountOfLikes() {
		this.countOfLikes = countOfLikes;
	}
}
