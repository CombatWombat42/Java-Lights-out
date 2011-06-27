package testing.hello_world;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * The Class buttonVComp. creates a JPannel of lightButtons in a grid.
 */
public class buttonVComp extends JPanel {
	
	/** The I size of the array. */
	private int mIval;
	
	/**
	 * Gets the I size of the array.
	 *
	 * @return the I size of the array
	 */
	public int getmIval() {
		return mIval;
	}

	/**
	 * Sets the I size of the array.
	 *
	 * @param mIval the new I size of the array
	 */
	public void setmIval(int mIval) {
		this.mIval = mIval;
	}

	/** The J size of the array. */
	private int mJval;
	
	/**
	 * Gets the J size of the array.
	 *
	 * @return the J size of the array
	 */
	public int getmJval() {
		return mJval;
	}

	/**
	 * Sets J size of the array.
	 *
	 * @param mJval the new J size of the array
	 */
	public void setmJval(int mJval) {
		this.mJval = mJval;
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8250550689045737102L;
	
	/** The layout manager. */
	private GridLayout mLayoutManager;
	
	/**
	 * Instantiates a new button visual comp.
	 *
	 * @param ival the I size of the array
	 * @param jval the J size of the array
	 */
	public buttonVComp(int ival, int jval) {
		this.mIval = ival;
		this.mJval = jval;
		// create a pane of buttons
	    buttonArray mButtons = new buttonArray(ival,jval);
	    mButtons.initArray();

	    this.mLayoutManager = new GridLayout(ival,jval);
	    this.setLayout(this.mLayoutManager);
	    mButtons.randomiseButtons();
	    mButtons.addToFrame(this);
	}

	/**
	 * Redraw buttons and randomises.
	 */
	public void redrawButtons(){
		this.removeAll();
		buttonArray mButtons = new buttonArray(mIval,mJval);
		mButtons.initArray();
	    mButtons.randomiseButtons();
	    mButtons.addToFrame(this);
	    this.mLayoutManager.setColumns(mJval);
	    this.mLayoutManager.setRows(mIval);
	    this.repaint();
	    this.revalidate();
	}
	
}
