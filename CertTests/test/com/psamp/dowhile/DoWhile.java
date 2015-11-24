package com.psamp.dowhile;

import org.junit.Before;
import org.junit.Test;

public class DoWhile {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int I = 1;
		do while (I < 1)
				System.out.println("I is " + I);
		while (I > 1);
	}

}
