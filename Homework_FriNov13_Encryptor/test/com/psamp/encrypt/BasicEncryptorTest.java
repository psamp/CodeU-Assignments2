package com.psamp.encrypt;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class BasicEncryptorTest {

	Encryptor basic;

	@Before
	public void setUp() throws Exception {
		basic = new BasicEncryptor();
	}

	@Test
	public void encryptTest() {
		String expected = "OLLEH";
		String actual = basic.encrypt("hEllO");
		
		assertEquals(true, actual.contains(expected));
	}
	
	@Test
	public void encryptShiftTest() {
		String expected = "psonsam";
		String actual = basic.encrypt("sampson", 3);
		
		assertEquals(true, actual.contains(expected));
	}
	
	@Test
	public void decryptTest() {
		String expected = "hello";
		String actual = basic.decrypt("OLLEH");
		
		assertEquals(true, actual.contains(expected));
	}

	@Test
	public void encryptScanner() {
		Scanner scn = new Scanner(System.in);
		try {
			System.out.println("Enter word to encrypt: ");
			System.out.println(basic.encrypt(scn.next()));
		} finally {
			scn.close();
		}
	}

}
