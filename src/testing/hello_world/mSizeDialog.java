package testing.hello_world;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class mSizeDialog implements ActionListener {
	private buttonScroll frame;
	public mSizeDialog(buttonScroll frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		//System.out.print(this.frame.toString());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		final JDialog sizeDialog = new JDialog();
		final SpinnerNumberModel xSi = new SpinnerNumberModel(3,3,20,1);
		final SpinnerNumberModel ySi = new SpinnerNumberModel(3,3,20,1);
		JSpinner xSize = new JSpinner(xSi);
		JSpinner ySize = new JSpinner(ySi);
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	//System.out.print(frame.toString());
		    	frame.redrawButtons(xSi.getNumber().intValue(), ySi.getNumber().intValue());
		    }
		});
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		        sizeDialog.setVisible(false);
		    }
		});
		sizeDialog.setLayout(new GridLayout(2,2));
		sizeDialog.add(xSize);
		sizeDialog.add(ySize);
		sizeDialog.add(ok);
		sizeDialog.add(cancel);
		sizeDialog.pack();
		sizeDialog.setVisible(true);
	}

}
