package testing.hello_world;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class mSizeDialog implements ActionListener {
	private buttonScroll parent;
	public mSizeDialog(buttonScroll parent) {
		// create a zize dialog and store parent
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Generate the dialog to select game size
		final JDialog sizeDialog = new JDialog();
		final SpinnerNumberModel xSi = new SpinnerNumberModel(parent.getmIval(),3,20,1);
		final SpinnerNumberModel ySi = new SpinnerNumberModel(parent.getmJval(),3,20,1);
		JSpinner xSize = new JSpinner(xSi);
		JSpinner ySize = new JSpinner(ySi);
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
		    	//System.out.print(frame.toString());
		    	parent.setmIval(xSi.getNumber().intValue());
		    	parent.setmJval(ySi.getNumber().intValue());
		    	parent.redrawButtons();
		    	sizeDialog.setVisible(false);
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
