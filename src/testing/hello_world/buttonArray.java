package testing.hello_world;

import java.util.Random;

import javax.swing.JFrame;

public class buttonArray {
	private lightButton[][] buttonArray;
	private int ival, jval;
	public buttonArray(int ival, int jval) {
		// TODO Auto-generated constructor stub
		buttonArray = new lightButton[ival][jval];
	}
	public void initArray() {
		// TODO Auto-generated method stub
	    lightButton iM,iP,jM,jP;
	    lightButton nullButton = new lightButton("nullButton\n");
	    for(int i =0;i<ival;i++){
	    	for(int j =0;j<jval;j++){
	    		buttonArray[i][j] = new lightButton("i:" +Integer.toString(i) + " j:" +Integer.toString(j) +"\n");
	    		buttonArray[i][j].addActionListener(buttonArray[i][j]);
	    		buttonArray[i][j].setLabel(Integer.toString(i) + Integer.toString(j));
	    	}
	    }
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
		// TODO Auto-generated method stub
	    Random generator = new Random();
	    for(int i = 0;i<ival;i++){
	    	for(int j =0;j<jval;j++){
	    		if(generator.nextDouble()<.5){
	    			buttonArray[i][j].toggleWNeb();
	    		}
	    	}
	    }
	}
	public void addToFrame(JFrame frame) {
		// TODO Auto-generated method stub
	    for(int i =0;i<ival;i++){
	    	for(int j =0;j<jval;j++){
	    		frame.add(buttonArray[i][j]);
	    	}
	    }
	}


	
}
