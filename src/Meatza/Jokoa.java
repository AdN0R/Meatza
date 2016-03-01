package Meatza;

public class Jokoa {
	
	private static Jokoa nJokoa;
	private Tableroa tableroa;
	private int minaKop;
	private int zenbatGelditu;
	private boolean minaIkutu;
	
	private Jokoa(){
		
	}
	
	public static Jokoa getJokoa(){
		if (nJokoa == null) {
			nJokoa = new Jokoa();
		}
		return nJokoa;
	}
	
	public void setBuilder (TableroBuilder tB){
		//TODO
	}
	
	public Tableroa getTableroa(){
		return tableroa;
	}
	
	private void tableroaSortu() {
		// TODO
	}

	public void inguruaIreki(int i, int j) {
		tableroa.inguruaIreki(i-1, j-1);
		tableroa.inguruaIreki(i-1, j);
		tableroa.inguruaIreki(i-1, j+1);
		tableroa.inguruaIreki(i, j-1);
		tableroa.inguruaIreki(i, j+1);
		tableroa.inguruaIreki(i+1, j-1);
		tableroa.inguruaIreki(i+1, j);
		tableroa.inguruaIreki(i+1, j+1);
	}

	public void gelaxkaBatKendu() {
		zenbatGelditu--;
	}

	public boolean irabazi() {
		if (zenbatGelditu==0){
			return true;
		}
		else return false;
	}

	public void minaIkutu() {
		// TODO
	}

}