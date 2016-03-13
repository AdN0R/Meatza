package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Grafikoa.Leihoa;
import Meatza.Gelaxka;
import Meatza.Jokoa;
import Meatza.Mina;
import Meatza.Tableroa;
import Meatza.Zenbakia;
import Meatza.Zero;

public class GelaxkaKlikatuTest {

	/**BALDINTZAK
	 * Tableroa: eraikitzailean: this.gelaxkak = new Gelaxka[5][5];
	 * 			 getGelaxkak(), inrpimatu()
	 * Zenbakia: getBalioa(), begiratuta()
	 * Zero: begiratuta()
	 */
	

	Jokoa joko;
	Tableroa tab;
	Gelaxka[][] gel;
	
	
	@Test
	public void test() {
		//Jokoa eta tableroa, eskuz, sortu
		Jokoa.main(null);
		joko=Jokoa.getJokoa();
		tab=joko.getTableroa();
		
		Leihoa lei=Leihoa.getLeihoa();
		gel=tab.getGelaxkak();
		/** 0 1 M 1 0  
			0 1 1 1 0  
			0 0 0 1 1  
			1 1 1 3 M 
			1 M 2 M M 
			
			zati hau bakarrik probatzeko gainontzekoak edozer izan daitezke,
			tableroaren eraikitzailearen arabera tamaina ezberdina egon baitaiteke
			gainontzeko zenbakiei kasurik ez
 		 */

		gel[0][0] = new Zero();
		gel[0][1] = new Zenbakia();
		gel[0][2] = new Mina();
		gel[0][3] = new Zenbakia();
		gel[0][4] = new Zero();
		gel[1][0] = new Zero();
		gel[1][1] = new Zenbakia();
		gel[1][2] = new Zenbakia();
		gel[1][3] = new Zenbakia();
		gel[1][4] = new Zero();
		gel[2][0] = new Zero();
		gel[2][1] = new Zero();
		gel[2][2] = new Zero();
		gel[2][3] = new Zenbakia();
		gel[2][4] = new Zenbakia();
		gel[3][0] = new Zenbakia();
		gel[3][1] = new Zenbakia();
		gel[3][2] = new Zenbakia();
		((Zenbakia)gel[3][2]).zenbakiaGehitu();
		gel[3][3] = new Zenbakia();
		((Zenbakia)gel[3][3]).zenbakiaGehitu();((Zenbakia)gel[3][3]).zenbakiaGehitu();
		gel[3][4] = new Mina();
		gel[4][0] = new Zenbakia();
		gel[4][1] = new Mina();
		gel[4][2] = new Zenbakia();
		((Zenbakia)gel[4][2]).zenbakiaGehitu();
		gel[4][3] = new Mina();
		gel[4][4] = new Mina();
		
		
		tab.inprimatu();
		int kont=ezBegiratutaKantitatea();
		
		assertSame(kont,20);
		
		
		assertFalse(joko.irabazi());
		assertFalse(lei.amaituta());
		
		
		
		
		//Zenbaki bat ireki
		gel[3][2].gelaxkaKlikatu(3, 2);
		kont--;
		assertSame(kont,ezBegiratutaKantitatea());
		assertTrue(((Zenbakia)gel[3][2]).begiratuta());
		assertFalse(joko.irabazi());
		assertFalse(lei.amaituta());
		
		//markatuta badago
		gel[3][3].gelaxkaMarkatu(3, 3);
		gel[3][3].gelaxkaKlikatu(3, 3);
		assertSame(kont,ezBegiratutaKantitatea());
		assertFalse(((Zenbakia)gel[3][3]).begiratuta());
		assertFalse(joko.irabazi());
		assertFalse(lei.amaituta());
		
		//Zero ireki
		//markatuta
		gel[2][2].gelaxkaMarkatu(2, 2);
		gel[2][2].gelaxkaKlikatu(2, 2);
		assertSame(kont,ezBegiratutaKantitatea());
		assertFalse(((Zero)gel[2][2]).begiratuta());
		assertFalse(joko.irabazi());
		assertFalse(lei.amaituta());
		
		
		//markatu gabe
		
		gel[2][2].gelaxkaMarkatu(2, 2);
		gel[2][2].gelaxkaKlikatu(2, 2);
		kont=kont-12;
		assertSame(kont,7);
		assertSame(kont,ezBegiratutaKantitatea());
		assertTrue(((Zero)gel[0][0]).begiratuta());
		assertTrue(((Zenbakia)gel[0][1]).begiratuta());
		assertTrue(((Zero)gel[1][0]).begiratuta());
		assertTrue(((Zenbakia)gel[1][1]).begiratuta());
		assertTrue(((Zenbakia)gel[1][2]).begiratuta());
		assertTrue(((Zenbakia)gel[1][3]).begiratuta());
		assertTrue(((Zero)gel[2][0]).begiratuta());
		assertTrue(((Zero)gel[2][1]).begiratuta());
		assertTrue(((Zero)gel[2][2]).begiratuta());
		assertTrue(((Zenbakia)gel[2][3]).begiratuta());
		assertTrue(((Zenbakia)gel[3][0]).begiratuta());
		assertTrue(((Zenbakia)gel[3][1]).begiratuta());
		assertTrue(((Zenbakia)gel[3][2]).begiratuta());
		assertFalse(((Zenbakia)gel[3][3]).begiratuta()); //Lehen markatu dugunez ez da irekiko
		assertFalse(joko.irabazi());
		assertFalse(lei.amaituta());
		
		//Partida amaitu 
		//Irabazi
		gel[3][3].gelaxkaMarkatu(3, 3);
		gel[3][3].gelaxkaKlikatu(3, 3);
		gel[0][4].gelaxkaKlikatu(0, 4);
		gel[4][0].gelaxkaKlikatu(4, 0);
		gel[4][2].gelaxkaKlikatu(4, 2);
		kont= kont-7;
		assertSame(kont,0);
		assertSame(kont,ezBegiratutaKantitatea());
		assertTrue(joko.irabazi());
		assertTrue(lei.amaituta());
		
	
		 
		
	}
	public int ezBegiratutaKantitatea(){
		int kont=0;
		for(int i=0; i < 5; i++){
			for(int j=0; j<5; j++){
				if (!(gel[i][j] instanceof Mina)){
					if((gel[i][j] instanceof Zero)){
						if(!((Zero)gel[i][j]).begiratuta()){
							kont++;
						}
					}
					else{
						if (!((Zenbakia)gel[i][j]).begiratuta()){
							kont++;
						}
					}
				}
			}
		}
		return kont;
	}

}
