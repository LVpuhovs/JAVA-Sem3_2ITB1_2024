package Service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Page;
import model.PostType;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;

public class MainService {
	private static ArrayList<GuestUser> allUser = new ArrayList<GuestUser>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuestUser u1 = new GuestUser();
		GuestUser u2 = new GuestUser();
		PrivateUser u3 = new PrivateUser();
		GuestUser u4 = new GuestUser();
		BusinessUser u5 = new BusinessUser();
		PrivateUser u6 = new PrivateUser("Markuss", "Puhovs", "Mp123456");
		BusinessUser u7 = new BusinessUser("Hesburger", "1234567He", "LV12345678012");
		
		allUser.addAll(Arrays.asList(u1,u2,u3,u4,u5,u6,u7));
		
		for (GuestUser temp: allUser) {
			System.out.println(temp);
		}
		
		try {
			u6.publishPost(PostType.privatePost, "Man nekas nepatilk");
			u6.publishPost(PostType.publicPost, "Ata!!!");
			
			u6.followPrivateUser(u3);
			u6.followPrivateUser(u7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------------------");
		
		System.out.println(u6.getUsername() + ": private posts ->");
		System.out.println(u6.getPrivatePosts());
		System.out.println(u6.getUsername() + ": public posts ->");
		System.out.println(u6.getPublicPosts());
		
		System.out.println(u6.getUsername() + ": followers");
		System.out.println(u6.getFollowers());
		
		try {
			u7.createPage("Hesburger Ventspils", "Jaunumi par Hesburgeru Ventspili");
			u7.createPage("Hesburger Daugavpils", "Jaunumi par Hesburgeru Daugavpili");
			
			u7.publishPostsInPage("Hesburger Ventspils", "20% atlaide siera burgeriem");
			u7.publishPostsInPage("Hesburger Ventspils", "50% atlaide bernu komplektiem");
			
			u7.publishPostsInPage("Hesburger Daugavpils", "10% atlaide saldejumam");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------");
		System.out.println(u7.getUsername() + ": Pages -> ");
		for (Page temp: u7.getListOfPages()) {
			System.out.println(temp + " ->");
			System.out.println(temp.getPostsInPage());
			System.out.println();
		}
	}

}
