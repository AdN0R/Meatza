package Meatza;

public class Zero extends Gelaxka {
	
	private int i;
	private int j;
	private boolean begiratuta;

	public Zero(int pI, int pJ) {
		i = pI;
		j = pJ;
		begiratuta = false;
	}

	public void gelaxkaIreki() {
		if (!markatuta()&&!begiratuta){
			begiratuta = true;
			Jokoa.getJokoa().gelaxkaBatKendu();
			if (!Jokoa.getJokoa().irabazi()){
				Jokoa.getJokoa().inguruaIreki(i, j);
			}
		}
	}
}