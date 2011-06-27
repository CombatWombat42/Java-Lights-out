package testing.hello_world;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * The Class lightsFrame.
 */
public class lightsFrame extends JFrame {
	
	/** The Constant inital j size of the array. */
	public static final int JVAL = 3;
	
	/** The Constant inital i size of the array. */
	public static final int IVAL = 3;
	
	/** The menu bar. */
	private JMenuBar menuBar;
	
	/** The options menu. */
	private JMenu options;
	
	/** My light pane. */
	private buttonVComp mLightPane;
	
	/**
	 * Instantiates a new lights frame.
	 *
	 * @param string the title of the frame
	 */
	public lightsFrame(String string) {
		// Create a frame that contains the game and a menu for setting options
		this.setTitle(string);
	    this.mLightPane = new buttonVComp(IVAL,JVAL);
	    initMenu();
	    this.setJMenuBar(this.menuBar);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.add(mLightPane);
	    this.pack();
	    this.setSize(400, 400);
	    this.setVisible(true);
	}

	/**
	 * initalises the menu.
	 */
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
	    mSizeDialog sizeDia = new mSizeDialog(this.mLightPane);
	    sizeMItem.addActionListener(sizeDia);
	    JMenuItem redrawMItem = new JMenuItem("Redraw",
	    		KeyEvent.VK_R);
	    redrawMItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		        mLightPane.redrawButtons();
		    }
		});
	    options.add(redrawMItem);
	}


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2681439085050782109L;

}
