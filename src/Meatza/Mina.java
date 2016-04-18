package Meatza;


public class Mina extends Gelaxka {


	
	public Mina(){
		super();
	}

	public void gelaxkaKlikatu(int i, int j) {
		if (!markatuta()){
			this.setBegiratuta(true);
			Jokoa.getJokoa().jokoaGaldu();
			Jokoa.getJokoa().aldatuDa(i, j);
		}
	}

	public void gelaxkaMarkatu(int i, int j){
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
		Jokoa.getJokoa().aldatuDa(i, j);
	}

	public int motaItzuli(){
		if (!markatuta()){
			if (begiratuta()){
				return -1;
			}
			return 10;
		}
		else return 9;
	}
	
	public int azkenekoMotaItzuli(){
		if (!markatuta()){
			return -1;
		}
		else return 9;
	}
	



}