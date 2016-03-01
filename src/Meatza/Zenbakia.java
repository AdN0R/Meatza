package Meatza;

public class Zenbakia extends Gelaxka {
	
	private int balioa;
	private boolean begiratuta;

	public Zenbakia(int pBalioa) {
		balioa = pBalioa;
		begiratuta = false;
	}

	public void gelaxkaIreki() {
		if (!markatuta()&&!begiratuta){
			begiratuta = true;
			Jokoa.getJokoa().gelaxkaBatKendu();
		}
	}

	public void zenbakiaGehitu() {
		balioa = balioa + 1;
	}
}