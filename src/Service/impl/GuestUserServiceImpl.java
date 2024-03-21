package Service.impl;

import java.util.ArrayList;

import Service.IGuestUserService;
import Service.MainService;
import model.Page;
import model.Post;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.user.User;

public class GuestUserServiceImpl implements IGuestUserService{

	@Override
	public ArrayList<User> findUsers(String nameOrSurnameTitle) throws Exception {
		// TODO Auto-generated method stub
		if( nameOrSurnameTitle == null || nameOrSurnameTitle.length() < 2) throw new Exception("Problems with input");
		
		ArrayList<User> foundUsers = new ArrayList<User>();
		for (GuestUser temp: MainService.allUser) {
			if (temp instanceof PrivateUser || temp instanceof BusinessUser) {
				User user = (User)temp;
				if(user.getNameAndSurnameOrTitle().toLowerCase().contains(nameOrSurnameTitle)) {
					foundUsers.add(user);
				}
			}
		}
		return foundUsers;
	}

	@Override
	public ArrayList<Page> findPages(String titleOrDesctription) throws Exception {
		// TODO Auto-generated method stub
		if( titleOrDesctription == null || titleOrDesctription.length() < 2 ) throw new Exception("Problems with input");
		ArrayList<Page> foundPages = new ArrayList<Page>();
		for(GuestUser temp: MainService.allUser) {
			if(temp instanceof BusinessUser) {
				BusinessUser user = (BusinessUser) temp;
				for (Page tempP: user.getListOfPages()) {
					if (tempP.getTitle().toLowerCase().contains(titleOrDesctription.toLowerCase()) ||
						tempP.getDescription().toLowerCase().contains(titleOrDesctription.toLowerCase())) {
						foundPages.add(tempP);
					}
				}
			}
		}
		return foundPages;
	}

	@Override
	public ArrayList<Post> findInfoInPublicPosts(String msg) throws Exception {
		// TODO Auto-generated method stub
		if ( msg == null || msg.length() < 2) throw new Exception("Problems with input");
		
		ArrayList<Post> foundPosts = new ArrayList<Post>();
		
		for (GuestUser tempU: MainService.allUser) {
			if(tempU instanceof PrivateUser) {
				PrivateUser user = (PrivateUser)tempU;
				for(Post tempP: user.getPublicPosts())
				{
					if(tempP.get_msg().toLowerCase().contains(msg.toLowerCase())) {
						foundPosts.add(tempP);
					}
				}
			}
			else if(tempU instanceof BusinessUser) {
				BusinessUser user = (BusinessUser)tempU;
				for(Page tempPage: user.getListOfPages()) {
					for(Post tempP : tempPage.getPostsInPage()) {
						if(tempP.get_msg().toLowerCase().contains(msg.toLowerCase())) {
							foundPosts.add(tempP);
						}
					}
				}
				
			}
		}
		return foundPosts;
	}

}
