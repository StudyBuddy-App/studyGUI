import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class User {
	String myFirstName;
	String myLastName;
	String mySchool;
	Image myImage;
	List<String> myClasses;
	List<User> myFriends;
	
	
	
	public User(String theFirstName, String theLastName, String theSchool, Image theImage,
				List<String> theClasses) {
		myFirstName = theFirstName;
		myLastName = theLastName;
		mySchool = theSchool;
		myImage = theImage;
		myClasses = new ArrayList<String>(theClasses);
	}
	
	public List<String> getClasses() {
		return myClasses;
	}
	 
	public void setFirstName(String theFN) {
		myFirstName = theFN;
	}
	
	public void setLastname(String theLN) {
		myLastName = theLN;
	}
	
	public void setSchool(String school) {
		mySchool = school;
	}
	
	public String getSchool() {
		return mySchool;
	}
	
	public List<User> getFriends() {
		return myFriends;
	}
	
	public void addFriend(User friend) {
		myFriends.add(friend);
	}
	
	public void removeFriend(User friend) {
		if (myFriends.contains(friend)) {
			int i = myFriends.indexOf(friend);
			myFriends.remove(i);
		} else {
			System.out.println("Friend already Removed!");
		}
	}
}
