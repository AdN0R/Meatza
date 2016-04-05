package Grafikoa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Meatza.Jokoa;

public class Ados extends JButton implements MouseListener{
	
	public Ados(){
		this.setText("ADOS");
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
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
		Menu m = Menu.getMenu();
		System.out.println("Identifikazioa: "+m.textuaItzuli()+"\nZailtasuna: "+m.egoera()+"\n\n");
		//Jokoa.getJokoa().hasi(m.egoera()); Deskomentatu metodoa dagoenean
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}