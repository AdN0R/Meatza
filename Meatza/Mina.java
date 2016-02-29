package Meatza;

public class Mina extends Gelaxka {
	
	public Mina() {}

	public void gelaxkaIreki() {
		if (!markatuta()){
			Tableroa t = Jokoa.getJokoa().getTableroa();
			Jokoa.getJokoa().minaIkutu();
		}
	}

}