package testing.hello_world;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lightButton extends Button implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4805142080452734635L;
	boolean on;
	lightButton mJ;
	lightButton pJ;
	lightButton mI;
	lightButton pI;
	String id;
	
	public lightButton(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.toggle();
	}
	public void toggle() {
		// TODO Auto-generated method stub
		if(on){
			this.setBackground(new Color(0,0,0));
			 
		} else{
			this.setBackground(new Color(255,255,255));
		}
		System.out.print("toggle: " + id);
		this.on = !this.on;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.print(id);
		this.toggle();
		mI.toggle();
		pI.toggle();
		mJ.toggle();
		pJ.toggle();
	}
	public void addNeighbors(lightButton jM, lightButton jP, lightButton iM, lightButton iP) {
			this.mI=iM;
			this.pI=iP;
			this.mJ=jM;
			this.pJ=jP;
		// TODO Auto-generated method stub
		
	}
	
}
