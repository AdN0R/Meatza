package Meatza;

public class Zero extends Gelaxka {
	
	private boolean begiratuta;

	public Zero() {
		begiratuta = false;
	}

	public void gelaxkaIreki(int i, int j) {
		if (!markatuta()&&!begiratuta){
			begiratuta = true;
			Jokoa.getJokoa().gelaxkaBatKendu();
			Leihoa.getLeihoa().eguneratu(i,j,this.motaItzuli());
			if (!Jokoa.getJokoa().irabazi()){
				Jokoa.getJokoa().inguruaIreki(i, j);
			}
			else {
				System.out.println("Zorionak, irabazi duzu!!"); // x segundutan
			}
		}
	}
	
	public int motaItzuli(){
		if (!markatuta()&&!begiratuta){
			return 0;
		}
		else return 9;
	}
}