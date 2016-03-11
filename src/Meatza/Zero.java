package Meatza;

import Grafikoa.Leihoa;

public class Zero extends Gelaxka {
	
	private boolean begiratuta;

	public Zero(){
		super();
		begiratuta = false;
	}

	public void gelaxkaKlikatu(int i, int j) {
		if (!markatuta()&&!begiratuta){
			begiratuta = true;
			Jokoa.getJokoa().gelaxkaBatKendu();
			Leihoa.getLeihoa().eguneratu(i,j,this.motaItzuli());
			if (!Jokoa.getJokoa().irabazi()){
				Jokoa.getJokoa().inguruaIreki(i, j);
			}
			else {
				System.out.println("Zorionak, irabazi duzu!!"); // x segundutan
				Leihoa.getLeihoa().amaitu();
			}
		}
	}

	public void gelaxkaMarkatu(int i, int j){
		if(this.begiratuta){}
		else{
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
	}

	public int motaItzuli(){
		if (!markatuta()){
			return 0;
		}
		else return 11;
	}
}