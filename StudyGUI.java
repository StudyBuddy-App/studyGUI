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
	public List<String> myClasses;
	private int classNum;


	//	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();


	public StudyGUI(ArrayList<User> theUsers, List<String> theClasses) {
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
		JPanel homePanel = new JPanel(new GridLayout());
		homePanel.setVisible(true);
		homePanel.setPreferredSize(new Dimension(1, 500));
		myFrame.add(homePanel, BorderLayout.CENTER);

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



		JPanel myPanel = new JPanel();
		JPanel classNames = new JPanel();

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
		myPanel.add(Box.createVerticalStrut(15));
		myPanel.add(new JLabel("Number of Classes:"));
		myPanel.add(classes);
		
		
	//	classNum = Integer.parseInt(number);

		int result = JOptionPane.showConfirmDialog(null, myPanel, 
				"Please Fill in all information", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			User createNew = new User(userName.getText(), firstName.getText(), lastName.getText(),
					schoolName.getText(), location.getText());
			myAllUsers.add(createNew);
		}
		String num = classes.getText();
		int count = Integer.parseInt(num);
		for(int i = 1; i <= count; i++) {
			JTextField classID = new JTextField(5);
			classNames.add(new JLabel("Class number"));
			classNames.add(classID);
			String class1 = classID.getText();
			myClasses.add(class1);	
		}
		JOptionPane.showConfirmDialog(null, classNames, "Please Fill in classes", JOptionPane.OK_OPTION);
		myFrame.pack();
	}





	public void demoInputDialog() {

		boolean logOn = false; //what the user types is in as guess..valid user = true
		//loop until valid input
		while(!logOn) {
			final String logOnAttempt = JOptionPane.showInputDialog(null,
					"Enter your log in", "or desired logon");
			if(logOnAttempt ==null) {
				System.exit(0);
			}

			//user name is registered already
			for(int i = 0; i < myAllUsers.size(); i++) {
				if(myAllUsers.get(i).myUserName.equals(logOnAttempt)) {
					logOn = true;
					System.out.println("Logon Succesful, user found in userbase");
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