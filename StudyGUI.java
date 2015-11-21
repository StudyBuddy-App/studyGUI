import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.Timer;

/**
 * The GUI for Tetris.
 * 
 * @author Shannon Murphy
 * @version 13 March 2015
 */
public class StudyGUI {

	private final JFrame myFrame;
	
	private static final Toolkit KIT = Toolkit.getDefaultToolkit();
	public List<User> myAllUsers;


	//	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();


    public StudyGUI(ArrayList<User> theUsers) {
    	myFrame = new JFrame("Study Buddies");
    	myAllUsers = theUsers;
    	JPanel homePanel = new JPanel(new GridLayout());
		homePanel.setVisible(true);
		homePanel.setPreferredSize(new Dimension(1, 500));
		myFrame.add(homePanel, BorderLayout.CENTER);

		JOptionPane login = new JOptionPane();
		login.showConfirmDialog(homePanel, "Login");
		myFrame.add(login);

		JTextField firstName = new JTextField(5);
		JTextField lastName = new JTextField(5);
		JTextField userName = new JTextField(5);
		JTextField schoolName = new JTextField(15);
		JTextField location = new JTextField(5);

		
		
		JPanel myPanel = new JPanel();
		
		myPanel.add(new JLabel("First Name:"));
		myPanel.add(firstName);
		myPanel.add(Box.createVerticalStrut(15)); // a spacer
		myPanel.add(new JLabel("Last Name:"));
		myPanel.add(lastName);
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("User Name:"));
		myPanel.add(userName);
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("School Name:"));
		myPanel.add(schoolName);
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("Current Location:"));
		myPanel.add(location);

		int result = JOptionPane.showConfirmDialog(null, myPanel, 
				"Please Fill in all information", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			User createNew = new User(userName.getText(), firstName.getText(), lastName.getText(),
										schoolName.getText(), location.getText());
			myAllUsers.add(createNew);
		}
		myFrame.pack();
	}
	
    
    
    
    
    /*
     * demoInputDialog() uses a joption pane to check for a valid Username. 
     * If the username is invalid (not in the list) then the user must is
     * notified and must repeat the process of logging in (after an error box). 
     * The user is given the ability to sign up if they dont yet have an account.
     */
    public void demoInputDialog() {
    	
        boolean logOn = false; //what the user types is in as guess..valid user = true
        //loop until valid input
        while(!logOn) {
        	final String logOnAttempt = JOptionPane.showInputDialog(null,
        			"Enter your log in", "or desired logon");
        	
        	//user name is registered already
        	for(int i = 0; i < myAllUsers.size(); i++) {
        		if(myAllUsers.get(i).myUserName.equals(logOnAttempt)) {
        			logOn = true;
        		}
        	}
        	//user name is not registered 
        	if(!logOn) {
        		int response;
        		//ask user if they are registered with yes no dialog
        		response = JOptionPane.showConfirmDialog(null,
        				"Are you registered", null, JOptionPane.YES_NO_OPTION);
        		//user misspelled logon
        		if(response == JOptionPane.YES_OPTION) {
        			//do nothing
        		}
        		//sign the new user up
        		else {
        			//call new user GUI.
        			//get info in this method.
        			//add the new user to  the list of users / user information class
        			logOn = true;
        		}
        	}
        }
        //user must be logged on here...go on to splash page
        
    }
		


}




