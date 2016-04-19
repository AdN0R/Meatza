package Meatza;


public class Tableroa {
	
	private Gelaxka[][] gelaxkak;
	private int minaKop;

	public Tableroa(int i, int j, int z) {
		this.gelaxkak = new Gelaxka[j][i]; //j errenkada, i zutabe
		this.minaKop = ((gelaxkak[0].length+gelaxkak.length)/2)*z;
	}
	
	//1.Sprintaren JUnit-ak funtzionatzen duela ikusteko:
	public Tableroa(){
		this.gelaxkak = new Gelaxka[10][10];
		this.minaKop = gelaxkak[0].length;
	}

	public int getI(){
		return gelaxkak.length;
	}

	public int getJ(){
		return gelaxkak[0].length;
	}

	public int getTamaina(){
		return gelaxkak.length * gelaxkak[0].length;
	}

	public void minakJarri(){
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
		Jokoa jok = Jokoa.getJokoa();
		if(!jok.kronHasita()){
			jok.kronHasi();
		}
		if (tableroBarruan(i,j)&&!Jokoa.getJokoa().irabazi()&&!Jokoa.getJokoa().galdu()){
			gelaxkak[i][j].gelaxkaKlikatu(i,j);
		}
	}

	public void gelaxkaMarkatu(int i, int j) {
		if (tableroBarruan(i,j)){
			gelaxkak[i][j].gelaxkaMarkatu(i,j);
		}
	}

	public boolean markatuta(int pI, int pJ){
		return this.gelaxkak[pI][pJ].markatuta();
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
	
	public int gelaxkarenMotaLortu(int i, int j) {
		return gelaxkak[i][j].motaItzuli();
	}

	public int gelaxkarenAzkenMotaLortu(int i, int j) {
		return gelaxkak[i][j].azkenekoMotaItzuli();
	}
	
	
	
	//Junit-ak egiteko
//	public Gelaxka[][] getGelaxkak(){
//		return this.gelaxkak;
//	}
//	
//	public void minaJarri(int i, int j){
//		if (!(gelaxkak[i] [j] instanceof Mina)){
//			gelaxkak[i][j]=new Mina();
//			ingurukoeiBatGehitu(i, j);
//		}
//	}
//	
//	
	public void inprimatu(){
		for(int i=0; i < gelaxkak.length; i++){
			for(int j=0; j<gelaxkak[0].length; j++){
				if(gelaxkak[i][j]==null){
					System.out.print("_ ");
				}
				else{
					if(gelaxkak[i][j] instanceof Mina){
						System.out.print("M ");
					}
					else{
						if(gelaxkak[i][j] instanceof Zero){
							System.out.print("0 ");
						}
						else{
							if(gelaxkak[i][j] instanceof Zenbakia){
								System.out.print(((Zenbakia)gelaxkak[i][j]).getBalioa()+" ");
							}
						}
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}
//	

	public void klikBikoitza(int i, int j) {
		if(gelaxkak[i][j] instanceof Zenbakia){
			int kont=0;
			if(tableroBarruan(i-1, j-1)&&gelaxkak[i-1][j-1].markatuta()){
				kont++;
			}
			if(tableroBarruan(i-1, j)&&gelaxkak[i-1][j].markatuta()){
				kont++;
			}
			if(tableroBarruan(i-1, j+1)&&gelaxkak[i-1][j+1].markatuta()){
				kont++;
			}
			if(tableroBarruan(i, j-1)&&gelaxkak[i][j-1].markatuta()){
				kont++;
			}
			if(tableroBarruan(i, j+1)&&gelaxkak[i][j+1].markatuta()){
				kont++;
			}
			if(tableroBarruan(i+1, j-1)&&gelaxkak[i+1][j-1].markatuta()){
				kont++;
			}
			if(tableroBarruan(i+1, j)&&gelaxkak[i+1][j].markatuta()){
				kont++;
			}
			if(tableroBarruan(i+1, j+1)&&gelaxkak[i+1][j+1].markatuta()){
				kont++;
			}
			((Zenbakia)this.gelaxkak[i][j]).klikBikoitza(i,j,kont);
		}
	}
	
}