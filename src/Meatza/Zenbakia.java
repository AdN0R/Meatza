package Meatza;

import Grafikoa.Leihoa;

public class Zenbakia extends Gelaxka {
	
	private int balioa;
	private boolean begiratuta;

	public Zenbakia(){
		super();
		balioa = 1;
		begiratuta = false;
	}

	public void gelaxkaKlikatu(int i, int j) {
		if (!markatuta()&&!begiratuta){
			begiratuta = true;
			Jokoa.getJokoa().gelaxkaBatKendu();
			Leihoa.getLeihoa().eguneratu(i,j,this.motaItzuli());
			if (Jokoa.getJokoa().irabazi()){
				System.out.println("Zorionak, irabazi duzu!!"); // x segundutan
				Leihoa.getLeihoa().amaitu();
			}
		}
	}

	public void gelaxkaMarkatu(int i, int j){
		if(!this.begiratuta){
			if(this.markatuta()){
				Jokoa.getJokoa().minaKopHanditu();
				Leihoa.getLeihoa().eguneratu(i,j,10);
				this.markatu();
			}
			else{
				if(!Jokoa.getJokoa().minaKopHutsa()){
					Jokoa.getJokoa().minaKopGutxitu();
					Leihoa.getLeihoa().eguneratu(i,j,9);
					this.markatu();
				}
			}
		}
	}

	public int motaItzuli(){
		if (!markatuta()){
			return balioa;
		}
		else return 11;
	}

	public void zenbakiaGehitu() {
		balioa = balioa + 1;
	}
	
	
	//Junit egiteko
	public int getBalioa(){
		return this.balioa;
	}
	
	public boolean begiratuta(){
		return begiratuta;
	}
	
}