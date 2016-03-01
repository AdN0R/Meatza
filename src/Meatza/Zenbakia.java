package Meatza;

public class Zenbakia extends Gelaxka {
	
	private int balioa;
	private boolean begiratuta;

	public Zenbakia(int pBalioa) {
		balioa = pBalioa;
		begiratuta = false;
	}

	public void gelaxkaIreki() {
		if (!markatuta()&&!begiratuta()){
			begiratu();
			Jokoa.getJokoa().gelaxkaBatKendu();
		}
	}

	private boolean begiratuta() {
		return begiratuta;
	}

	public void zenbakiaGehitu() {
		balioa = balioa + 1;
	}

	private void begiratu() {
		begiratuta = true;
	}

}