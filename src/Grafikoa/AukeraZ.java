package Grafikoa;

import javax.swing.JSlider;

public class AukeraZ extends JSlider{
	
	public AukeraZ(){
		this.setToolTipText("");
		this.setValue(2);
		this.setPaintLabels(true);
		this.setPaintTicks(true);
		this.setMajorTickSpacing(1);
		this.setMaximum(3);
		this.setMinimum(1);
	}
	
	public int egoera(){
		return this.getValue();
	}
	
}