package Meatza;

public class Zenbakia extends Gelaxka {
	
	private int balioa;
	private boolean begiratuta;

	public Zenbakia() {
		balioa = 1;
		begiratuta = false;
	}

	public void gelaxkaIreki(int i, int j) {
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
	
	public int motaItzuli(){
		if (!markatuta() && (!begiratuta)){
			return balioa;
		}
		else return 9;
	}

	public void zenbakiaGehitu() {
		balioa = balioa + 1;
	}
}