package Meatza;

public class Zero extends Gelaxka {
	
	
	public Zero(){
		super();
	}

	public void gelaxkaKlikatu(int i, int j) {
		if (!markatuta()&&!begiratuta()){
			this.setBegiratuta(true);
			Jokoa.getJokoa().gelaxkaBatKendu();
			Jokoa.getJokoa().aldatuDa(i, j);
			if (!Jokoa.getJokoa().irabazi()){
				Jokoa.getJokoa().inguruaIreki(i, j);
			}
			
		}
	}

	public int motaItzuli(){
		if (begiratuta()){	
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

	@Override
	public int azkenekoMotaItzuli() {
		return this.motaItzuli();
	}
	
	
	
	
	//junit eiteko
//	public boolean begiratuta(){
//		return begiratuta;
//	}
	
}