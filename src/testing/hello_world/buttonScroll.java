package testing.hello_world;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class buttonScroll extends JPanel {
	private int mIval;
	public int getmIval() {
		return mIval;
	}

	public void setmIval(int mIval) {
		this.mIval = mIval;
	}

	private int mJval;
	public int getmJval() {
		return mJval;
	}

	public void setmJval(int mJval) {
		this.mJval = mJval;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8250550689045737102L;
	private GridLayout mLayoutManager;
	public buttonScroll(int ival, int jval) {
		this.mIval = ival;
		this.mJval = jval;
		// TODO Auto-generated constructor stub
	    buttonArray mButtons = new buttonArray(ival,jval);
	    mButtons.initArray();

	    this.mLayoutManager = new GridLayout(ival,jval);
	    this.setLayout(this.mLayoutManager);
	    mButtons.randomiseButtons();
	    mButtons.addToFrame(this);
	}

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
