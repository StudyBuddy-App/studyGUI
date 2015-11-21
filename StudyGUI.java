import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

	
//	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

	
    public StudyGUI() {
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
        	if(myUserList.getUserNames.contains(logOnAttempt)) {
        		logOn = true;        		
        	}
        	//user name is not registered 
        	else {
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
