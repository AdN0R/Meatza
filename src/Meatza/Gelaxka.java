package Meatza;

import Grafikoa.Leihoa;

public abstract class Gelaxka {
	
	private boolean markatuta;

	public Gelaxka(){
		this.markatuta=false;
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
	
	public abstract int motaItzuli();

}