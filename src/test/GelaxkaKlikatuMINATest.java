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

public class GelaxkaKlikatuMINATest {

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
		//MINA bat ikutzeko funtzionantzen baduen ikusteko berriro sortu dena
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

				//Mina markatuta
				gel[0][2].gelaxkaMarkatu(0, 2);
				gel[0][2].gelaxkaKlikatu(0, 2);
				assertFalse(joko.irabazi());
				assertFalse(lei.amaituta());
				
				//Mina ireki
				gel[3][4].gelaxkaKlikatu(3, 4);
				assertFalse(joko.irabazi());
				assertTrue(lei.amaituta());
				
			}
			
	

}
