package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Meatza.Tableroa;

public class TableroaSortuTest1 {
	
	Tableroa tab;

	@Test
	public void test() {
		
		tab = new Tableroa();
		//minak jarri
		tab.minaJarri(0, 0);
		tab.inprimatu();
		tab.minaJarri(1, 2);
		tab.inprimatu();
		tab.minaJarri(2, 8);
		tab.inprimatu();
		tab.minaJarri(3, 5);
		tab.inprimatu();
		tab.minaJarri(8, 9);
		tab.inprimatu();
		tab.minaJarri(4, 6);
		tab.inprimatu();
		tab.minaJarri(5, 4);
		tab.inprimatu();
		tab.minaJarri(7, 6);
		tab.inprimatu();
		tab.minaJarri(9, 2);
		tab.inprimatu();
		tab.minaJarri(2, 0);
		tab.inprimatu();
		//mina badagoen lekuan
		tab.minaJarri(3, 5);
		tab.inprimatu();
		
		int m = tab.getMinaKop();
		assertEquals(10, m);
		
		//minak banan banan jarrita ondo egiten duela ikusita, 
		//orain metodoak(automatikoki) ondo egiten duela ikusteko:
		tab = new Tableroa();
		tab.minakJarri();
		
		//minak ipini eta gero Zeroak lehen null zeuden gelaxketan jartzen dituela ikusteko
		
		tab.zeroakJarri();
		tab.inprimatu();
		
		
	}
}
