/**
 * 
 */
package testing.hello_world;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * @author povilus
 *
 */
public class Java_hello_world {
	public static final int JVAL = 4;
	public static final int IVAL = 4;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    JFrame frame = new JFrame("HelloWorldSwing");
	    buttonArray mButtons = new buttonArray(IVAL,JVAL);
	    mButtons.initArray();

	    GridLayout mLayoutManager = new GridLayout(IVAL,JVAL);
	    frame.setLayout(mLayoutManager);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mButtons.randomiseButtons();
	    mButtons.addToFrame(frame);
	    frame.pack();
	    frame.setSize(400, 400);
	    frame.setVisible(true);
	}

}
