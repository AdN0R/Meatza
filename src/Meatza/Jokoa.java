package Meatza;

import java.awt.event.MouseEvent;

import Grafikoa.Leihoa;

public class Jokoa {
	
	private static Jokoa nJokoa;
	private TableroBuilder tableroBuilder;
	private Tableroa tableroa;
	private int minaKop;
	private int zenbatGelditu;

	private Jokoa(){
		tableroBuilder = new TableroBuilder();
	}
	
	public static Jokoa getJokoa(){
		if (nJokoa == null) {
			nJokoa = new Jokoa();
		}
		return nJokoa;
	}
	
	public Tableroa getTableroa(){
		return tableroa;
	}
	
	private void tableroaSortu() {
		tableroBuilder.tableroaSortu();
		tableroa = tableroBuilder.getTablero();
		minaKop = tableroa.getMinaKop();
		zenbatGelditu = tableroa.getTamaina() - minaKop;
	}
	
	public int tableroarenAltuera(){
		return this.tableroa.getI();
	}
	
	public int tableroarenZabalera(){
		return this.tableroa.getJ();
	}

	public void inguruaIreki(int i, int j) {
		tableroa.inguruaIreki(i,j);
	}

	public void gelaxkaBatKendu() {
		zenbatGelditu--;
	}

	public void minaKopGutxitu(){ // zer da minakop ?
		this.minaKop--;
	}

	public boolean irabazi() {
		if (zenbatGelditu==0){
			return true;
		}
		else {
			return false;
		}
	}

	public void klikatu(int i, int j,MouseEvent e){ //TODO
		if(e.getButton()==MouseEvent.BUTTON1){
			if(!this.tableroa.markatuta(i,j)){
				this.tableroa.gelaxkaIreki(i,j);
			}
		}
		else if(e.getButton()==MouseEvent.BUTTON3){
			this.tableroa.gelaxkaMarkatu(i,j);
		}
	}

	public int motaItzuli(int i, int j){
		return tableroa.motaItzuli(i,j);
	}
	
	public static void main (String[] args){
		Jokoa.getJokoa().tableroaSortu();
		Leihoa l = Leihoa.getLeihoa();
		l.hasieratu();
	}

	public void minakIreki(){
		tableroa.minakIreki();
	}
}