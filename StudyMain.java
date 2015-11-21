import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
   



import javax.swing.*;

import java.awt.event.*;

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
        
        
        //requires photos named p1.jpg , p2.jpg, p0.jpg
     //   displayUsers();
        
 
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
		//System.exit(0); 
    }
    
    public static void displayUsers(User theUser) {
		JFrame myJFrame = new JFrame();

		// create and assign a FlowLayout for myFrame
		myJFrame.setLayout(new BorderLayout());

		// Create a label with an image icon
		JLabel jlCSCI = new JLabel(new ImageIcon("CSCI.jpg"));
		JPanel feedPanel = new JPanel();
		feedPanel.setLayout(new BoxLayout(feedPanel, BoxLayout.PAGE_AXIS));
		// add the Label to the frame 
		myJFrame.add(jlCSCI); // Add thelabel to MyGridLayout

		// set the title, size, location and exit behavior for the frame
		myJFrame.setTitle("ImageIcon Demo");
		myJFrame.setSize(240, 200);
		myJFrame.setLocation(200, 100);
		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// make the frame visible (activate the GUI frame)
		myJFrame.setVisible(true);
		String picture = "p";

		JLabel friendLabel = new JLabel("Your suggested study buddies!");

		friendLabel.setFont(new Font("Serif", Font.BOLD, 30));
		friendLabel.setForeground(Color.WHITE);
		myJFrame.add(friendLabel, BorderLayout.NORTH);
		
		for (int i = 0; i < theUser.myFriends.size(); i++)
		{

		    String filep = picture + i + ".jpg";
		    ImageIcon imageIcon = new ImageIcon(filep);
		    Image image = imageIcon.getImage(); // transform it
		    Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		    imageIcon = new ImageIcon(newimg);  // transform it back


		    JLabel label = new JLabel(theUser.myFriends.get(i).getFirstName() + " " 
		    		+ theUser.myFriends.get(i).getLastName() + "    " +
		    		theUser.myFriends.get(i).myClasses + "     "
		    		, imageIcon, SwingConstants.CENTER);
		    if(i == 0) {
		      label.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            //call view(username1)
		            System.out.println("CLICKED");
		         }
		      });
		    } else if ( i== 1) {
		    label.addMouseListener(new MouseAdapter() {
		         public void mouseClicked(MouseEvent me) {
		            //call view(username1)
		            System.out.println("CLICKED2");
		         }
		      });
		    } else {
		    label.addMouseListener(new MouseAdapter() {
		     public void mouseClicked(MouseEvent me) {
		            //call view(username1)
		            System.out.println("CLICKED3");
		         }
		      });
		    }
		    myJFrame.getContentPane().setBackground(new Color(62, 92, 154));
		    label.setForeground(Color.WHITE);
//		    myJFrame.add(label);
		    feedPanel.setBackground(new Color(62, 92, 154));
		    feedPanel.add(label);
		    myJFrame.add(feedPanel);
		    myJFrame.pack();
		}
	}    
}