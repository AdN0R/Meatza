package Meatza;

import Grafikoa.Leihoa;

public abstract class Gelaxka {
	
	private boolean markatuta;
	private boolean begiratuta;

	public Gelaxka(){
		this.markatuta=false;
		this.begiratuta = false;
	}

	public abstract void gelaxkaKlikatu(int i, int j);

	public abstract void gelaxkaMarkatu(int i, int j); // Hobe daiteke ?

	protected boolean markatuta(){
		return markatuta;
	}

	protected void markatu(){
		if(this.markatuta){
			this.markatuta=false;
		}
		else{
			this.markatuta=true;
		}
	}
	
	protected boolean begiratuta(){
		return this.begiratuta;
	}
	
	protected void setBegiratuta(boolean pBegiratu){
		this.begiratuta = pBegiratu;
	}
	
	public abstract int motaItzuli();

	public abstract int azkenekoMotaItzuli();

}