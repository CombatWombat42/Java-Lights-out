package testing.hello_world;

import java.util.Random;

import javax.swing.JComponent;

public class buttonArray {
	private lightButton[][] buttonArray;
	final private int ival, jval;
	public buttonArray(int ival, int jval) {
		// create an array of lightButtons 
		buttonArray = new lightButton[ival][jval];
		this.ival=ival;
		this.jval=jval;
	}
	public void initArray() {
		//initalize the array of buttons 
	    lightButton iM,iP,jM,jP;
	    lightButton nullButton = new lightButton();
	    //create the buttons
	    for(int i =0;i<ival;i++){
	    	for(int j =0;j<jval;j++){
	    		buttonArray[i][j] = new lightButton();
	    		buttonArray[i][j].addActionListener(buttonArray[i][j]);
	    		buttonArray[i][j].setLabel(Integer.toString(i) + Integer.toString(j));
	    	}
	    }
	    //add neibors to each button
	    for(int i = 0;i<ival;i++){
	    	for(int j = 0;j<jval;j++){
	    		if(i==0){
	    			iM = nullButton;
	    		}else{
	    			iM = buttonArray[i-1][j];
	    		}
	    		if(i==ival-1){
	    			iP = nullButton;
	    		}else{
	    			iP = buttonArray[i+1][j];
	    		}
	    		if(j==0){
	    			jM = nullButton;
	    		}else{
	    			jM = buttonArray[i][j-1];
	    		}
	    		if(j==jval-1){
	    			jP = nullButton;
	    		}else{
	    			jP = buttonArray[i][j+1];
	    		}
	    		buttonArray[i][j].addNeighbors(jM,jP,iM,iP);
	    	}
	    }
		
	}
	public void randomiseButtons() {
		// randomise the buttons to create a hard puzzel
		// TODO fix the unsolvible problem
	    Random generator = new Random();
	    for(int i = 0;i<ival;i++){
	    	for(int j =0;j<jval;j++){
	    		if(generator.nextDouble()<.5){
	    			buttonArray[i][j].toggleWNeb();
	    		}
	    	}
	    }
	}
	public void addToFrame(JComponent frame) {
		// add buttons to the holder
	    for(int i =0;i<ival;i++){
	    	for(int j =0;j<jval;j++){
	    		frame.add(buttonArray[i][j]);
	    	}
	    }
	}


	
}
