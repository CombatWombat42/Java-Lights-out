package testing.hello_world;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class lightsFrame extends JFrame {
	public static final int JVAL = 3;
	public static final int IVAL = 3;
	private JMenuBar menuBar;
	private JMenu options;
	private buttonScroll mLightScroll;
	
	public lightsFrame(String string) {
		// Create a frame that contains the game and a menu for setting options
		this.setTitle(string);
	    this.mLightScroll = new buttonScroll(IVAL,JVAL);
	    initMenu();
	    this.setJMenuBar(this.menuBar);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.add(mLightScroll);
	    this.pack();
	    this.setSize(400, 400);
	    this.setVisible(true);
	}

	private void initMenu() {
		// create the menu for the program
	    this.menuBar = new JMenuBar();
	    options = new JMenu("Options");
	    options.setMnemonic(KeyEvent.VK_O);
	    options.getAccessibleContext().setAccessibleDescription(
	    "The only menu in this program that has menu items");
	    this.menuBar.add(options);
	    JMenuItem sizeMItem = new JMenuItem("Set size",
	    		KeyEvent.VK_S);
	    sizeMItem.setAccelerator(KeyStroke.getKeyStroke(
	    		KeyEvent.VK_S, ActionEvent.ALT_MASK));
	    sizeMItem.getAccessibleContext().setAccessibleDescription(
	    "Set the size of the puzzle");
	    options.add(sizeMItem);
	    mSizeDialog sizeDia = new mSizeDialog(this.mLightScroll);
	    sizeMItem.addActionListener(sizeDia);
	    JMenuItem redrawMItem = new JMenuItem("Redraw",
	    		KeyEvent.VK_R);
	    redrawMItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		        mLightScroll.redrawButtons();
		    }
		});
	    options.add(redrawMItem);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 2681439085050782109L;

}
