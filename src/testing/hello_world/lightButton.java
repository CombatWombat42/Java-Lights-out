package testing.hello_world;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class lightButton.
 */
public class lightButton extends Button implements ActionListener {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4805142080452734635L;
	
	/** is button on? */
	boolean on;
	
	/** The button to the negative j direction. */
	private lightButton mJ;
	
	/** The button to the positive j direction. */
	private lightButton pJ;
	
	/** The button to the negative i direction. */
	private lightButton mI;
	
	/** The button to the positive i direction. */
	private lightButton pI;
	
	/**
	 * Instantiates a new light button.
	 */
	public lightButton() {
		//toggle to get away from grey.
		this.toggle();
	}
	
	/**
	 * Toggle.
	 */
	public void toggle() {
		// toggle the button
		if(on){
			this.setBackground(new Color(0,0,0));
			 
		} else{
			this.setBackground(new Color(255,255,255));
		}
		//System.out.print("toggle: " + id);
		this.on = !this.on;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.toggleWNeb();
	}
	
	/**
	 * Adds the neighbors.
	 *
	 * @param jM the j m
	 * @param jP the j p
	 * @param iM the i m
	 * @param iP the i p
	 */
	public void addNeighbors(lightButton jM, lightButton jP, lightButton iM, lightButton iP) {
		//add buttons above, below, left and right	
		this.mI=iM;
		this.pI=iP;
		this.mJ=jM;
		this.pJ=jP;		
	}
	
	/**
	 * Toggle this button and all neibors.
	 */
	public void toggleWNeb() {
		// toggle this button and its neibors
		this.toggle();
		this.mI.toggle();
		this.pI.toggle();
		this.mJ.toggle();
		this.pJ.toggle();
		}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#toString()
	 * write out the button status, "1" is true "0" false
	 */
	@Override
	public String toString(){
		if(this.on){
			return "1";
		} else {
			return "0";
		}
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
	
}
