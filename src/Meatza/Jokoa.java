package Meatza;

import java.awt.event.MouseEvent;

import Grafikoa.Leihoa;
import Grafikoa.Menu;

public class Jokoa {
	
	private static Jokoa nJokoa;
	private TableroBuilder tableroBuilder;
	private Tableroa tableroa;
	private int minaKop;
	private int zenbatGelditu;
	private int zailtasuna;

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
	
	public void tableroaSortu(int z) {
		tableroBuilder.tableroaSortu(z);
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
	
	public void minaKopHanditu(){
		this.minaKop++;
	}
	
	public boolean minaKopHutsa(){
		return minaKop==0;
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
		Leihoa.getLeihoa().hasiera();
	}

	public void minakIreki(){
		tableroa.minakIreki();
	}
}