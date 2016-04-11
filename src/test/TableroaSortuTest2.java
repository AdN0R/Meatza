package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Meatza.TableroBuilder;
import Meatza.Tableroa;

public class TableroaSortuTest2 {
	
	@Test
	public void test() {
		TableroBuilder tb;
		tb = new TableroBuilder();
		
		//zailtasuna 1 izanik
		tb.tableroaSortu(1);
		Tableroa tab = tb.getTablero();
		int m = tab.getMinaKop();
		assertEquals(8, m);
		tab.inprimatu();
		
		tb = new TableroBuilder();
		
		//zailtasuna 2 izanik
		tb.tableroaSortu(2);
		tab = tb.getTablero();
		m = tab.getMinaKop();
		assertEquals(24, m);
		tab.inprimatu();
		
		tb = new TableroBuilder();
		
		//zailtasuna 3 izanik
		tb.tableroaSortu(3);
		tab = tb.getTablero();
		m = tab.getMinaKop();
		assertEquals(54, m);
		tab.inprimatu();
		
	}

}
