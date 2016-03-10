package Meatza;

public class Zenbakia extends Gelaxka {
	
	private int balioa;
	private boolean begiratuta;

	public Zenbakia() {
		balioa = 1;
		begiratuta = false;
	}

	public void gelaxkaIreki() {
		if (!markatuta()&&!begiratuta){
			begiratuta = true;
			Jokoa.getJokoa().gelaxkaBatKendu();
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