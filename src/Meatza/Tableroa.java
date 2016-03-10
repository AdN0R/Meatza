package Meatza;

import java.util.Observable;

public class Tableroa {
	
	private Gelaxka[][] gelaxkak;
	private int minaKop;

	public Tableroa() {
		this.gelaxkak = new Gelaxka[10][10];
		this.minaKop = gelaxkak[0].length;
	}
	
	public int getTamaina(){
		return gelaxkak.length * gelaxkak[0].length;
	}
	public void minakJarri() {
		int m = 0;
		int i;
		int j;
		while (minaKop != m){
			i = (int)((double)this.gelaxkak.length*Math.random());
			j = (int)((double)this.gelaxkak[0].length*Math.random());
			if (!(gelaxkak[i] [j] instanceof Mina)){
				gelaxkak[i][j]=new Mina();
				ingurukoeiBatGehitu(i, j);
				m = m+1;
			}
		}
	}
	
	public int getMinaKop(){
		return minaKop;
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
					gelaxkak[i][j]=new Zero();
				}
				j++;
			}
			i++;
		}
	}
	
	public void inguruaIreki(int i, int j) {
		gelaxkaIreki(i-1, j-1);
		gelaxkaIreki(i-1, j);
		gelaxkaIreki(i-1, j+1);
		gelaxkaIreki(i, j-1);
		gelaxkaIreki(i, j+1);
		gelaxkaIreki(i+1, j-1);
		gelaxkaIreki(i+1, j);
		gelaxkaIreki(i+1, j+1);
	}

	public void gelaxkaIreki(int i, int j) {
		if (tableroBarruan(i,j)){
			gelaxkak[i][j].gelaxkaIreki(i,j);
		}
	}
	
	private boolean tableroBarruan(int i, int j){
		if (((i>=0)&&(i<gelaxkak.length))&&((j>=0)&&(j<gelaxkak[0].length))){
			return true;
		}
		else{
			return false;
		}
	}

	public int motaItzuli(int i, int j){
		return gelaxkak[i][j].motaItzuli();
	}
	
	public void minakIreki(){
		int i=0;
		int j=0;
		while (tableroBarruan(i,j)){
			while (tableroBarruan(i,j)){
				if (motaItzuli(i,j)==-1){
					Leihoa.getLeihoa.eguneratu(i,j,-1);
				}
				j++;
			}
			j=0;
			i++;
		}
	}
}