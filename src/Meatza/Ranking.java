package Meatza;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ranking {
	
	private RDatua[] rank;
	private static Ranking myRanking=null;

	private Ranking(){
		this.rank=new RDatua[30];
	}

	public static Ranking getRanking(){
		if(myRanking==null){
			myRanking=new Ranking();
		}
		return myRanking;
	}


    public static void kargatu() throws Exception{
    	File f = new File("meatza-ranking.txt");
        FileReader fr = new FileReader(f);
        Scanner fitx = new Scanner(fr);
        String[] lerroak;
        int zb=0;
        while(fitx.hasNext()){
        	lerroak = fitx.nextLine().split(" ### ");
        	Ranking r = Ranking.getRanking();
        	r.rank[zb]=new RDatua(lerroak[0],(int)Integer.parseInt(lerroak[1]),(int)Integer.parseInt(lerroak[2]));
        	zb++;
        }
        fitx.close();
    }
    
    public void konprobatu(RDatua pDatua){
    	int i=0;
    	int m=0;
    	if (pDatua.getMaila()==1){
    		m=0;
    	}
    	if (pDatua.getMaila()==2){
    		m=10;
    	}
    	if (pDatua.getMaila()==3){
    		m=20;
    	}
    	boolean atera=false;
    	while ((i<10+m)&&!(atera)){
    		if (pDatua.getDenbora() < this.rank[i+m].getDenbora()){
    			this.eguneratu(pDatua,i,m);
    			atera = true;
    		}
    		i++;
    	}
    }
    
    private void eguneratu(RDatua pDatua, int i, int m){
    	RDatua aux = pDatua;
		while (i+m<9+m){
			RDatua aux2 = this.rank[i+m];
			this.rank[i+m] = aux;
			aux = aux2;
			i++;
		}
		this.rank[9+m] = aux;
    }


    //Frogak egiteko
    /*public void inprimatu(){
    	for(int i=0; i<this.rank.length; i++){
    		System.out.println(i+" : "+this.rank[i].getIzena()+" - "+this.rank[i].getDenbora()+" - "+this.rank[i].getMaila());
    	}
    }*/

    public static void gorde(){
    	try{
    		FileWriter writer = new FileWriter("meatza-ranking.txt");
    		Ranking r = Ranking.getRanking();
    		for(int i=0; i<r.rank.length; i++){
    			writer.write(r.rank[i].getIzena()+" ### "+r.rank[i].getDenbora()+" ### "+r.rank[i].getMaila()+"\n");
    		}
    		writer.close();
    		System.out.println("Ranking-a gordeta.");
    	}catch(Exception e){
    		System.out.println("Errorea Ranking-a gordetzean.");
        }
    }
    
    public RDatua[] getZerrenda(){
    	return this.rank;
    }

}