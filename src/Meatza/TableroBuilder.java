package Meatza;

public class TableroBuilder {
	
	private Tableroa tableroa;

	public TableroBuilder() {
		// TODO
	}

	public void tableroaSortu() {
		tableroa = new Tableroa();
		tableroa.minakJarri();
		tableroa.zeroakJarri();
		
	}
	
	public Tableroa getTablero(){
		return tableroa;
	}

}