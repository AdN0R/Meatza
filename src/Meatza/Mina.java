package Meatza;

public class Mina extends Gelaxka {
	
	public Mina() {}

	public void gelaxkaIreki(int i, int j) {
		if (!markatuta()){
			Leihoa.getLeihoa().eguneratu(i,j,this.motaItzuli());
			Jokoa.getJokoa().minakIreki();
			System.out.println("Galdu duzu"); // x segundu
			Leihoa.getLeihoa().amaitu();
		}
	}

	public int motaItzuli(){
		if (!markatuta()){
			return -1;
		}
		else return 9;
	}
}