package Meatza;

public class Tableroa {
	
	private Gelaxka[][] gelaxkak;

	public Tableroa() {
		// TODO
	}

	public void inguruaIreki(int i, int j) {
		if (tableroBarruan(i,j)){
			gelaxkaIreki(i, j);
		}
	}

	public void gelaxkaIreki(int i, int j) {
		// TODO
	}
	
	private boolean tableroBarruan(int i, int j){
		if (((i>=0)&&(i<gelaxkak.length))&&((j>=0)&&(j<gelaxkak[0].length))){
			return true;
		}
		else{
			return false;
		}
	}

}