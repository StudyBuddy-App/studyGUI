import java.awt.BorderLayout;
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
	public List<User> allUsers;


	//	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();


    public StudyGUI(ArrayList<User> theUsers) {
    	allUsers = theUsers;
    	myFrame = new JFrame("Study Buddies");
    	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
//                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
        myFrame.setResizable(true);
        myFrame.setVisible(true);
		

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
			allUsers.add(createNew);
		}
		myFrame.pack();
	}
	
//	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

}




