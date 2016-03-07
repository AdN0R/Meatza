package Meatza;

public class Jokoa {
	
	private static Jokoa nJokoa;
	private TableroBuilder tableroBuilder;
	private Tableroa tableroa;
	private int minaKop;
	private int zenbatGelditu;
	private boolean minaIkutu;
	
	private Jokoa(){
		tableroBuilder = new TableroBuilder();
		minaIkutu = false;
	}
	
	public static Jokoa getJokoa(){
		if (nJokoa == null) {
			nJokoa = new Jokoa();
		}
		return nJokoa;
	}
	
	public void setBuilder (TableroBuilder tB){
		tableroBuilder = tB;
	}
	
	public Tableroa getTableroa(){
		return tableroa;
	}
	
	private void tableroaSortu() {
		tableroBuilder.tableroaSortu();
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
		else {
			return false;
		}
	}

	public void minaIkutu() {
		// TODO
	}

}