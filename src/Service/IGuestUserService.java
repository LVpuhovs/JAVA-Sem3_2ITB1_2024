package Service;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.user.User;

public interface IGuestUserService {
	public abstract ArrayList<User> findUsers(String nameOrSurnameTitle) throws Exception;
	public abstract ArrayList<Page> findPages(String titleOrDesctription) throws Exception;
	public abstract ArrayList<Post> findInfoInPublicPosts(String msg)throws Exception;
}
