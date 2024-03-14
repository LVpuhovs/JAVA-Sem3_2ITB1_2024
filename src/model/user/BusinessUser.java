package model.user;

import java.util.ArrayList;

import model.Page;
import model.PostType;

public class BusinessUser extends User{
	private ArrayList<Page> listOfPages = new ArrayList<Page>();
	private String PVN;
	
	public String getPVN() {
		return PVN;
	}

	public void setPVN(String pVN) {
		if ( PVN != null && PVN.matches("[A-Z]{2}[0-9]{11}"))
			this.PVN = pVN;
		else
			this.PVN = "-----------";
	}

	public ArrayList<Page> getListOfPages() {
		return listOfPages;
	}
	@Override
	public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
		// TODO Auto-generated method stub
		if (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-za-z0-9%&+@,.!]{3,50"))
			super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
		else
			super.nameAndSurnameOrTitle = "----------------------";
	}

	@Override
	public void publishPost(PostType type, String msg) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
