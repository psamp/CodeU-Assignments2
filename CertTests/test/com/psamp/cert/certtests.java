package com.psamp.cert;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class certtests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int x = 5;
		int y = 6;

		if (x + y > 10)
			if (x < 5)
				if (x > 7)
					System.out.println("a ");
				else
					System.out.println("b ");
			// System.out.println("c ");
			else
				System.out.println("d");

	}

	@Test
	public void testOne() {
		int x = 0;
		int y = 11;
		do {
		} while (x++ < y);		
		while (x++ < y){
			System.out.println(x);
		}
	}
	
	@Test
	public void testTwo() {
		String s = "MINIMUM";
		
		System.out.println(s.length());
		System.out.println(s.substring(4, 7));
		System.out.println(s.substring(0, 3));
	}

}
