package Grafikoa;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AukeraZ extends JSlider implements ChangeListener{
	
	public AukeraZ(){
		this.setToolTipText("");
		this.setValue(1);
		this.setPaintLabels(true);
		this.setPaintTicks(true);
		this.setMajorTickSpacing(1);
		this.setMaximum(3);
		this.setMinimum(1);
		this.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		Menu.getMenu().balioaAldatu(this.getValue());
	}
}