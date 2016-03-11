package Meatza;

import Grafikoa.Leihoa;

public class Mina extends Gelaxka {

	public Mina(){
		super();
	}

	public void gelaxkaKlikatu(int i, int j) {
		if (!markatuta()){
			Leihoa.getLeihoa().eguneratu(i,j,this.motaItzuli());
			Jokoa.getJokoa().minakIreki();
			System.out.println("Galdu duzu"); // x segundu
			Leihoa.getLeihoa().amaitu();
		}
	}

	public void gelaxkaMarkatu(int i, int j){
		if(this.markatuta()){
			Jokoa.getJokoa().minaKopGutxitu();
			Leihoa.getLeihoa().eguneratu(i,j,10);
			this.markatu();
		}
		else{
			Jokoa.getJokoa().minaKopGutxitu();
			Leihoa.getLeihoa().eguneratu(i,j,9);
			this.markatu();
		}
	}

	public int motaItzuli(){
		if (!markatuta()){
			return -1;
		}
		else return 9;
	}
}