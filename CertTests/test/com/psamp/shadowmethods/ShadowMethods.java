package com.psamp.shadowmethods;

import org.junit.Test;

class Parrot{
	void chirp(int loud) {
		System.out.print("CHIRP ");
		System.out.println("superclass");
	}
}

class Parrotlet extends Parrot {
	void chirp(long loud) {
		System.out.print("chirp ");
		System.out.println("subclass");
	}
}

public class ShadowMethods {
	@Test
	public void test() {
		Parrotlet bokeh = new Parrotlet();
		bokeh.chirp(420);
		bokeh.chirp(123_456_789_012L);
	}

}
