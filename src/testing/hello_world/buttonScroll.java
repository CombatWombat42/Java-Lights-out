package testing.hello_world;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class buttonScroll extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8250550689045737102L;
	private GridLayout mLayoutManager;
	public buttonScroll(int ival, int jval) {
		// TODO Auto-generated constructor stub
	    buttonArray mButtons = new buttonArray(ival,jval);
	    mButtons.initArray();

	    this.mLayoutManager = new GridLayout(ival,jval);
	    this.setLayout(this.mLayoutManager);
	    mButtons.randomiseButtons();
	    mButtons.addToFrame(this);
	}

	public void redrawButtons(int iSize, int jSize){
		this.removeAll();
		buttonArray mButtons = new buttonArray(iSize,jSize);
		mButtons.initArray();
	    mButtons.randomiseButtons();
	    mButtons.addToFrame(this);
	    this.mLayoutManager.setColumns(jSize);
	    this.mLayoutManager.setRows(iSize);
	    this.repaint();
	}
	
}
