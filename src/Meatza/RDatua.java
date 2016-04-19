package Meatza;

public class RDatua {
	
	private String izena;
	private int denbora;
	private int maila;

	public RDatua(String pI, int pD, int pM){
		this.izena=pI;
		this.denbora=pD;
		this.maila=pM;
	}

	public String getIzena(){
		return this.izena;
	}

	public int getDenbora(){
		return this.denbora;
	}

	public int getMaila(){
		return this.maila;
	}

}