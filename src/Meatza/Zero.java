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
			Jokoa.getJokoa().aldatuDa(i, j);
			if (!Jokoa.getJokoa().irabazi()){
				Jokoa.getJokoa().inguruaIreki(i, j);
			}
			
		}
	}

	public void gelaxkaMarkatu(int i, int j){
		if(!this.begiratuta){
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
		if (begiratuta){	
				return 0;			
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
	
	
	
	
	//junit eiteko
//	public boolean begiratuta(){
//		return begiratuta;
//	}
	
}