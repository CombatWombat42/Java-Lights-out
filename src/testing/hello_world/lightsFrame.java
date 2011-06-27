package testing.hello_world;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
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
	    this.setSize(800, 800);
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
	    options.add(this.sizeMenuItem());
	    options.add(this.redrawMenuItem());
	    options.add(this.saveMenuItem());
	    options.add(this.loadMenuItem());
	}

	private JMenuItem loadMenuItem() {
	    JMenuItem loadMenuItem = new JMenuItem("Load",
	    		KeyEvent.VK_L);
	    loadMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	//TODO this is not good/safe
		    	File loadFile = null;
		    	FileReader loadFileReader = null;
		    	BufferedReader loadBufferedReader = null;
		        //System.out.print(mLightPane.toString());
		    	JFileChooser loadFileChooser = new JFileChooser();
		    	int returnVal = loadFileChooser.showOpenDialog(rootPane);
		    	if (returnVal == JFileChooser.APPROVE_OPTION) {
			    	loadFile = loadFileChooser.getSelectedFile();
			    	try {
						loadFileReader = new FileReader(loadFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					loadBufferedReader = new BufferedReader(loadFileReader);
					try {
						mLightPane.loadFromString(loadBufferedReader.readLine());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						loadFileReader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }
	    });
	    
		return loadMenuItem;
	}

	private JMenuItem saveMenuItem(){
	    JMenuItem saveMenuItem = new JMenuItem("Save",
	    		KeyEvent.VK_S);
	    saveMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	File saveFile = null;
		    	FileWriter saveFileWriter = null;
		        //System.out.print(mLightPane.toString());
		    	JFileChooser saveFileChooser = new JFileChooser();
		    	int returnVal = saveFileChooser.showSaveDialog(rootPane);
		    	if (returnVal == JFileChooser.APPROVE_OPTION) {
			    	saveFile = saveFileChooser.getSelectedFile();
			    	try {
						saveFileWriter = new FileWriter(saveFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						saveFileWriter.write(mLightPane.toString());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						saveFileWriter.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }
		});
	    return saveMenuItem;
	}
	
	
	private JMenuItem redrawMenuItem(){
	    JMenuItem redrawMItem = new JMenuItem("Redraw",
	    		KeyEvent.VK_R);
	    redrawMItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		        mLightPane.redrawButtons();
		    }
		});
	    return redrawMItem;
	}
	
	private JMenuItem sizeMenuItem(){
	    JMenuItem sizeMItem = new JMenuItem("Set size",
	    		KeyEvent.VK_S);
	    sizeMItem.setAccelerator(KeyStroke.getKeyStroke(
	    		KeyEvent.VK_S, ActionEvent.ALT_MASK));
	    sizeMItem.getAccessibleContext().setAccessibleDescription(
	    "Set the size of the puzzle");
	    mSizeDialog sizeDia = new mSizeDialog(this.mLightPane);
	    sizeMItem.addActionListener(sizeDia);
	    return sizeMItem;
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2681439085050782109L;

}
