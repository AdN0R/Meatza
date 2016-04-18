package Meatza;

import Grafikoa.Leihoa;

public class Zenbakia extends Gelaxka {
	
	private int balioa;

	public Zenbakia(){
		super();
		balioa = 1;
	}

	public void gelaxkaKlikatu(int i, int j) {
		if (!markatuta()&&!begiratuta()){
			this.setBegiratuta(true);
			Jokoa.getJokoa().gelaxkaBatKendu();
			Jokoa.getJokoa().aldatuDa(i, j);
		}
	}

	public void gelaxkaMarkatu(int i, int j){
		if(!this.begiratuta()){
			if(this.markatuta()){
				Jokoa.getJokoa().minaKopHanditu();
				this.markatu();
			}
			else{
				if(!Jokoa.getJokoa().minaKopHutsa()){
					Jokoa.getJokoa().minaKopGutxitu();
					this.markatu();
				}
			}
		}
		Jokoa.getJokoa().aldatuDa(i, j);
	}

	public int motaItzuli(){
		if (begiratuta()){	
			return balioa;			
		}
		else{
			if(!markatuta()){
				return 10;
			}
			else{
				return 9;
			}		
		}
	}

	public void zenbakiaGehitu() {
		balioa = balioa + 1;
	}

	@Override
	public int azkenekoMotaItzuli() {
		return this.motaItzuli();
	}
	
	
	//Junit egiteko
	public int getBalioa(){
		return this.balioa;
	}
//	
//	public boolean begiratuta(){
//		return begiratuta;
//	}
	
}