package Meatza;

import Grafikoa.Leihoa;

public class Kronometro{
	
	private static long has = 0;
	private static long gel = 0;
	private static boolean mar = false;
	private static Kronometro myKro;

	private Kronometro(){}

	public static Kronometro getKronometro(){
		if(myKro==null){
			myKro=new Kronometro();
		}
		return myKro;
	}

	private static void hasi(){
		has = System.currentTimeMillis();
		mar = true;
	}
	
	private static void gelditu(){
		gel = System.currentTimeMillis();
		mar = false;
	}
	
	public static long getDenboraTartea(){
		long tar;
		if(mar){
			tar = ((System.currentTimeMillis() - has) / 1000);
		}
		else{
			tar = ((gel - has) / 1000);
		}
		return tar;
	}

	public void hasieratu(){
		Thread t = new Thread(){
			public void run (){
				long aur=0,une;
				hasi();
				while(!Jokoa.getJokoa().galdu()&&!Jokoa.getJokoa().irabazi()&&Jokoa.getJokoa().kronHasita()){
					une=getDenboraTartea();
					if(aur!=une){
						Leihoa.getLeihoa().kronEguneratu(une);
					}
					aur=une;
				}
				gelditu();
			}
		};
		t.start();
	}

}