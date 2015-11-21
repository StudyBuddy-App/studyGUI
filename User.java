import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class User {
	String myUserName;
	String myFirstName;
	String myLastName;
	String mySchool;
	String myLocation;
	Image myImage;
	List<String> myClasses;
	List<User> myFriends;
	
	
	
	public User(String theUserName, String theFirstName, String theLastName, String theSchool,
				String theLocation) {
		myUserName = theUserName;
		myFirstName = theFirstName;
		myLastName = theLastName;
		mySchool = theSchool;
		myLocation = theLocation;
//		myImage = string;
		myClasses = new ArrayList<String>();
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
	
	public String toString() {
		return myFirstName + " " + myLastName;
	}
}
