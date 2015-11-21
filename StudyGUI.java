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
	public ArrayList<String> myClasses;
	private int classNum;
	public JTextField classID;


	//	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();


	public StudyGUI(ArrayList<User> theUsers, ArrayList<String> theClasses) {
   /*
		myFrame = new JFrame("Study Buddies");
		myAllUsers = theUsers;
		myClasses = theClasses;
		JPanel homePanel = new JPanel(new GridLayout(3, 3, 3, 3));
		JLabel name = new JLabel(myAllUsers.get(0).getFirstName() + " " + myAllUsers.get(0).getLastName());
		homePanel.add(name);
		homePanel.setVisible(true);
		homePanel.setPreferredSize(new Dimension(500, 500));
		myFrame.add(homePanel, BorderLayout.CENTER);
     
		JOptionPane login = new JOptionPane();
		login.showConfirmDialog(homePanel, "Login");
		myFrame.add(login);      
      */
      
		myFrame = new JFrame("Study Buddies");
		myAllUsers = theUsers;
		myClasses = theClasses;
		classID = new JTextField(5);
		JPanel homePanel = new JPanel(new GridLayout());
		homePanel.setVisible(true);
		homePanel.setPreferredSize(new Dimension(1, 500));
		myFrame.add(homePanel, BorderLayout.CENTER);


		/*
		JOptionPane login = new JOptionPane();
		login.showConfirmDialog(homePanel, "Login");
		myFrame.add(login);      
      */
      
		/*
		JOptionPane login = new JOptionPane();
		login.showConfirmDialog(homePanel, "Login");
		myFrame.add(login);
		*/
		demoInputDialog();
	}
	
	public void homePage() {
		
	}

	public void userInfo() {

		JTextField firstName = new JTextField(5);
		JTextField lastName = new JTextField(5);
		JTextField userName = new JTextField(5);
		JTextField schoolName = new JTextField(5);
		JTextField location = new JTextField(5);
		JTextField classes = new JTextField(5);



		JPanel myPanel = new JPanel(new GridLayout(6, 1));
		JPanel classNames = new JPanel();

		myPanel.add(new JLabel("First Name:               "));
		myPanel.add(firstName);
		myPanel.add(Box.createVerticalStrut(15)); // a spacer
		myPanel.add(new JLabel("Last Name:               "));
		myPanel.add(lastName);
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("User Name:               "));
		myPanel.add(userName);
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("School Name:             "));
		myPanel.add(schoolName);
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("Current Location:        "));
		myPanel.add(location);
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("Number of Classes:       "));
		myPanel.add(classes);
		
		User createNew = null;
	//	classNum = Integer.parseInt(number);

		int result = JOptionPane.showConfirmDialog(null, myPanel, 
				"Please Fill in all information", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			createNew = new User(userName.getText(), firstName.getText(), lastName.getText(),
					schoolName.getText(), location.getText());
			myAllUsers.add(createNew);
			
	    		for(int j = 0; j < myAllUsers.size(); j++) {
	    			User otherUser = myAllUsers.get(j);
	    			if(createNew.mySchool.equals(otherUser.mySchool) && !createNew.equals(otherUser)) {
	    				createNew.myFriends.add(otherUser);
	    			}
	    		}
	    		
	    		System.out.println(createNew.myFriends);
	    		
			
		}
		String num = classes.getText();
		int count = Integer.parseInt(num);
		classNames.add(new JLabel("Class number"));
		for(int i = 1; i <= count; i++) {
		//	classNames.add(new JLabel("Class number"));
			classNames.add(classID);
			JOptionPane.showConfirmDialog(null, classNames, "Please Fill in classes", JOptionPane.OK_OPTION);
			System.out.println("The class: " + classID.getText());

			//myClasses.add(classID.getText());
			createNew.myClasses.add(classID.getText());
	//		classID.setText("");
//			System.out.println(myClasses);
		}
        StudyMain.displayUsers(createNew);
		
	//	createNew.setClasses(myClasses);
		myFrame.pack();
	}
	





	public void demoInputDialog() {

		boolean logOn = false; //what the user types is in as guess..valid user = true
		//loop until valid input
		while(!logOn) {
			final String logOnAttempt = JOptionPane.showInputDialog(null,
					"Enter your UserName or click OK to make a new account", "UserName");
			if(logOnAttempt ==null) {
				System.exit(0);
			}

			//user name is registered already
			for(int i = 0; i < myAllUsers.size(); i++) {
				if(myAllUsers.get(i).myUserName.equals(logOnAttempt)) {
					logOn = true;
					System.out.println("Login Successful! Welcome to StudyBuddy!");
			        StudyMain.displayUsers();
				}
			}
			//user name is not registered 
			if(!logOn) {
				int response;
				//ask user if they are registered with yes no dialog
				response = JOptionPane.showConfirmDialog(null,
						"Create new account?", null, JOptionPane.YES_NO_OPTION);
				//user misspelled logon
				if(response == JOptionPane.NO_OPTION) {
					//do nothing
				}
				//sign the new user up
				else {
					userInfo();
					//call new user GUI.
					//get info in this method.
					//add the new user to  the list of users / user information class
					logOn = true;
				}
			}
			System.out.println("Looping");
		}
		//user must be logged on here...go on to splash page

	}


}
