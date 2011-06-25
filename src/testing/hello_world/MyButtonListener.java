package testing.hello_world;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyButtonListener implements ActionListener {
	Button button1;
	int color=2;
	public MyButtonListener(Button button1) {
		// TODO Auto-generated constructor stub
		this.button1 = button1;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		button1.setBackground(new Color(color+=30,255,255));
	}

}
