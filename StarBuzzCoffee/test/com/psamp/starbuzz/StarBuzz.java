package com.psamp.starbuzz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.psamp.starbuzz.coffee.Beverage;
import com.psamp.starbuzz.coffee.Espresso;
import com.psamp.starbuzz.condiments.Mocha;
import com.psamp.starbuzz.condiments.Whip;

public class StarBuzz {
	Beverage beverage;

	@Before
	public void setUp() throws Exception {
		beverage = new Mocha(new Whip(new Espresso()));
	}

	@Test
	public void testCost() {
		double expected = 2.29;
		double actual = beverage.cost();
		
		assertEquals(expected, actual, .001);
	}
	
	@Test
	public void testDescription() {
		String expected = "Espresso, Whip, Mocha";
		String actual = beverage.getDescription();
		
		assertEquals(expected, actual);
	}

}
