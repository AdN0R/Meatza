package Grafikoa;

import Meatza.Jokoa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;


public class Lauki extends JButton implements Observer, MouseListener{
	
	private int i,j;
	// irudiak
	
	public Lauki(int pI, int pJ, String pIzena){
		super(pIzena);
		this.i=pI;
		this.j=pJ;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		Jokoa j = Jokoa.getJokoa();
		//j.gelaxkaIreki(this.i,this.j);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}