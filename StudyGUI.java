import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * The GUI for Tetris.
 * 
 * @author Shannon Murphy
 * @version 13 March 2015
 */
public class StudyGUI {
	
	private final JFrame myFrame;
	
    public StudyGUI() {
    	myFrame = new JFrame("Study Buddies");
    	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }
}
