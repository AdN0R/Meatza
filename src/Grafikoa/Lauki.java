package Grafikoa;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Meatza.Jokoa;

public class Lauki extends JButton implements MouseListener{
	
	private int i,j;
	
	public Lauki(int pI, int pJ){
		this.i=pI;
		this.j=pJ;
		this.addMouseListener(this);
	}
	
	public void aldatuIrudia(int pM){
		if(pM==0){
			this.setIcon(new ImageIcon("Irudiak/0.png"));
		}
		else if(pM==-1){
			this.setIcon(new ImageIcon("Irudiak/mine.png"));
		}
		else if(pM==1){
			this.setIcon(new ImageIcon("Irudiak/1.png"));
		}
		else if(pM==2){
			this.setIcon(new ImageIcon("Irudiak/2.png"));
		}
		else if(pM==3){
			this.setIcon(new ImageIcon("Irudiak/3.png"));
		}
		else if(pM==4){
			this.setIcon(new ImageIcon("Irudiak/4.png"));
		}
		else if(pM==5){
			this.setIcon(new ImageIcon("Irudiak/5.png"));
		}
		else if(pM==6){
			this.setIcon(new ImageIcon("Irudiak/6.png"));
		}
		else if(pM==7){
			this.setIcon(new ImageIcon("Irudiak/7.png"));
		}
		else if(pM==8){
			this.setIcon(new ImageIcon("Irudiak/8.png"));
		}
		else if(pM==9){
			this.setIcon(new ImageIcon("Irudiak/flag.png"));
		}
		else if(pM==10){
			this.setIcon(null);
		}
		else{}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!Leihoa.getLeihoa().amaituta()){
			if(arg0.getClickCount()==2 &&arg0.getButton()==MouseEvent.BUTTON1){
				Jokoa.getJokoa().klikBikoitza(i,j);
			}
		}
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
		if(!Leihoa.getLeihoa().amaituta()){
			Jokoa j = Jokoa.getJokoa();
			j.klikatu(this.i,this.j,arg0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}