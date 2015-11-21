import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
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
                
                final StudyGUI gui = new StudyGUI(myUserList);
//                gui.start();
            }
        });
    }
    
    public static void loadUsers(File theFile, ArrayList<String> theConnections, ArrayList<String> theClasses, ArrayList<User> theUsers) {
    	try {
	        Scanner s = new Scanner(theFile);
	        while (s.hasNext()) {
	        	String userName = s.next();
	        	String firstName = s.next();
	        	String lastName = s.next();
	        	String school = s.next();
	        	int numClasses = s.nextInt();
	        	for(int i = 0; i < numClasses; i++) {
	        		theClasses.add(s.next());
	        	}
	        	int numConnections = s.nextInt();
	        	for(int i = 0; i < numConnections; i++) {
	        		theConnections.add(s.nextLine());
	        	}
	        	theUsers.add(new User(firstName, lastName, school, null, theClasses));
	        }
		}	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
    }
    
}