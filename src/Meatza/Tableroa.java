package Meatza;

public class Tableroa {
	
	private Gelaxka[][] gelaxkak;

	public Tableroa() {
		this.gelaxkak = new Gelaxka[10][10];
	}
	
	public void minakJarri() {
		int m = 0;
		int i;
		int j;
		int minakop= gelaxkak[0].length;
		while (minakop != m){
			i = (int)((double)this.gelaxkak.length*Math.random());
			j = (int)((double)this.gelaxkak[0].length*Math.random());
			if (tableroBarruan(i, j) && !(gelaxkak[i] [j] instanceof Mina)){
				gelaxkak[i][j]=new Mina();
				ingurukoeiBatGehitu(i, j);
				m = m+1;
			}
		}
	}
	
	private void ingurukoeiBatGehitu(int i, int j){
		 batGehitu(i-1,j-1);
		 batGehitu(i,j-1);
		 batGehitu(i+1,j-1);
		 batGehitu(i-1,j);
		 batGehitu(i+1,j);
		 batGehitu(i-1,j+1);
		 batGehitu(i,j+1);
		 batGehitu(i+1,j+1);
	}
	
	private void batGehitu(int i, int j){
		if (tableroBarruan(i, j) && !(gelaxkak[i][j] instanceof Mina)){
			if (gelaxkak[i][j] instanceof Zenbakia){
				Zenbakia a = (Zenbakia)gelaxkak[i][j];
				a.zenbakiaGehitu();
			}
			else {gelaxkak[i][j] =new Zenbakia();}
		}
	}
	
	public void zeroakJarri() {
		int i = 0;
		while (tableroBarruan(i,0)){
			int j = 0;
			while(tableroBarruan(i,j)){
				if (tableroBarruan(i, j) && gelaxkak[i][j] == null){
					gelaxkak[i][j]=new Zero(i, j);
				}
				j++;
			}
			i++;
		}
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