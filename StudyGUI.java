import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

	
    public StudyGUI(ArrayList<User> theUsers) {
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
}
