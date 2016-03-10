package Meatza;

public class Mina extends Gelaxka {
	
	public Mina() {}

	public void gelaxkaIreki() {
		if (!markatuta()){
			Jokoa.getJokoa().minaIkutu();
		}
	}

	public int motaItzuli(){
		if (!markatuta()){
			return -1;
		}
		else return 9;
	}
}