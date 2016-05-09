package Meatza;

import java.awt.event.MouseEvent;
import java.util.Observable;

import Grafikoa.Leihoa;

public class Jokoa extends Observable{
	
	private static Jokoa nJokoa;
	private TableroBuilder tableroBuilder;
	private Tableroa tableroa;
	private int minaKop;
	private int zenbatGelditu;
	private int zailtasuna;
	private int azkenI;
	private int azkenJ;
	private boolean galdu;
	private boolean kroHas;
	private String izena;

	private Jokoa(){
		super();
		tableroBuilder = new TableroBuilder();
	}
	
	public static Jokoa getJokoa(){
		if (nJokoa == null) {
			nJokoa = new Jokoa();
		}
		return nJokoa;
	}

	private void setIzena(String pI){
		this.izena=pI;
	}
	
	public void hasieratu(int z,String pI){
		this.setIzena(pI);
		this.tableroaSortu(z);
	}
	
	private void tableroaSortu(int z) {
		zailtasuna= z;
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

	public void minaKopGutxitu(){
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

	public void klikatu(int i, int j,MouseEvent e){
		if(e.getButton()==MouseEvent.BUTTON1){
				this.tableroa.gelaxkaIreki(i,j);
		}
		else if(e.getButton()==MouseEvent.BUTTON3){
			this.tableroa.gelaxkaMarkatu(i,j);
		}
	}
	
	public static void main (String[] args){
		Leihoa.getLeihoa().hasiera();
		try{
			Ranking.getRanking().kargatu();
		}
		catch (Exception e){
			System.out.println("Ranking-a ez da kargatu");
		}
	}


	public int getAzkenI(){
		return this.azkenI;
	}

	public int getAzkenJ(){
		return this.azkenJ;
	}
	
	public int gelaxkarenMotaLortu(int i, int j){
		return this.tableroa.gelaxkarenMotaLortu(i,j);
	}
	
	public void jokoaGaldu(){
		this.galdu = true;
	}
	
	public boolean galdu(){
		return this.galdu;
	}

	public void aldatuDa(int i, int j) {
		azkenI=i;
		azkenJ=j;
		this.setChanged();
		notifyObservers();
	}

	public int gelaxkarenAzkenMotaLortu(int i, int j) {
		return this.tableroa.gelaxkarenAzkenMotaLortu(i,j);
	}
	
	public int getMinaKop(){
		return minaKop;
	}

	public void klikBikoitza(int i, int j) {
		this.tableroa.klikBikoitza(i,j);
	}
	
	public void tableroaErreseteatu(){
		this.tableroaSortu(zailtasuna);
		Leihoa.getLeihoa().jokoNagusiaSortu();
		galdu=false;
		kroHas=false;
	}
	
	public boolean kronHasita(){
		return kroHas;
	}
	
	public void kronHasi(){
		kroHas=true;
		Kronometro.getKronometro().hasieratu();
	}
	
	public int getZailtasuna(){
		return this.zailtasuna;
	}
	
	public String getIzena(){
		return this.izena;
	}

}