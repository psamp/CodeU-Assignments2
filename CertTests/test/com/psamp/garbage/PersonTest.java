package com.psamp.garbage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Person p = new Person();
		p.firstName = "Jarrad";
		
		Person p2 = new Person();
		p2.firstName = "Najae";
		
		p.theOtherOne = p2;
		
		System.out.println(p.theOtherOne.firstName);
	}

}