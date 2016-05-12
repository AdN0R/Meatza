package Meatza;

public abstract class Gelaxka {
	
	private boolean markatuta;
	private boolean begiratuta;

	public Gelaxka(){
		this.markatuta=false;
		this.begiratuta = false;
	}

	public abstract void gelaxkaKlikatu(int i, int j);

	public void gelaxkaMarkatu(int i, int j){
		if(!this.begiratuta()){
			if(this.markatuta()){
				Jokoa.getJokoa().minaKopHanditu();
				this.markatu();
			}
			else{
				if(!Jokoa.getJokoa().minaKopHutsa()){
					Jokoa.getJokoa().minaKopGutxitu();
					this.markatu();
				}
			}
		}
		Jokoa.getJokoa().aldatuDa(i, j);
	}

	protected boolean markatuta(){
		return markatuta;
	}

	private void markatu(){
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