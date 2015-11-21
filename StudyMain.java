import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public final class StudyMain {

    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private StudyMain() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the Study GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                
//                User user = new User(null, null, null, null, null);
                File userFile = new File("./users.txt");
                ArrayList<User> myUserList = new ArrayList<User>();
                ArrayList<String> myClassList = new ArrayList<String>();
        		ArrayList<String> myConnections = new ArrayList<String>();
                loadUsers(userFile, myConnections, myClassList, myUserList);                
                
                final StudyGUI gui = new StudyGUI(myUserList, myClassList);
//                gui.start();
                
//                System.out.println(myUserList);
                outputUsers(userFile, myUserList);
            }
        });
        

        
    }
    
    public static void loadUsers(File theFile, ArrayList<String> theConnections, ArrayList<String> theClasses, ArrayList<User> theUsers) {
    	try {
	        Scanner s = new Scanner(theFile);
	        while (s.hasNext()) {
	        	theClasses.clear();
	        	String userName = s.next();
	        	String firstName = s.next();
	        	String lastName = s.next();
	        	String school = s.next();
	        	String location = s.next();
	        	int numClasses = s.nextInt();
	        	for(int i = 0; i < numClasses; i++) {
	        		theClasses.add(s.next());
	        	}
	        	User newUser = new User(userName, firstName, lastName, school, location);
	        	newUser.setClasses(theClasses);
	        	
//	        	System.out.println(newUser.myUserName + " " + newUser.getClasses());
	        	
	        	theUsers.add(newUser);
	        	

	        }
		}	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
    	
    	for(int i = 0; i < theUsers.size(); i++) {
    		User user = theUsers.get(i); 
    		for(int j = 0; j < theUsers.size(); j++) {
    			User otherUser = theUsers.get(j);
    			if(user.mySchool.equals(otherUser.mySchool) && !user.equals(otherUser)) {
    				user.myFriends.add(otherUser);
    			}
    			
    		}
    		
    	}
    	
//    	System.out.println(theUsers.get(0).myFriends);
//    	System.out.println(theUsers.get(0).getClasses());

    }
    
    public static void outputUsers(File theFile, ArrayList<User> theUsers) {
    	PrintStream out = null;
		
		try 
		{
			out = new PrintStream(theFile);
		} 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		
		for(int i = 0; i < theUsers.size(); i++) {
			User user = theUsers.get(i);
			out.print(user.myUserName + " " + user.myFirstName + " " + user.myLastName + " " +
			user.mySchool + " "+ user.myLocation);
			out.print(" " + user.getClasses().size());
			for(int j = 0; j < user.getClasses().size(); j++) {
				out.print(" " + user.getClasses().get(j));
			}
			out.println();
		}
		
    }
    
}