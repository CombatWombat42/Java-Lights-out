/**
 * 
 */
package testing.hello_world;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;

/**
 * @author povilus
 *
 */
public class Java_hello_world {
	static lightButton[][] buttonArray;
	public static final int JVAL = 20;
	public static final int IVAL = 20;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    JFrame frame = new JFrame("HelloWorldSwing");
	    Random generator = new Random();
	    buttonArray = new lightButton[IVAL][JVAL];
	    lightButton iM,iP,jM,jP;
	    lightButton nullButton = new lightButton("nullButton\n");
	    for(int i =0;i<IVAL;i++){
	    	for(int j =0;j<JVAL;j++){
	    		buttonArray[i][j] = new lightButton("i:" +Integer.toString(i) + " j:" +Integer.toString(j) +"\n");
	    		buttonArray[i][j].addActionListener(buttonArray[i][j]);
	    		buttonArray[i][j].setLabel(Integer.toString(i) + Integer.toString(j));
	    	}
	    }
	    for(int i = 0;i<IVAL;i++){
	    	for(int j = 0;j<JVAL;j++){
	    		if(i==0){
	    			iM = nullButton;
	    		}else{
	    			iM = buttonArray[i-1][j];
	    		}
	    		if(i==IVAL-1){
	    			iP = nullButton;
	    		}else{
	    			iP = buttonArray[i+1][j];
	    		}
	    		if(j==0){
	    			jM = nullButton;
	    		}else{
	    			jM = buttonArray[i][j-1];
	    		}
	    		if(j==JVAL-1){
	    			jP = nullButton;
	    		}else{
	    			jP = buttonArray[i][j+1];
	    		}
	    		buttonArray[i][j].addNeighbors(jM,jP,iM,iP);
	    	}
	    }
	    GridLayout mLayoutManager = new GridLayout(IVAL,JVAL);
	    frame.setLayout(mLayoutManager);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setSize(400, 400);
	    for(int i = 0;i<IVAL;i++){
	    	for(int j =0;j<JVAL;j++){
	    		if(generator.nextDouble()<.5){
	    			buttonArray[i][j].toggle();
	    		}
	    	}
	    }
	    for(int i =0;i<IVAL;i++){
	    	for(int j =0;j<JVAL;j++){
	    		frame.add(buttonArray[i][j]);
	    	}
	    }
	    //frame.add(button0);
	    //frame.add(button1);
	    frame.setVisible(true);
	}

}
