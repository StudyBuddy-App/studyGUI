import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
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

	private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

	
    public StudyGUI() {
    	myFrame = new JFrame("Study Buddies");
    	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocation(SCREEN_SIZE.width / 2 - myFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - myFrame.getHeight() / 2);
        myFrame.setResizable(true);
        myFrame.setVisible(true);
        myFrame.pack();
    }
}
