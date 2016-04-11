package Meatza;

public class TableroBuilder {
	
	private Tableroa tableroa;

	public TableroBuilder() {
		// TODO
	}

	public void tableroaSortu(int z) {
		int i=0;
		int j=0;
		if (z==1 || z==2 || z==3){
			if (z==1){
				j=7;
				i=10;
			}
			if(z==2){
				j=10;
				i=15;
			}
			if(z==3){
				j=12;
				i=25;
			}

			tableroa = new Tableroa(i,j,z);
			tableroa.minakJarri();
			tableroa.zeroakJarri();
		}
		
		
		
	}
	
	public Tableroa getTablero(){
		return tableroa;
	}

}